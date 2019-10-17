package com.exl_si.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.exl_si.common.ServerResponse;
import com.exl_si.db.Voucher;
import com.exl_si.db.VoucherPicture;
import com.exl_si.db.vo.SubFile;
import com.exl_si.enums.VoucherEnums;
import com.exl_si.enums.VoucherEnums.PictureType;
import com.github.pagehelper.PageInfo;

public interface VoucherService {
	public ServerResponse<Voucher> save(Voucher voucher);
	
	public ServerResponse<Voucher> queryById(String id);
	
	public ServerResponse<PageInfo> queryByMerchant(String merchantId, Integer pageNum, Integer pageSize);
	
	public ServerResponse<PageInfo> queryByProperties(Map<String, Object> properties, Integer pageNum, Integer pageSize);

	public ServerResponse updateStatus(String id, VoucherEnums.STATUS status);
	
	public ServerResponse update(Voucher voucher);
	
	public ServerResponse<Voucher> query(String id);
	
	public ServerResponse<String> queryTagline(String id);
	
	public ServerResponse<String> queryGeographic(String id);
	
	public ServerResponse uploadSingleDoc(MultipartHttpServletRequest request, String voucherId, String type);
	
	public ServerResponse<List<SubFile>> uploadPicture(MultipartHttpServletRequest request, String merchantId, String voucherId, PictureType type);
	
	public List<VoucherPicture> selectPictureByVoucherIdAndType(String voucherId, String type);
}
