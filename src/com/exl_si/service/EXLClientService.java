package com.exl_si.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.exl_si.common.ServerResponse;
import com.exl_si.db.EXLClient;
import com.github.pagehelper.PageInfo;

public interface EXLClientService {
	public ServerResponse<EXLClient> query(String id);
	
	public ServerResponse<EXLClient> login(String username, String password);
	
	public ServerResponse<EXLClient> save(EXLClient client, MultipartHttpServletRequest request);
	
	public ServerResponse<EXLClient> update(EXLClient client, MultipartHttpServletRequest request);
	
	public ServerResponse<PageInfo> selectByPageNumAndPageSize(Integer pageNum, Integer pageSize);
	
	public ServerResponse<PageInfo> selectPageByProperties(Map<String, Object> properties, Integer pageNum, Integer pageSize);
	
	public ServerResponse changePasswordWithoutCheckPassword(String username, String password);
}
