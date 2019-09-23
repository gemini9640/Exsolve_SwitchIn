package com.exl_si.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.exl_si.common.ServerResponse;
import com.exl_si.db.Event;
import com.exl_si.db.EventPicture;
import com.exl_si.db.vo.SubFile;
import com.exl_si.enums.EventEnums;
import com.exl_si.enums.EventEnums.PictureType;
import com.github.pagehelper.PageInfo;

public interface EventService {
	public ServerResponse<Event> save(Event event);
	
	public ServerResponse<Event> queryById(String id);
	
	public ServerResponse<PageInfo> queryByMerchant(String merchantId, Integer pageNum, Integer pageSize);
	
	public ServerResponse<PageInfo> queryByProperties(Map<String, Object> properties, Integer pageNum, Integer pageSize);

	public ServerResponse updateStatus(String id, EventEnums.STATUS status);
	
	public ServerResponse update(Event event);
	
	public ServerResponse<Event> query(String id);
	
	public ServerResponse uploadSingleDoc(MultipartHttpServletRequest request, String eventId, String type);
	
	public ServerResponse<List<SubFile>> uploadPicture(MultipartHttpServletRequest request, String merchantId, String eventId, PictureType type);
	
	public List<EventPicture> selectPictureByEventIdAndType(String eventId, String type);
}
