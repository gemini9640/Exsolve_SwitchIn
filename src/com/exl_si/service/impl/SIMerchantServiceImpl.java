package com.exl_si.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.exl_si.common.AppProperties;
import com.exl_si.common.ServerResponse;
import com.exl_si.db.SIMerchant;
import com.exl_si.db.SIMerchantDOC;
import com.exl_si.db.SIMerchantPIC;
import com.exl_si.db.vo.SIMerchantWithAssociated;
import com.exl_si.db.vo.SIMerchantWithPIC;
import com.exl_si.db.vo.SubFile;
import com.exl_si.enums.MerchantEnums.FileType;
import com.exl_si.db.vo.FileObjectProvider.FileObjectEnums;
import com.exl_si.exception.UploadException;
import com.exl_si.helper.SIMerchantHelper;
import com.exl_si.helper.SequenceNoHelper;
import com.exl_si.helper.ServiceHelper;
import com.exl_si.mapper.SIMerchantDOCMapper;
import com.exl_si.mapper.SIMerchantMapper;
import com.exl_si.mapper.SIMerchantPICMapper;
import com.exl_si.mapper.SequenceNoMapper;
import com.exl_si.service.SIMerchantService;
import com.exl_si.utils.DeleteFileUtil;
import com.exl_si.utils.UploadUtil;
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
	
	private ServerResponse uploadProfile(MultipartHttpServletRequest request, String merchantId, String type) {
		String baseFolder = AppProperties.UPLOAD_PATH+"/si_merchant/"+merchantId+"/"+type+"/";
		try {
			List<SIMerchantDOC> list = docMapper.selectByMerchantIdAndType(merchantId, type);
			SIMerchantDOC profilePic = null;
			if(list != null && list.size()> 0)
				profilePic = list.get(0);
			List<SubFile> uploadedFiles = UploadUtil.uploadFileByIOStream(request, baseFolder, FileObjectEnums.SIMERCHANT_DOC);
			if(uploadedFiles != null && !uploadedFiles.isEmpty()) {
				if(profilePic != null) {
					DeleteFileUtil.delete(AppProperties.UPLOAD_PATH+profilePic.getPath());
					docMapper.updateByPrimaryKeySelective(SIMerchantHelper.assembleEdittedMerchantDOC(profilePic, uploadedFiles));
					return ServerResponse.createBySuccess(uploadedFiles.get(0));
				}else if(docMapper.batchInsert(SIMerchantHelper.assembleInitMerchantDOC(merchantId, type, uploadedFiles)) > 0)
					return ServerResponse.createBySuccess(uploadedFiles.get(0));
			} else if(profilePic != null)
				return ServerResponse.createBySuccess("no file to upload", profilePic);
			return ServerResponse.createByErrorMsg("nothing to do for uploading profile picture!");
		} catch (UploadException ue) {
			if(ue.getIoe() != null) {
				ue.getIoe().printStackTrace();
				if(ue.getPath() != null)
					DeleteFileUtil.delete(ue.getPath());
			} else 
				ue.printStackTrace();
			return ServerResponse.createByErrorMsg(ue.getMessage());
		} catch (InstantiationException e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMsg(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMsg(e.getMessage());
		} 
	}
	
	public ServerResponse<SIMerchant> query(String id) {
		SIMerchant merchant = merchantMapper.selectByPrimaryKey(id);
		if(merchant == null)
			return ServerResponse.createByServerError("merchant not found, id not exist");
		return ServerResponse.createBySuccess(merchant);
	} 
	
	public ServerResponse<SIMerchantPIC> queryPIC(String id) {
		SIMerchantPIC pic = picMapper.selectByPrimaryKey(id);
		if(pic == null)
			return ServerResponse.createByServerError("pic not found, id not exist");
		return ServerResponse.createBySuccess(pic);
	}
	
	public ServerResponse<SIMerchantWithAssociated> queryWithAssociated(String id) {
		SIMerchant merchant = merchantMapper.selectByPrimaryKey(id);
		if(merchant == null)
			return ServerResponse.createByServerError("merchant not found, id not exist");
		List<SIMerchantPIC> pics = picMapper.selectByMerchantId(id);
		List<SIMerchantDOC> docs = docMapper.selectByMerchantIdAndType(id, null);
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
		List<SIMerchant> list = merchantMapper.selectByPropertiesSelelctives(properties);
		return ServerResponse.createBySuccess(new PageInfo(list));
	}
	
	public ServerResponse<SIMerchant> update(SIMerchant merchant, MultipartHttpServletRequest request) {
		if(merchantMapper.updateByPrimaryKeySelective(merchant)>0) {
			ServerResponse uploadResp = uploadProfile(request, merchant.getId(), FileType.PROFILE.getDesc());
			if(uploadResp.isSuccess()) {
				SIMerchantDOC profilePic = (SIMerchantDOC) uploadResp.getData();
				merchant.setCompanylogo(profilePic.getPath());
				merchantMapper.updateByPrimaryKeySelective(merchant);
				return ServerResponse.createBySuccess(merchant);
			} else 
				return ServerResponse.createBySuccess(uploadResp.getMsg(), merchant);
		} else 
			return ServerResponse.createByServerError("update fail");
	}
	
	public ServerResponse<SIMerchantPIC> updatePIC(SIMerchantPIC pic) {
		if(picMapper.updateByPrimaryKeySelective(pic)<1)
			return ServerResponse.createByErrorMsg("update PIC error");
		return ServerResponse.createBySuccess(pic);
	}
	
	public ServerResponse<SIMerchantWithPIC> updateWithPIC(SIMerchant merchant, SIMerchantPIC pic, MultipartHttpServletRequest request) {
		String docMsg = null;
		String picMsg = null;
		
		SIMerchantWithPIC merchantWithPIC = new SIMerchantWithPIC();
		if(merchantMapper.updateByPrimaryKeySelective(merchant)<1)
			return ServerResponse.createByErrorMsg("update merchant error;");
		merchantWithPIC.setMerchant(merchant);
		
		if(pic != null && picMapper.updateByPrimaryKeySelective(pic)<1)
				picMsg = "update PIC error;";
		else 
			merchantWithPIC.setMerchantPIC(pic);
		
		ServerResponse uploadResp = uploadProfile(request, merchant.getId(), FileType.PROFILE.getDesc());
		if(uploadResp.isSuccess()) {
			SIMerchantDOC profilePic = (SIMerchantDOC) uploadResp.getData();
			merchant.setCompanylogo(profilePic.getPath());
			merchantMapper.updateByPrimaryKeySelective(merchant);
		} else 
			docMsg = uploadResp.getMsg();
		
		if(picMsg == null && docMsg == null) {
			return ServerResponse.createBySuccess(merchantWithPIC);
		} else {
			String resultMsg = (picMsg==null?"":picMsg)+(docMsg==null?"":docMsg);
			return ServerResponse.createBySuccess(resultMsg, merchantWithPIC);
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
			
	public ServerResponse<SIMerchant> save(SIMerchant merchant, MultipartHttpServletRequest request) {
		if(merchantMapper.selectByUsername(merchant.getUsername()) != null)
			return ServerResponse.createByServerError("merchant is already exist.");
		SequenceNoHelper.setMerchantSequenceId(merchant, sequenceNoMapper);
		SIMerchantPIC pic = SIMerchantHelper.initMerchantPIC(merchant);
		merchant.setLastloginpicid(pic.getId());
		merchant.setPassword(ServiceHelper.encriptPassword(merchant.getPassword()));
		if(merchantMapper.insertSelective(merchant)>0) {
			picMapper.insert(pic);
			SequenceNoHelper.updateMerchantSequenceNo(sequenceNoMapper);
			ServerResponse uploadResp = uploadProfile(request, merchant.getId(), FileType.PROFILE.getDesc());
			if(uploadResp.isSuccess()) {
				SIMerchantDOC profilePic = (SIMerchantDOC) uploadResp.getData();
				merchant.setCompanylogo(profilePic.getPath());
				merchantMapper.updateByPrimaryKeySelective(merchant);
				return ServerResponse.createBySuccess(merchant);
			} else 
				return ServerResponse.createBySuccess(uploadResp.getMsg(), merchant);
		} else 
			return ServerResponse.createByErrorMsg("register merchant fail");
	}
	
	public ServerResponse<SIMerchantWithPIC> saveWithPIC(SIMerchant merchant, SIMerchantPIC pic, MultipartHttpServletRequest request) {
		if(merchantMapper.selectByUsername(merchant.getUsername()) != null)
			return ServerResponse.createByServerError("merchant is already exist.");
		String picMsg = null;
		String docMsg = null;

		SIMerchantWithPIC merchantWithPIC = new SIMerchantWithPIC();
		SequenceNoHelper.setMerchantSequenceId(merchant, sequenceNoMapper);
		merchant.setPassword(ServiceHelper.encriptPassword(merchant.getPassword()));
		if(merchantMapper.insertSelective(merchant)<1)
			return ServerResponse.createByErrorMsg("save merchant error;");
		else {
			SequenceNoHelper.updateMerchantSequenceNo(sequenceNoMapper);
			merchantWithPIC.setMerchant(merchant);
		}
		
		if(pic != null) {
			pic.setMerchantid(merchant.getId());
			if(picMapper.insertSelective(pic)<1)
				picMsg = "save PIC error;";
			else 
				merchantWithPIC.setMerchantPIC(pic);
		}  

		ServerResponse uploadResp = uploadProfile(request, merchant.getId(), FileType.PROFILE.getDesc());
		if(uploadResp.isSuccess()) {
			SIMerchantDOC profilePic = (SIMerchantDOC) uploadResp.getData();
			merchant.setCompanylogo(profilePic.getPath());
			merchantMapper.updateByPrimaryKeySelective(merchant);
		} else 
			docMsg = uploadResp.getMsg();
		
		if(picMsg == null && docMsg == null) {
			return ServerResponse.createBySuccess(merchantWithPIC);
		} else {
			String resultMsg = (picMsg==null?"":picMsg)+(docMsg==null?"":docMsg);
			return ServerResponse.createBySuccess(resultMsg, merchantWithPIC);
		}
	}
	
	
	public ServerResponse<List<SubFile>> uploadDoc(MultipartHttpServletRequest request, String merchantId, FileType type) {
		String baseFolder = AppProperties.UPLOAD_PATH+"/si_merchant/"+merchantId+"/"+type.getDesc()+"/";
		try {
			List<SubFile> uploadedFiles = UploadUtil.uploadFileByIOStream(request, baseFolder, FileObjectEnums.SIMERCHANT_DOC);
			if(uploadedFiles != null && !uploadedFiles.isEmpty()) {
				if(docMapper.batchInsert(SIMerchantHelper.assembleInitMerchantDOC(merchantId, type.getDesc(), uploadedFiles)) > 0)
					return ServerResponse.createBySuccess(uploadedFiles);
			} 
			return ServerResponse.createByErrorMsg("no file to upload.");
		} catch (UploadException ue) {
			if(ue.getIoe() != null) {
				ue.getIoe().printStackTrace();
				if(ue.getPath() != null)
					DeleteFileUtil.delete(ue.getPath());
			} else 
				ue.printStackTrace();
			return ServerResponse.createByErrorMsg(ue.getMessage());
		} catch (InstantiationException e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMsg(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMsg(e.getMessage());
		} 
	}
}
