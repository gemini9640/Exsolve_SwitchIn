package com.exl_si.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exl_si.common.ServerResponse;
import com.exl_si.db.Event;
import com.exl_si.mapper.EventMapper;
import com.exl_si.service.EventService;

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
}
