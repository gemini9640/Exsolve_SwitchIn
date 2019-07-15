package com.exl_si.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exl_si.common.ServerResponse;
import com.exl_si.db.Event;
import com.exl_si.enums.StatusEnums;
import com.exl_si.mapper.EventMapper;
import com.exl_si.service.EventService;
import com.github.pagehelper.PageInfo;

@Service("eventService")
public class EventServiceImpl implements EventService{
	@Autowired
	private EventMapper eventMapper;
	
	public ServerResponse<Event> save(Event event) {
		if(eventMapper.insertSelective(event)>0)
			return ServerResponse.createBySuccess(event);
		else 
			return ServerResponse.createByErrorMsg("create fail");
	}
	
	public ServerResponse<Event> queryById(Integer id) {
		Event event = eventMapper.selectByPrimaryKey(id);
		if(event == null)
			return ServerResponse.createByErrorMsg("event not found");
		return ServerResponse.createBySuccess(event);
	}
	
	public ServerResponse<PageInfo> queryByMerchant(String merchantName) {
		List<Event> list = eventMapper.selectByMerchant(merchantName);
		return ServerResponse.createBySuccess(new PageInfo(list));
	} 
	
	public ServerResponse updateStatus(Integer id, StatusEnums.Event status) {
		if(eventMapper.updateStatus(id, status.getCode())>0)
			return ServerResponse.createBySuccess();
		else 
			return ServerResponse.createByErrorMsg("approve fail");
	}
	
	public ServerResponse update(Event event) {
		if(eventMapper.updateByPrimaryKeySelective(event)>0)
			return ServerResponse.createBySuccess();
		else 
			return ServerResponse.createByErrorMsg("update fail");
	}
}
