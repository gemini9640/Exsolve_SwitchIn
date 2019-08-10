package com.exl_si.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exl_si.common.ServerResponse;
import com.exl_si.db.SIMerchant;
import com.exl_si.db.SIMerchantDOC;
import com.exl_si.db.SIMerchantPIC;
import com.exl_si.db.vo.SIMerchantWithAssociated;
import com.exl_si.helper.SIMerchantHelper;
import com.exl_si.helper.SequenceNoHelper;
import com.exl_si.helper.ServiceHelper;
import com.exl_si.mapper.SIMerchantDOCMapper;
import com.exl_si.mapper.SIMerchantMapper;
import com.exl_si.mapper.SIMerchantPICMapper;
import com.exl_si.mapper.SequenceNoMapper;
import com.exl_si.service.SIMerchantService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("merchantService")
public class SIMerchantServiceImpl implements SIMerchantService{
	@Autowired
	private SIMerchantMapper merchantMapper;
	@Autowired
	private SIMerchantPICMapper picMapper;
	@Autowired
	private SIMerchantDOCMapper docMapper;
	@Autowired
	private SequenceNoMapper sequenceNoMapper;
	
	public ServerResponse<SIMerchant> query(String id) {
		SIMerchant merchant = merchantMapper.selectByPrimaryKey(id);
		if(merchant == null)
			return ServerResponse.createByServerError("merchant not found, id not exist");
		return ServerResponse.createBySuccess(merchant);
	} 
	
	public ServerResponse<SIMerchantWithAssociated> queryWithAssociated(String id) {
		SIMerchant merchant = merchantMapper.selectByPrimaryKey(id);
		if(merchant == null)
			return ServerResponse.createByServerError("merchant not found, id not exist");
		List<SIMerchantPIC> pics = picMapper.selectByMerchantId(id);
		List<SIMerchantDOC> docs = docMapper.selectByMerchantId(id);
		return ServerResponse.createBySuccess(new SIMerchantWithAssociated(merchant, pics, docs));
	} 
	
	public ServerResponse<SIMerchant> login(String username, String password) {
		SIMerchant merchant = merchantMapper.login(username, SIMerchantHelper.getPassword(username, password));
		if(merchant == null)
			return ServerResponse.createByServerError("login fail, username or password incorrect");
		return ServerResponse.createBySuccess(merchant);
	} 
	
	public ServerResponse<PageInfo> selectByPageNumAndPageSize(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<SIMerchant> list = merchantMapper.selectAll();
		return ServerResponse.createBySuccess(new PageInfo(list));
	}
	
	public ServerResponse<PageInfo> selectPageByProperties(Map<String, Object> properties, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<SIMerchant> list = merchantMapper.selectByPropertiesSelelcttives(properties);
		return ServerResponse.createBySuccess(new PageInfo(list));
	}
	
	public ServerResponse update(SIMerchant merchant) {
		if(merchantMapper.updateByPrimaryKeySelective(merchant)>0)
			return ServerResponse.createBySuccess();
		else 
			return ServerResponse.createByServerError("update fail");
	}
	
	public ServerResponse updateWithPIC(SIMerchant merchant, SIMerchantPIC pic) {
		String merchantMsg = null;
		String picMsg = null;
		
		if(merchantMapper.updateByPrimaryKeySelective(merchant)<1)
			merchantMsg = "update merchant error;";
		
		if(pic != null && picMapper.updateByPrimaryKeySelective(pic)<1)
				picMsg = "update PIC error;";
		
		if(merchantMsg == null && picMsg == null)
			return ServerResponse.createBySuccess();
		else {
			String resultMsg = (merchantMsg==null?"":merchantMsg)+(picMsg==null?"":picMsg);
			return ServerResponse.createByServerError("update merchant fail,"+resultMsg);
		}
	}
	
	public ServerResponse changePassword(String username, String oldPass, String newPass) {
		if(merchantMapper.selectByUsernameAndPass(username, ServiceHelper.encriptPassword(oldPass)) != null) {
			merchantMapper.updateByPrimaryKeySelective(SIMerchantHelper.assembleSIMerchant4ChangePassword(username, newPass));
			return ServerResponse.createBySuccess();
		} else return ServerResponse.createByServerError("username not exist or passord fail");
	}
		
	public ServerResponse changePasswordWithoutCheckPassword(String username, String password) {
		if(merchantMapper.selectByUsername(username) == null)
			return ServerResponse.createByServerError("merchant not found");
		else {
			password = ServiceHelper.encriptPassword(password);
			merchantMapper.updateByPrimaryKeySelective(SIMerchantHelper.assembleSIMerchant4ChangePassword(username, password));
			return ServerResponse.createBySuccess();
		}
	}
			
	public ServerResponse save(SIMerchant merchant) {
		if(merchantMapper.selectByUsername(merchant.getUsername()) != null)
			return ServerResponse.createByServerError("merchant is already exist.");
		SequenceNoHelper.setMerchantSequenceId(merchant, sequenceNoMapper);
		if(merchantMapper.insertSelective(merchant)>0) {
			SequenceNoHelper.updateMerchantSequenceNo(sequenceNoMapper);
			return ServerResponse.createBySuccess();
		} else 
			return ServerResponse.createByErrorMsg("register merchant fail");
	}
	
	public ServerResponse saveWithAssociated(SIMerchant merchant, SIMerchantPIC pic, List<SIMerchantDOC> docs) {
		if(merchantMapper.selectByUsername(merchant.getUsername()) != null)
			return ServerResponse.createByServerError("merchant is already exist.");
		
		String merchantMsg = null;
		String picMsg = null;
		String docMsg = null;
		
		SequenceNoHelper.setMerchantSequenceId(merchant, sequenceNoMapper);
		if(merchantMapper.insertSelective(merchant)<1)
			merchantMsg = "save merchant error;";
		else 
			SequenceNoHelper.updateMerchantSequenceNo(sequenceNoMapper);
		if(pic != null) {
			pic.setMerchantid(merchant.getId());
			if(picMapper.insertSelective(pic)<1)
				picMsg = "save PIC error;";
		}  
		
//		if(docs != null) {
//			for(SIMerchantDOC doc : docs)
//				doc.setMerchantid(merchant.getId());
//			if(docs.size()<1 || docMapper.batchInsert(docs) != docs.size())
//				docMsg = "save DOC error;";
//		}	
		
		if(merchantMsg == null && picMsg == null && docMsg == null) {
			return ServerResponse.createBySuccess();
		} else {
			String resultMsg = (merchantMsg==null?"":merchantMsg)+(picMsg==null?"":picMsg)+(docMsg==null?"":docMsg);
			return ServerResponse.createByErrorMsg("save merchant fail,"+resultMsg);
		}
	}
}
