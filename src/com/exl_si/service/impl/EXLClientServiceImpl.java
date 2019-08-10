package com.exl_si.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exl_si.common.ServerResponse;
import com.exl_si.db.EXLClient;
import com.exl_si.helper.EXLClientHelper;
import com.exl_si.helper.SIMemberHelper;
import com.exl_si.helper.SequenceNoHelper;
import com.exl_si.helper.ServiceHelper;
import com.exl_si.mapper.EXLClientMapper;
import com.exl_si.mapper.SequenceNoMapper;
import com.exl_si.service.EXLClientService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("exlClientService")
public class EXLClientServiceImpl implements EXLClientService{
	@Autowired
	private EXLClientMapper exlClientMapper;
	@Autowired
	private SequenceNoMapper sequenceNoMapper;
	
	public ServerResponse<EXLClient> query(String id) {
		EXLClient client = exlClientMapper.selectByPrimaryKey(id);
		if(client == null)
			return ServerResponse.createByServerError("user not found, username not exist");
		return ServerResponse.createBySuccess(client);
	} 
	
	public ServerResponse<EXLClient> login(String username, String password) {
		EXLClient client = exlClientMapper.login(username, ServiceHelper.encriptPassword(password));
		if(client == null)
			return ServerResponse.createByServerError("login fail, username or password incorrect");
		return ServerResponse.createBySuccess(client);
	} 
	
	public ServerResponse<EXLClient> save(EXLClient client) {
		if(exlClientMapper.selectByUsername(client.getUsername()) != null)
			return ServerResponse.createByServerError(client.getUsername()+" is already exist.");
		SequenceNoHelper.setEXLClientSequenceId(client, sequenceNoMapper);
		
		client.setPassword(ServiceHelper.encriptPassword(client.getPassword()));
		if(exlClientMapper.insertSelective(client)>0) {
			SequenceNoHelper.updateEXLClientSequenceNo(sequenceNoMapper);
			return ServerResponse.createBySuccess(client);
		} else 
			return ServerResponse.createByServerError("register fail");
	}
	
	public ServerResponse<PageInfo> selectByPageNumAndPageSize(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<EXLClient> list = exlClientMapper.selectAll();
		return ServerResponse.createBySuccess(new PageInfo(list));
	}
	
	public ServerResponse update(EXLClient client) {
		if(exlClientMapper.updateByPrimaryKeySelective(client)>0)
			return ServerResponse.createBySuccess();
		else 
			return ServerResponse.createByServerError("update fail");
	}
	
	
	public ServerResponse changePasswordWithoutCheckPassword(String username, String password) {
		if(exlClientMapper.selectByUsername(username) == null)
			return ServerResponse.createByServerError("member not found");
		else {
			password = ServiceHelper.encriptPassword(password);
			exlClientMapper.updateByPrimaryKeySelective(EXLClientHelper.assembleSIMember4ChangePassword(username, password));
			return ServerResponse.createBySuccess();
		}
	}
}
