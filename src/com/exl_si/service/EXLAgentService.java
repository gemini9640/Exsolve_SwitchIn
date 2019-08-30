package com.exl_si.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.exl_si.common.ServerResponse;
import com.exl_si.db.EXLAgent;
import com.github.pagehelper.PageInfo;

public interface EXLAgentService {
	public ServerResponse<EXLAgent> query(String id);
	
	public ServerResponse<EXLAgent> login(String username, String password);
	
	public ServerResponse<EXLAgent> save(EXLAgent agent, MultipartHttpServletRequest request);
	
	public ServerResponse<EXLAgent> update(EXLAgent agent, MultipartHttpServletRequest request);
	
	public ServerResponse<PageInfo> selectByPageNumAndPageSize(Integer pageNum, Integer pageSize);
	
	public ServerResponse<PageInfo> selectPageByProperties(Map<String, Object> properties, Integer pageNum, Integer pageSize);
	
	public ServerResponse changePasswordWithoutCheckPassword(String username, String password);
}
