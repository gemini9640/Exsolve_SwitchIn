package com.exl_si.service;

import java.util.List;

import com.exl_si.common.ServerResponse;
import com.exl_si.db.SIMerchant;
import com.exl_si.db.SIMerchantDOC;
import com.exl_si.db.SIMerchantPIC;
import com.github.pagehelper.PageInfo;

public interface SIMerchantService {
	public ServerResponse<SIMerchant> query(String username);
	
	public ServerResponse<SIMerchant> login(String username, String password);
	
	public ServerResponse<PageInfo> selectByPageNumAndPageSize(Integer pageNum, Integer pageSize);
	
	public ServerResponse update(SIMerchant merchant);
	
	public ServerResponse changePassword(String username, String oldPass, String newPass);
		
	public ServerResponse save(SIMerchant merchant);
	
	public ServerResponse saveWithAssociated(SIMerchant merchant, SIMerchantPIC pic, List<SIMerchantDOC> docs);
}
