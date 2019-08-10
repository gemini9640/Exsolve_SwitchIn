package com.exl_si.service;

import com.exl_si.common.ServerResponse;
import com.exl_si.db.EXLAgent;
import com.github.pagehelper.PageInfo;

public interface EXLAgentService {
	public ServerResponse<EXLAgent> query(String id);
	
	public ServerResponse<EXLAgent> login(String username, String password);
	
	public ServerResponse<EXLAgent> save(EXLAgent agent);
	
	public ServerResponse<PageInfo> selectByPageNumAndPageSize(Integer pageNum, Integer pageSize);
	
	public ServerResponse update(EXLAgent agent);
	
	
	public ServerResponse changePasswordWithoutCheckPassword(String username, String password);
}
