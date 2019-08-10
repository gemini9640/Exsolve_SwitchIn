package com.exl_si.service;

import com.exl_si.common.ServerResponse;
import com.exl_si.db.EXLClient;
import com.github.pagehelper.PageInfo;

public interface EXLClientService {
	public ServerResponse<EXLClient> query(String id);
	
	public ServerResponse<EXLClient> login(String username, String password);
	
	public ServerResponse<EXLClient> save(EXLClient client);
	
	public ServerResponse<PageInfo> selectByPageNumAndPageSize(Integer pageNum, Integer pageSize);
	
	public ServerResponse update(EXLClient client);
	
	public ServerResponse changePasswordWithoutCheckPassword(String username, String password);
}
