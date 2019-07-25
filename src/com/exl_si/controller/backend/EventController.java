package com.exl_si.controller.backend;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exl_si.common.Constants;
import com.exl_si.common.ServerResponse;
import com.exl_si.controller.base.BaseController;
import com.exl_si.db.Event;
import com.exl_si.enums.ResponseCode;
import com.exl_si.service.EventService;
import com.exl_si.utils.StringUtils;

@Controller
@RequestMapping("/manage/event")
public class EventController extends BaseController {
	@Autowired
    private EventService eventService;
	
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
    public ModelAndView add(Event event) {
		ModelAndView mv = new ModelAndView();
		String errormsg = null;
//		if(StringUtils.isEmpty(merchant.getUsername()))
//			errormsg = "username cannot be empty";
		event.setCreatetime(new Date());
		event.setStatus(Constants.Flag.ENABLE);
			
		if(errormsg != null) {
			mv.addObject("errormsg", errormsg);
			mv.setViewName("/WEB-INF/jsp/user/event_detail");
		} else {
			ServerResponse response = eventService.save(event);
			if(response.getStatus() == ResponseCode.ERROR.getCode()) {
				mv.addObject("errormsg", response.getMsg());
				mv.setViewName("/WEB-INF/jsp/user/event_detail");
			} else {
				mv.setViewName("forward:/home/user/event_detail.htm");
			}
		}
		return mv;
    }
}
