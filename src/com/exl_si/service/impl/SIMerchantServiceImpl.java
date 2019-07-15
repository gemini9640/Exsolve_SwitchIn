package com.exl_si.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exl_si.common.ServerResponse;
import com.exl_si.db.SIMerchant;
import com.exl_si.mapper.SIMerchantMapper;
import com.exl_si.service.SIMerchantService;
import com.exl_si.service.helper.SIMerchantHelper;
import com.exl_si.utils.MD5Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("sIMerchantService")
public class SIMerchantServiceImpl implements SIMerchantService{
	@Autowired
	private SIMerchantMapper merchantMapper;
	
	public ServerResponse<SIMerchant> query(String username) {
		SIMerchant merchant = merchantMapper.selectByPrimaryKey(username);
		if(merchant == null)
			return ServerResponse.createByErrorMsg("merchant not found, username not exist");
		return ServerResponse.createBySuccess(merchant);
	} 
	
	public ServerResponse<SIMerchant> login(String username, String password) {
		SIMerchant merchant = merchantMapper.login(username, MD5Util.MD5EncodeUtf8(password));
		if(merchant == null)
			return ServerResponse.createByErrorMsg("login fail, username or password incorrect");
		return ServerResponse.createBySuccess(merchant);
	} 
	
	public ServerResponse<PageInfo> selectByPageNumAndPageSize(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<SIMerchant> list = merchantMapper.selectAll();
		return ServerResponse.createBySuccess(new PageInfo(list));
	}
	
	public ServerResponse update(SIMerchant merchant) {
		if(merchantMapper.updateByPrimaryKeySelective(merchant)>0)
			return ServerResponse.createBySuccess();
		else 
			return ServerResponse.createByErrorMsg("update fail");
	}
	
	public ServerResponse changePassword(String username, String oldPass, String newPass) {
		if(merchantMapper.selectByKeyAndPass(username, SIMerchantHelper.encriptPassword(oldPass)) != null) {
			merchantMapper.updateByPrimaryKeySelective(SIMerchantHelper.assembleSIMerchant4ChangePassword(username, newPass));
			return ServerResponse.createBySuccess();
		} else return ServerResponse.createByErrorMsg("update fail");
	}
		
			
	public ServerResponse save(SIMerchant merchant) {
		if(merchantMapper.insertSelective(merchant)>0)
			return ServerResponse.createBySuccess();
		else 
			return ServerResponse.createByErrorMsg("register merchant fail");
	}
}
