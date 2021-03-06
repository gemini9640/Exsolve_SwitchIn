package com.exl_si.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.exl_si.common.ServerResponse;
import com.exl_si.db.SIMerchant;
import com.exl_si.db.SIMerchantDOC;
import com.exl_si.db.SIMerchantPIC;
import com.exl_si.db.vo.SIMerchantWithAssociated;
import com.exl_si.db.vo.SIMerchantWithPIC;
import com.exl_si.db.vo.SubFile;
import com.exl_si.enums.MerchantEnums.FileType;
import com.github.pagehelper.PageInfo;

public interface SIMerchantService {
	
	public ServerResponse<String> queryTagline(String id);
	
	public ServerResponse<String> queryGeographic(String id);
	
	public ServerResponse<SIMerchant> query(String id);
	
	public ServerResponse<SIMerchantPIC> queryPIC(String id);
	
	public ServerResponse<SIMerchantWithAssociated> queryWithAssociated(String id);
	
	public ServerResponse<SIMerchant> login(String username, String password);
	
	public ServerResponse<PageInfo> selectByPageNumAndPageSize(Integer pageNum, Integer pageSize);
	
	public ServerResponse<PageInfo> selectPageByProperties(Map<String, Object> properties, Integer pageNum, Integer pageSize);
	
	public ServerResponse<SIMerchant> update(SIMerchant merchant, MultipartHttpServletRequest request);
	
	public ServerResponse<SIMerchantPIC> updatePIC(SIMerchantPIC pic);
	
	public ServerResponse<SIMerchantWithPIC> updateWithPIC(SIMerchant merchant, SIMerchantPIC pic, MultipartHttpServletRequest request);
	
	public ServerResponse changePassword(String username, String oldPass, String newPass);
	
	public ServerResponse changePasswordWithoutCheckPassword(String username, String password);
		
	public ServerResponse<SIMerchant> save(SIMerchant merchant, MultipartHttpServletRequest request);
	
	public ServerResponse<SIMerchantWithPIC> saveWithPIC(SIMerchant merchant, SIMerchantPIC pic, MultipartHttpServletRequest request);
	
	public ServerResponse<SubFile> uploadSingleDoc(MultipartHttpServletRequest request, String merchantId, FileType type);
	
	public ServerResponse<List<SubFile>> uploadMultipleDoc(MultipartHttpServletRequest request, String merchantId, FileType type);
	
	public List<SIMerchantDOC> selectDocByMerchantIdAndType(String merchantId, String type);
	
	public ServerResponse update(SIMerchant merchant);
}
