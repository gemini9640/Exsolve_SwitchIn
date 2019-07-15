package com.exl_si.service;

import com.exl_si.common.ServerResponse;
import com.exl_si.db.SIMerchant;
import com.github.pagehelper.PageInfo;

public interface SIMerchantService {
	public ServerResponse<SIMerchant> query(String username);
	
	public ServerResponse<SIMerchant> login(String username, String password);
	
	public ServerResponse<PageInfo> selectByPageNumAndPageSize(Integer pageNum, Integer pageSize);
	
	public ServerResponse update(SIMerchant merchant);
	
	public ServerResponse changePassword(String username, String oldPass, String newPass);
		
	public ServerResponse save(SIMerchant merchant);
}
