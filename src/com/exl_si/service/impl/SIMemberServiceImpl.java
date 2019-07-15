package com.exl_si.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exl_si.common.ServerResponse;
import com.exl_si.db.SIMember;
import com.exl_si.mapper.SIMemberMapper;
import com.exl_si.service.SIMemberService;
import com.exl_si.service.helper.SIMemberHelper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("sIMemberService")
public class SIMemberServiceImpl implements SIMemberService{
	@Autowired
	private SIMemberMapper memberMapper;
	
	public ServerResponse<SIMember> query(String username) {
		SIMember customer = memberMapper.selectByPrimaryKey(username);
		if(customer == null)
			return ServerResponse.createByErrorMsg("user not found, username not exist");
		return ServerResponse.createBySuccess(customer);
	} 
	
	public ServerResponse<SIMember> login(String username, String password) {
		SIMember customer = memberMapper.login(username, SIMemberHelper.encriptPassword(password));
		if(customer == null)
			return ServerResponse.createByErrorMsg("login fail, username or password incorrect");
		return ServerResponse.createBySuccess(customer);
	} 
	
	public ServerResponse<SIMember> save(SIMember customer) {
		if(memberMapper.insertSelective(customer)>0)
			return ServerResponse.createBySuccess(customer);
		else 
			return ServerResponse.createByErrorMsg("register fail");
	}
	
	public ServerResponse<PageInfo> selectByPageNumAndPageSize(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<SIMember> list = memberMapper.selectAll();
		return ServerResponse.createBySuccess(new PageInfo(list));
	}
	
	public ServerResponse update(SIMember customer) {
		if(memberMapper.updateByPrimaryKeySelective(customer)>0)
			return ServerResponse.createBySuccess();
		else 
			return ServerResponse.createByErrorMsg("update fail");
	}
	
	public ServerResponse changePassword(String username, String oldPass, String newPass) {
		if(memberMapper.selectByKeyAndPass(username, SIMemberHelper.encriptPassword(oldPass)) != null) {
			memberMapper.updateByPrimaryKeySelective(SIMemberHelper.assembleSIMember4ChangePassword(username, newPass));
			return ServerResponse.createBySuccess();
		} else 
			return ServerResponse.createByErrorMsg("update fail");
	}
}
