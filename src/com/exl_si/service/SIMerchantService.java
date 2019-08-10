package com.exl_si.service;

import java.util.List;
import java.util.Map;

import com.exl_si.common.ServerResponse;
import com.exl_si.db.SIMerchant;
import com.exl_si.db.SIMerchantDOC;
import com.exl_si.db.SIMerchantPIC;
import com.exl_si.db.vo.SIMerchantWithAssociated;
import com.github.pagehelper.PageInfo;

public interface SIMerchantService {
	public ServerResponse<SIMerchant> query(String username);
	
	public ServerResponse<SIMerchantWithAssociated> queryWithAssociated(String id);
	
	public ServerResponse<SIMerchant> login(String username, String password);
	
	public ServerResponse<PageInfo> selectByPageNumAndPageSize(Integer pageNum, Integer pageSize);
	
	public ServerResponse<PageInfo> selectPageByProperties(Map<String, Object> properties, Integer pageNum, Integer pageSize);
	
	public ServerResponse update(SIMerchant merchant);
	
	public ServerResponse updateWithPIC(SIMerchant merchant, SIMerchantPIC pic);
	
	public ServerResponse changePassword(String username, String oldPass, String newPass);
	
	public ServerResponse changePasswordWithoutCheckPassword(String username, String password);
		
	public ServerResponse save(SIMerchant merchant);
	
	public ServerResponse saveWithAssociated(SIMerchant merchant, SIMerchantPIC pic, List<SIMerchantDOC> docs);
}
