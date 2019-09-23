package com.exl_si.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.exl_si.common.AppProperties;
import com.exl_si.common.ServerResponse;
import com.exl_si.db.Event;
import com.exl_si.db.EventPicture;
import com.exl_si.db.vo.SubFile;
import com.exl_si.db.vo.FileObjectProvider.FileObjectEnums;
import com.exl_si.enums.EventEnums;
import com.exl_si.enums.EventEnums.PictureType;
import com.exl_si.exception.UploadException;
import com.exl_si.helper.EventHelper;
import com.exl_si.helper.SequenceNoHelper;
import com.exl_si.mapper.EventMapper;
import com.exl_si.mapper.EventPictureMapper;
import com.exl_si.mapper.SIMerchantMapper;
import com.exl_si.mapper.SequenceNoMapper;
import com.exl_si.service.EventService;
import com.exl_si.utils.DeleteFileUtil;
import com.exl_si.utils.UploadUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("eventService")
public class EventServiceImpl implements EventService{
	@Autowired
	private EventMapper eventMapper;
	@Autowired
	private EventPictureMapper eventPictureMapper;
	@Autowired
	private SIMerchantMapper merchantMapper;
	@Autowired
	private SequenceNoMapper sequenceNoMapper;
	
	public ServerResponse<Event> save(Event event) {
		if(merchantMapper.selectByPrimaryKey(event.getMerchantId()) ==null)
			return ServerResponse.createByServerError("merchantId not valid");
		if(eventMapper.selectByName(event.getEventname()) != null)
			return ServerResponse.createByServerError("event title is duplicated");
		SequenceNoHelper.setEventSequenceId(event, sequenceNoMapper);
		if(eventMapper.insertSelective(event)>0) {
			SequenceNoHelper.updateEventSequenceNo(sequenceNoMapper);
			return ServerResponse.createBySuccess(event);
		} else 
			return ServerResponse.createByServerError("create fail");
	}
	
	public ServerResponse<Event> queryById(String id) {
		Event event = eventMapper.selectByPrimaryKey(id);
		if(event == null)
			return ServerResponse.createByServerError("event not found");
		return ServerResponse.createBySuccess(event);
	}
	
	public ServerResponse<PageInfo> queryByMerchant(String merchantId, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Event> list = eventMapper.selectByMerchant(merchantId);
		return ServerResponse.createBySuccess(new PageInfo(list));
	} 
	
	public ServerResponse<PageInfo> queryByProperties(Map<String, Object> properties, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Event> list = eventMapper.selectByPropertiesSelective(properties);
		return ServerResponse.createBySuccess(new PageInfo(list));
	}
	
	public ServerResponse updateStatus(String id, EventEnums.STATUS status) {
		if(eventMapper.updateStatus(id, status.getCode())>0)
			return ServerResponse.createBySuccess();
		else 
			return ServerResponse.createByServerError("approve fail");
	}
	
	public ServerResponse update(Event event) {
		if(eventMapper.updateByPrimaryKeySelective(event)>0)
			return ServerResponse.createBySuccess(event);
		else 
			return ServerResponse.createByServerError("update fail");
	}
	
	public ServerResponse<Event> query(String id) {
		Event event = eventMapper.selectByPrimaryKey(id);
		if(event == null)
			return ServerResponse.createByServerError("event not found");
		return ServerResponse.createBySuccess(event);
	}
	
	public ServerResponse<List<SubFile>> uploadPicture(MultipartHttpServletRequest request, String merchantId, String eventId, PictureType type) {
		String baseFolder = AppProperties.UPLOAD_PATH+"/si_merchant/"+merchantId+"/event/"+type.getDesc()+"/";
		try {
			List<SubFile> uploadedFiles = UploadUtil.uploadFileByIOStream(request, baseFolder, FileObjectEnums.EVENT_PICTURE);
			if(uploadedFiles != null && !uploadedFiles.isEmpty()) {
				if(eventPictureMapper.batchInsert(EventHelper.assembleInitPicture(eventId, type.getDesc(), uploadedFiles)) > 0)
					return ServerResponse.createBySuccess(uploadedFiles);
			} 
			return ServerResponse.createByErrorMsg("no picture to upload.");
		} catch (UploadException ue) {
			if(ue.getIoe() != null) {
				ue.getIoe().printStackTrace();
				if(ue.getPath() != null)
					DeleteFileUtil.delete(ue.getPath());
			} else 
				ue.printStackTrace();
			return ServerResponse.createByErrorMsg(ue.getMessage());
		} catch (InstantiationException e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMsg(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMsg(e.getMessage());
		} 
	}
	
	public List<EventPicture> selectPictureByEventIdAndType(String eventId, String type) {
		return eventPictureMapper.selectByEventIdAndType(eventId, type);
	}
	
	public ServerResponse uploadSingleDoc(MultipartHttpServletRequest request, String eventId, String type) {
		String baseFolder = AppProperties.UPLOAD_PATH+"/event/"+eventId+"/"+type+"/";
		try {
			List<EventPicture> list = eventPictureMapper.selectByEventIdAndType(eventId, type);
			//一个类型只允许上传一个文件
			EventPicture picture = null;
			if(list != null && list.size()> 0)
				picture = list.get(0);
			List<SubFile> uploadedFiles = UploadUtil.uploadFileByIOStream(request, baseFolder, FileObjectEnums.EVENT_PICTURE);
			if(uploadedFiles != null && !uploadedFiles.isEmpty()) {
				if(picture != null) {
					//重复上传会删掉原本的文件
					DeleteFileUtil.delete(AppProperties.UPLOAD_PATH+picture.getPath());
					eventPictureMapper.updateByPrimaryKeySelective(EventHelper.assembleEdittedPicture(picture, uploadedFiles));
					return ServerResponse.createBySuccess(uploadedFiles.get(0));
				}else if(eventPictureMapper.batchInsert(EventHelper.assembleInitPicture(eventId, type, uploadedFiles)) > 0)
					return ServerResponse.createBySuccess(uploadedFiles.get(0));
			} else if(picture != null)
				return ServerResponse.createBySuccess("no file to upload", picture);
			return ServerResponse.createByErrorMsg("nothing to do for uploading profile picture!");
		} catch (UploadException ue) {
			if(ue.getIoe() != null) {
				ue.getIoe().printStackTrace();
				if(ue.getPath() != null)
					DeleteFileUtil.delete(ue.getPath());
			} else 
				ue.printStackTrace();
			return ServerResponse.createByErrorMsg(ue.getMessage());
		} catch (InstantiationException e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMsg(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMsg(e.getMessage());
		} 
	}
}
