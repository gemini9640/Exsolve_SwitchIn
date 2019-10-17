package com.exl_si.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.exl_si.common.AppProperties;
import com.exl_si.common.ServerResponse;
import com.exl_si.db.vo.SubFile;
import com.exl_si.db.Voucher;
import com.exl_si.db.VoucherPicture;
import com.exl_si.db.vo.FileObjectProvider.FileObjectEnums;
import com.exl_si.enums.VoucherEnums;
import com.exl_si.enums.VoucherEnums.PictureType;
import com.exl_si.exception.UploadException;
import com.exl_si.helper.SequenceNoHelper;
import com.exl_si.helper.VoucherHelper;
import com.exl_si.mapper.SIMerchantMapper;
import com.exl_si.mapper.SequenceNoMapper;
import com.exl_si.mapper.VoucherMapper;
import com.exl_si.mapper.VoucherPictureMapper;
import com.exl_si.service.VoucherService;
import com.exl_si.utils.DeleteFileUtil;
import com.exl_si.utils.UploadUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("voucherService")
public class VoucherServiceImpl implements VoucherService{
	@Autowired
	private VoucherMapper voucherMapper;
	@Autowired
	private VoucherPictureMapper voucherPictureMapper;
	@Autowired
	private SIMerchantMapper merchantMapper;
	@Autowired
	private SequenceNoMapper sequenceNoMapper;
	
	public ServerResponse<Voucher> save(Voucher voucher) {
		if(merchantMapper.selectByPrimaryKey(voucher.getMerchantId()) ==null)
			return ServerResponse.createByServerError("merchantId not valid");
		if(voucherMapper.selectByName(voucher.getVoucherTitle()) != null)
			return ServerResponse.createByServerError("voucher title is duplicated");
		SequenceNoHelper.setVoucherSequenceId(voucher, sequenceNoMapper);
		if(voucherMapper.insertSelective(voucher)>0) {
			SequenceNoHelper.updateVoucherSequenceNo(sequenceNoMapper);
			return ServerResponse.createBySuccess(voucher);
		} else 
			return ServerResponse.createByServerError("create fail");
	}
	
	public ServerResponse<Voucher> queryById(String id) {
		Voucher voucher = voucherMapper.selectByPrimaryKey(id);
		if(voucher == null)
			return ServerResponse.createByServerError("voucher not found");
		return ServerResponse.createBySuccess(voucher);
	}
	
	public ServerResponse<PageInfo> queryByMerchant(String merchantId, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Voucher> list = voucherMapper.selectByMerchant(merchantId);
		return ServerResponse.createBySuccess(new PageInfo(list));
	} 
	
	public ServerResponse<PageInfo> queryByProperties(Map<String, Object> properties, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Voucher> list = voucherMapper.selectByPropertiesSelective(properties);
		return ServerResponse.createBySuccess(new PageInfo(list));
	}
	
	public ServerResponse updateStatus(String id, VoucherEnums.STATUS status) {
		if(voucherMapper.updateStatus(id, status.getCode())>0)
			return ServerResponse.createBySuccess();
		else 
			return ServerResponse.createByServerError("approve fail");
	}
	
	public ServerResponse update(Voucher voucher) {
		if(voucherMapper.updateByPrimaryKeySelective(voucher)>0)
			return ServerResponse.createBySuccess(voucher);
		else 
			return ServerResponse.createByServerError("update fail");
	}
	
	public ServerResponse<Voucher> query(String id) {
		Voucher voucher = voucherMapper.selectByPrimaryKey(id);
		if(voucher == null)
			return ServerResponse.createByServerError("voucher not found");
		return ServerResponse.createBySuccess(voucher);
	}
	
	public ServerResponse<String> queryTagline(String id) {
		Voucher voucher = voucherMapper.selectByPrimaryKey(id);
		if(voucher == null)
			return ServerResponse.createByServerError("voucher not found");
		return ServerResponse.createBySuccess(voucher.getTagline());
	}
	
	public ServerResponse<String> queryGeographic(String id) {
		Voucher voucher = voucherMapper.selectByPrimaryKey(id);
		if(voucher == null)
			return ServerResponse.createByServerError("location not found");
		return ServerResponse.createBySuccess(voucher.getGeographic());
	}
	
	public ServerResponse<List<SubFile>> uploadPicture(MultipartHttpServletRequest request, String merchantId, String voucherId, PictureType type) {
		String baseFolder = AppProperties.UPLOAD_PATH+"/si_merchant/"+merchantId+"/voucher/"+type.getDesc()+"/";
		try {
			List<SubFile> uploadedFiles = UploadUtil.uploadFileByIOStream(request, baseFolder, FileObjectEnums.VOUCHER_PICTURE);
			if(uploadedFiles != null && !uploadedFiles.isEmpty()) {
				if(voucherPictureMapper.batchInsert(VoucherHelper.assembleInitPicture(voucherId, type.getDesc(), uploadedFiles)) > 0)
					return ServerResponse.createBySuccess(uploadedFiles);
			} 
			return ServerResponse.createByErrorMsg("no picture to upload.");
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
	
	public List<VoucherPicture> selectPictureByVoucherIdAndType(String voucherId, String type) {
		return voucherPictureMapper.selectByVoucherIdAndType(voucherId, type);
	}
	
	public ServerResponse uploadSingleDoc(MultipartHttpServletRequest request, String voucherId, String type) {
		String baseFolder = AppProperties.UPLOAD_PATH+"/voucher/"+voucherId+"/"+type+"/";
		try {
			List<VoucherPicture> list = voucherPictureMapper.selectByVoucherIdAndType(voucherId, type);
			//一个类型只允许上传一个文件
			VoucherPicture picture = null;
			if(list != null && list.size()> 0)
				picture = list.get(0);
			List<SubFile> uploadedFiles = UploadUtil.uploadFileByIOStream(request, baseFolder, FileObjectEnums.VOUCHER_PICTURE);
			if(uploadedFiles != null && !uploadedFiles.isEmpty()) {
				if(picture != null) {
					//重复上传会删掉原本的文件
					DeleteFileUtil.delete(AppProperties.UPLOAD_PATH+picture.getPath());
					voucherPictureMapper.updateByPrimaryKeySelective(VoucherHelper.assembleEdittedPicture(picture, uploadedFiles));
					return ServerResponse.createBySuccess(uploadedFiles.get(0));
				}else if(voucherPictureMapper.batchInsert(VoucherHelper.assembleInitPicture(voucherId, type, uploadedFiles)) > 0)
					return ServerResponse.createBySuccess(uploadedFiles.get(0));
			} else if(picture != null)
				return ServerResponse.createBySuccess("no file to upload", picture);
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
}
