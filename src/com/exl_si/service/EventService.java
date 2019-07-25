package com.exl_si.service;

import com.exl_si.common.ServerResponse;
import com.exl_si.db.Event;
import com.exl_si.enums.StatusEnums;
import com.github.pagehelper.PageInfo;

public interface EventService {
	public ServerResponse<Event> save(Event event);
	
	public ServerResponse<Event> queryById(Integer id);
	
	public ServerResponse<PageInfo> queryByMerchant(String merchantName);
	
	public ServerResponse updateStatus(Integer id, StatusEnums.Event status);
	
	public ServerResponse update(Event event);
}
