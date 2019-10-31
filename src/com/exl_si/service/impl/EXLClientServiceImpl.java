package com.exl_si.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.exl_si.common.AppProperties;
import com.exl_si.common.ServerResponse;
import com.exl_si.db.EXLClient;
import com.exl_si.db.EXLClientFile;
import com.exl_si.db.vo.SubFile;
import com.exl_si.enums.EXLClientEnums.FileType;
import com.exl_si.db.vo.FileObjectProvider.FileObjectEnums;
import com.exl_si.exception.UploadException;
import com.exl_si.helper.EXLClientHelper;
import com.exl_si.helper.SequenceNoHelper;
import com.exl_si.helper.ServiceHelper;
import com.exl_si.mapper.EXLAgentMapper;
import com.exl_si.mapper.EXLClientFileMapper;
import com.exl_si.mapper.EXLClientMapper;
import com.exl_si.mapper.SIMemberMapper;
import com.exl_si.mapper.SIMerchantMapper;
import com.exl_si.mapper.SequenceNoMapper;
import com.exl_si.service.EXLClientService;
import com.exl_si.utils.DeleteFileUtil;
import com.exl_si.utils.UploadUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("exlClientService")
public class EXLClientServiceImpl implements EXLClientService{
	@Autowired
	private EXLClientMapper exlClientMapper;
	@Autowired
	private EXLAgentMapper exlAgentMapper;
	@Autowired
	private SIMemberMapper memberMapper;
	@Autowired
	private SIMerchantMapper merchantMapper;
	@Autowired
	private EXLClientFileMapper exlClientFileMapper;
	@Autowired
	private SequenceNoMapper sequenceNoMapper;
	
	private ServerResponse uploadProfile(MultipartHttpServletRequest request, String clientId, String type) {
		String baseFolder = AppProperties.UPLOAD_PATH+"/exl_client/"+clientId+"/"+type+"/";
		try {
			EXLClientFile profilePic = exlClientFileMapper.selectByClientId(clientId);
			List<SubFile> uploadedFiles = UploadUtil.uploadFileByIOStream(request, baseFolder, FileObjectEnums.EXLClient_FILE);
			if(uploadedFiles != null && !uploadedFiles.isEmpty()) {
				if(profilePic != null) {
					DeleteFileUtil.delete(AppProperties.UPLOAD_PATH+profilePic.getPath());
					exlClientFileMapper.updateByPrimaryKeySelective(EXLClientHelper.assembleEdittedClientFile(profilePic, uploadedFiles));
					return ServerResponse.createBySuccess(uploadedFiles.get(0));
				}else if(exlClientFileMapper.batchInsert(EXLClientHelper.assembleInitClientFile(clientId, type, uploadedFiles)) > 0)
					return ServerResponse.createBySuccess(uploadedFiles.get(0));
			} else if(profilePic != null)
				return ServerResponse.createBySuccess("no file to upload", profilePic);
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
	
	public ServerResponse<EXLClient> query(String id) {
		EXLClient client = exlClientMapper.selectByPrimaryKey(id);
		if(client == null)
			return ServerResponse.createByServerError("user not found, username not exist");
		return ServerResponse.createBySuccess(client);
	} 
	
	public ServerResponse<EXLClient> login(String username, String password) {
		EXLClient client = exlClientMapper.login(username, ServiceHelper.encriptPassword(username, password));
		if(client == null)
			return ServerResponse.createByServerError("login fail, username or password incorrect");
		return ServerResponse.createBySuccess(client);
	} 
	
	public ServerResponse<EXLClient> save(EXLClient client, MultipartHttpServletRequest request) {
		if(memberMapper.selectByUsername(client.getUsername()) != null ||
		   exlAgentMapper.selectByUsername(client.getUsername()) != null ||
		   exlClientMapper.selectByUsername(client.getUsername()) != null || 
		   merchantMapper.selectByUsername(client.getUsername()) != null)
			return ServerResponse.createByServerError(client.getUsername()+" is already exist.");
		SequenceNoHelper.setEXLClientSequenceId(client, sequenceNoMapper);
		client.setPassword(ServiceHelper.encriptPassword(client.getUsername(), client.getPassword()));
		if(exlClientMapper.insertSelective(client)>0) {
			SequenceNoHelper.updateEXLClientSequenceNo(sequenceNoMapper);
			ServerResponse uploadResp = uploadProfile(request, client.getId(), FileType.PROFILE.getDesc());
			if(uploadResp.isSuccess()) {
				EXLClientFile profilePic = (EXLClientFile) uploadResp.getData();
				client.setProfilepicture(profilePic.getPath());
				exlClientMapper.updateByPrimaryKeySelective(client);
				return ServerResponse.createBySuccess(client);
			} else 
				return ServerResponse.createBySuccess(uploadResp.getMsg(), client);
		} else 
			return ServerResponse.createByServerError("register fail");
	}
	
	public ServerResponse<EXLClient> update(EXLClient client, MultipartHttpServletRequest request) {
		if(exlClientMapper.updateByPrimaryKeySelective(client)>0) {
			if(request != null) {
				ServerResponse uploadResp = uploadProfile(request, client.getId(), FileType.PROFILE.getDesc());
				if(uploadResp.isSuccess()) {
					EXLClientFile profilePic = (EXLClientFile) uploadResp.getData();
					client.setProfilepicture(profilePic.getPath());
					exlClientMapper.updateByPrimaryKeySelective(client);
					return ServerResponse.createBySuccess(client);
				} else 
					return ServerResponse.createBySuccess(uploadResp.getMsg(), client);
				}
			return ServerResponse.createBySuccess("update success", client);
		} else 
			return ServerResponse.createByServerError("update fail");
	}
	
	public ServerResponse<PageInfo> selectByPageNumAndPageSize(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<EXLClient> list = exlClientMapper.selectAll();
		return ServerResponse.createBySuccess(new PageInfo(list));
	}
	
	public ServerResponse<PageInfo> selectPageByProperties(Map<String, Object> properties, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<EXLClient> list = exlClientMapper.selectByPropertiesSelelctives(properties);
		return ServerResponse.createBySuccess(new PageInfo(list));
	}
	
	public ServerResponse changePasswordWithoutCheckPassword(String username, String password) {
		if(exlClientMapper.selectByUsername(username) == null)
			return ServerResponse.createByServerError("member not found");
		else {
			password = ServiceHelper.encriptPassword(username, password);
			exlClientMapper.updateByPrimaryKeySelective(EXLClientHelper.assembleSIMember4ChangePassword(username, password));
			return ServerResponse.createBySuccess();
		}
	}
}
