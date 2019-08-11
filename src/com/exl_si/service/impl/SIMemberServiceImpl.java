package com.exl_si.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exl_si.common.ServerResponse;
import com.exl_si.db.SIMember;
import com.exl_si.helper.SIMemberHelper;
import com.exl_si.helper.SequenceNoHelper;
import com.exl_si.helper.ServiceHelper;
import com.exl_si.mapper.SIMemberMapper;
import com.exl_si.mapper.SequenceNoMapper;
import com.exl_si.service.SIMemberService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("memberService")
public class SIMemberServiceImpl implements SIMemberService{
	@Autowired
	private SIMemberMapper memberMapper;
	@Autowired
	private SequenceNoMapper sequenceNoMapper;
	
	public ServerResponse<SIMember> query(String username) {
		SIMember member = memberMapper.selectByPrimaryKey(username);
		if(member == null)
			return ServerResponse.createByServerError("user not found, username not exist");
		return ServerResponse.createBySuccess(member);
	} 
	
	public ServerResponse<SIMember> login(String username, String password) {
		SIMember member = memberMapper.login(username, ServiceHelper.encriptPassword(password));
		if(member == null)
			return ServerResponse.createByServerError("login fail, username or password incorrect");
		return ServerResponse.createBySuccess(member);
	} 
	
	public ServerResponse<SIMember> save(SIMember member) {
		if(memberMapper.selectByUsername(member.getUsername()) != null)
			return ServerResponse.createByServerError("member is already exist.");
		SequenceNoHelper.setMemberSequenceId(member, sequenceNoMapper);
		if(memberMapper.insertSelective(member)>0) {
			SequenceNoHelper.updateMemberSequenceNo(sequenceNoMapper);
			return ServerResponse.createBySuccess(member);
		} else 
			return ServerResponse.createByServerError("register fail");
	}
	
	public ServerResponse<PageInfo> selectByPageNumAndPageSize(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<SIMember> list = memberMapper.selectAll();
		return ServerResponse.createBySuccess(new PageInfo(list));
	}
	
	public ServerResponse<PageInfo> selectPageByProperties(Map<String, Object> properties, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<SIMember> list = memberMapper.selectByPropertiesSelelctives(properties);
		return ServerResponse.createBySuccess(new PageInfo(list));
	}
	
	public ServerResponse update(SIMember member) {
		if(memberMapper.updateByPrimaryKeySelective(member)>0)
			return ServerResponse.createBySuccess();
		else 
			return ServerResponse.createByServerError("update fail");
	}
	
	public ServerResponse changePassword(String username, String oldPass, String newPass) {
		if(memberMapper.selectByKeyAndPass(username, ServiceHelper.encriptPassword(oldPass)) != null) {
			memberMapper.updateByPrimaryKeySelective(SIMemberHelper.assembleSIMember4ChangePassword(username, newPass));
			return ServerResponse.createBySuccess();
		} else 
			return ServerResponse.createByServerError("update fail");
	}
	
	public ServerResponse changePasswordWithoutCheckPassword(String username, String password) {
		if(memberMapper.selectByUsername(username) == null)
			return ServerResponse.createByServerError("member not found");
		else {
			password = ServiceHelper.encriptPassword(password);
			memberMapper.updateByPrimaryKeySelective(SIMemberHelper.assembleSIMember4ChangePassword(username, password));
			return ServerResponse.createBySuccess();
		}
	}
}
