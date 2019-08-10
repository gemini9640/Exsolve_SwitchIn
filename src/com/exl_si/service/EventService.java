package com.exl_si.service;

import java.util.List;

import com.exl_si.common.ServerResponse;
import com.exl_si.db.Event;
import com.exl_si.db.EventPicture;
import com.exl_si.enums.EventEnums;
import com.github.pagehelper.PageInfo;

public interface EventService {
	public ServerResponse<Event> save(Event event);
	
	public ServerResponse<Event> queryById(Integer id);
	
	public ServerResponse<PageInfo> queryByMerchant(String merchantName, Integer pageNum, Integer pageSize);
	
	public ServerResponse updateStatus(Integer id, EventEnums.STATUS status);
	
	public ServerResponse update(Event event);
	
	public ServerResponse saveEventPicture(List<EventPicture> eventPictures);
}
