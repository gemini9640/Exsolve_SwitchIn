package com.exl_si.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.exl_si.common.ServerResponse;
import com.exl_si.db.SIMember;
import com.exl_si.db.SIMemberFile;
import com.exl_si.db.vo.SIMemberWithAssociated;
import com.github.pagehelper.PageInfo;

public interface SIMemberService {
	
	public ServerResponse<SIMemberWithAssociated> query(String id);
	
	public ServerResponse<SIMemberWithAssociated> login(String username, String password);
	
	public ServerResponse<SIMemberWithAssociated> save(SIMember member, MultipartHttpServletRequest request);

	public ServerResponse<SIMemberWithAssociated> update(SIMember member, MultipartHttpServletRequest request);
	
	public ServerResponse<PageInfo> selectByPageNumAndPageSize(Integer pageNum, Integer pageSize);
	
	public ServerResponse<PageInfo> selectPageByProperties(Map<String, Object> properties, Integer pageNum, Integer pageSize);
	
	public ServerResponse changePassword(String username, String oldPass, String newPass);
	
	public ServerResponse changePasswordWithoutCheckPassword(String username, String password);
	
	public ServerResponse initUploadFile(List<SIMemberFile> memberFiles);
}
