package com.exl_si.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.exl_si.common.AppProperties;
import com.exl_si.common.ServerResponse;
import com.exl_si.db.EXLAgent;
import com.exl_si.db.EXLAgentFile;
import com.exl_si.db.vo.SubFile;
import com.exl_si.db.vo.FileObjectProvider.FileObjectEnums;
import com.exl_si.enums.EXLAgentEnums.FileType;
import com.exl_si.exception.UploadException;
import com.exl_si.helper.EXLAgentHelper;
import com.exl_si.helper.SequenceNoHelper;
import com.exl_si.helper.ServiceHelper;
import com.exl_si.mapper.EXLAgentFileMapper;
import com.exl_si.mapper.EXLAgentMapper;
import com.exl_si.mapper.EXLClientMapper;
import com.exl_si.mapper.SIMemberMapper;
import com.exl_si.mapper.SIMerchantMapper;
import com.exl_si.mapper.SequenceNoMapper;
import com.exl_si.service.EXLAgentService;
import com.exl_si.utils.DeleteFileUtil;
import com.exl_si.utils.UploadUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("exlAgentService")
public class EXLAgentServiceImpl implements EXLAgentService{
	@Autowired
	private EXLAgentMapper exlAgentMapper;
	@Autowired
	private SIMemberMapper memberMapper;
	@Autowired
	private EXLClientMapper clientMapper;
	@Autowired
	private SIMerchantMapper merchantMapper;
	@Autowired
	private EXLAgentFileMapper exlAgentFileMapper;
	@Autowired
	private SequenceNoMapper sequenceNoMapper;
	
	private ServerResponse uploadProfile(MultipartHttpServletRequest request, String agentId, String type) {
		String baseFolder = AppProperties.UPLOAD_PATH+"/exl_agent/"+agentId+"/"+type+"/";
		try {
			EXLAgentFile profilePic = exlAgentFileMapper.selectByAgentId(agentId);
			List<SubFile> uploadedFiles = UploadUtil.uploadFileByIOStream(request, baseFolder, FileObjectEnums.EXLAGENT_FILE);
			if(uploadedFiles != null && !uploadedFiles.isEmpty()) {
				if(profilePic != null) {
					DeleteFileUtil.delete(AppProperties.UPLOAD_PATH+profilePic.getPath());
					exlAgentFileMapper.updateByPrimaryKeySelective(EXLAgentHelper.assembleEdittedAgentFile(profilePic, uploadedFiles));
					return ServerResponse.createBySuccess(uploadedFiles.get(0));
				}else if(exlAgentFileMapper.batchInsert(EXLAgentHelper.assembleInitAgentFile(agentId, type, uploadedFiles)) > 0)
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
	
	public ServerResponse<EXLAgent> query(String id) {
		EXLAgent agent = exlAgentMapper.selectByPrimaryKey(id);
		if(agent == null)
			return ServerResponse.createByServerError("user not found, username not exist");
		return ServerResponse.createBySuccess(agent);
	} 
	
	public ServerResponse<EXLAgent> login(String username, String password) {
		EXLAgent agent = exlAgentMapper.login(username, ServiceHelper.encriptPassword(username, password));
		if(agent == null)
			return ServerResponse.createByServerError("login fail, username or password incorrect");
		return ServerResponse.createBySuccess(agent);
	} 
	
	public ServerResponse<EXLAgent> save(EXLAgent agent, MultipartHttpServletRequest request) {
		if(memberMapper.selectByUsername(agent.getUsername()) != null ||
		   exlAgentMapper.selectByUsername(agent.getUsername()) != null ||
		   clientMapper.selectByUsername(agent.getUsername()) != null || 
		   merchantMapper.selectByUsername(agent.getUsername()) != null)
			return ServerResponse.createByServerError(agent.getUsername()+" is already exist.");
		SequenceNoHelper.setEXLAgentSequenceId(agent, sequenceNoMapper);
		agent.setPassword(ServiceHelper.encriptPassword(agent.getUsername(), agent.getPassword()));
		if(exlAgentMapper.insertSelective(agent)>0) {
			SequenceNoHelper.updateEXLAgentSequenceNo(sequenceNoMapper);
			ServerResponse uploadResp = uploadProfile(request, agent.getId(), FileType.PROFILE.getDesc());
			if(uploadResp.isSuccess()) {
				EXLAgentFile profilePic = (EXLAgentFile) uploadResp.getData();
				agent.setProfilepicture(profilePic.getPath());
				exlAgentMapper.updateByPrimaryKeySelective(agent);
				return ServerResponse.createBySuccess(agent);
			} else 
				return ServerResponse.createBySuccess(uploadResp.getMsg(), agent);
		} else 
			return ServerResponse.createByServerError("add agent fail");
	}

	public ServerResponse update(EXLAgent agent, MultipartHttpServletRequest request) {
		if(exlAgentMapper.updateByPrimaryKeySelective(agent)>0) {
			if(request != null) {
				ServerResponse uploadResp = uploadProfile(request, agent.getId(), FileType.PROFILE.getDesc());
				if(uploadResp.isSuccess()) {
					EXLAgentFile profilePic = (EXLAgentFile) uploadResp.getData();
					agent.setProfilepicture(profilePic.getPath());
					exlAgentMapper.updateByPrimaryKeySelective(agent);
					return ServerResponse.createBySuccess(agent);
				} else 
					return ServerResponse.createBySuccess(uploadResp.getMsg(), agent);
			}
			return ServerResponse.createBySuccess("update success");
		} else 
			return ServerResponse.createByServerError("update fail");
	}
	
	public ServerResponse<PageInfo> selectByPageNumAndPageSize(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<EXLAgent> list = exlAgentMapper.selectAll();
		return ServerResponse.createBySuccess(new PageInfo(list));
	}
	
	public ServerResponse<PageInfo> selectPageByProperties(Map<String, Object> properties, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<EXLAgent> list = exlAgentMapper.selectByPropertiesSelelctives(properties);
		return ServerResponse.createBySuccess(new PageInfo(list));
	}
	
	public ServerResponse changePasswordWithoutCheckPassword(String username, String password) {
		if(exlAgentMapper.selectByUsername(username) == null)
			return ServerResponse.createByServerError("agent not found");
		else {
			password = ServiceHelper.encriptPassword(username, password);
			exlAgentMapper.updateByPrimaryKeySelective(EXLAgentHelper.assembleEXLAgent4ChangePassword(username, password));
			return ServerResponse.createBySuccess();
		}
	}
}
