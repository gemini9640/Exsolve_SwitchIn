package com.exl_si.service;

import com.exl_si.common.ServerResponse;
import com.exl_si.db.SIMember;
import com.github.pagehelper.PageInfo;

public interface SIMemberService {
	public ServerResponse<SIMember> query(String username);
	
	public ServerResponse<SIMember> login(String username, String password);
	
	public ServerResponse<SIMember> save(SIMember customer);
	
	public ServerResponse<PageInfo> selectByPageNumAndPageSize(Integer pageNum, Integer pageSize);
	
	public ServerResponse update(SIMember customer);
	
	public ServerResponse changePassword(String username, String oldPass, String newPass);
}
