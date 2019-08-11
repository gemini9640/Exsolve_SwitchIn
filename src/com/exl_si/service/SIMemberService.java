package com.exl_si.service;

import java.util.Map;

import com.exl_si.common.ServerResponse;
import com.exl_si.db.SIMember;
import com.github.pagehelper.PageInfo;

public interface SIMemberService {
	public ServerResponse<SIMember> query(String username);
	
	public ServerResponse<SIMember> login(String username, String password);
	
	public ServerResponse<SIMember> save(SIMember member);
	
	public ServerResponse<PageInfo> selectByPageNumAndPageSize(Integer pageNum, Integer pageSize);
	
	public ServerResponse<PageInfo> selectPageByProperties(Map<String, Object> properties, Integer pageNum, Integer pageSize);
	
	public ServerResponse update(SIMember member);
	
	public ServerResponse changePassword(String username, String oldPass, String newPass);
	
	public ServerResponse changePasswordWithoutCheckPassword(String username, String password);
}
