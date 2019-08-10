package com.exl_si.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exl_si.common.ServerResponse;
import com.exl_si.db.EXLAgent;
import com.exl_si.helper.EXLAgentHelper;
import com.exl_si.helper.SequenceNoHelper;
import com.exl_si.helper.ServiceHelper;
import com.exl_si.mapper.EXLAgentMapper;
import com.exl_si.mapper.SequenceNoMapper;
import com.exl_si.service.EXLAgentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("exlAgentService")
public class EXLAgentServiceImpl implements EXLAgentService{
	@Autowired
	private EXLAgentMapper exlAgentMapper;
	@Autowired
	private SequenceNoMapper sequenceNoMapper;
	
	public ServerResponse<EXLAgent> query(String id) {
		EXLAgent agent = exlAgentMapper.selectByPrimaryKey(id);
		if(agent == null)
			return ServerResponse.createByServerError("user not found, username not exist");
		return ServerResponse.createBySuccess(agent);
	} 
	
	public ServerResponse<EXLAgent> login(String username, String password) {
		EXLAgent agent = exlAgentMapper.login(username, ServiceHelper.encriptPassword(password));
		if(agent == null)
			return ServerResponse.createByServerError("login fail, username or password incorrect");
		return ServerResponse.createBySuccess(agent);
	} 
	
	public ServerResponse<EXLAgent> save(EXLAgent agent) {
		if(exlAgentMapper.selectByUsername(agent.getUsername()) != null)
			return ServerResponse.createByServerError(agent.getUsername()+" is already exist.");
		SequenceNoHelper.setEXLAgentSequenceId(agent, sequenceNoMapper);
		
		agent.setPassword(ServiceHelper.encriptPassword(agent.getPassword()));
		if(exlAgentMapper.insertSelective(agent)>0) {
			SequenceNoHelper.updateEXLAgentSequenceNo(sequenceNoMapper);
			return ServerResponse.createBySuccess(agent);
		} else 
			return ServerResponse.createByServerError("register fail");
	}
	
	public ServerResponse<PageInfo> selectByPageNumAndPageSize(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<EXLAgent> list = exlAgentMapper.selectAll();
		return ServerResponse.createBySuccess(new PageInfo(list));
	}
	
	public ServerResponse update(EXLAgent agent) {
		if(exlAgentMapper.updateByPrimaryKeySelective(agent)>0)
			return ServerResponse.createBySuccess();
		else 
			return ServerResponse.createByServerError("update fail");
	}
	
	
	public ServerResponse changePasswordWithoutCheckPassword(String username, String password) {
		if(exlAgentMapper.selectByUsername(username) == null)
			return ServerResponse.createByServerError("member not found");
		else {
			password = ServiceHelper.encriptPassword(password);
			exlAgentMapper.updateByPrimaryKeySelective(EXLAgentHelper.assembleSIMember4ChangePassword(username, password));
			return ServerResponse.createBySuccess();
		}
	}
}
