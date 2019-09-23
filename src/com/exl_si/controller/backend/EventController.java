package com.exl_si.controller.backend;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.exl_si.common.ServerResponse;
import com.exl_si.controller.base.BaseController;
import com.exl_si.controller.vo.EventReturnMsg;
import com.exl_si.db.Event;
import com.exl_si.db.EventPicture;
import com.exl_si.enums.EventEnums;
import com.exl_si.enums.EventEnums.PictureType;
import com.exl_si.service.EventService;
import com.exl_si.utils.DateUtils;
import com.exl_si.utils.StringUtils;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/manage/event")
public class EventController extends BaseController {
	@Autowired
    private EventService eventService;
	
	@RequestMapping(value="/uploadBanner")
	public ServerResponse uploadBanner(HttpSession session, MultipartHttpServletRequest request, String merchantId, String eventId){
		return eventService.uploadPicture(request, merchantId, eventId, PictureType.BANNER);
	}
	
	@RequestMapping(value="/uploaDQR")
	public ServerResponse uploaDQR(HttpSession session, MultipartHttpServletRequest request, String merchantId, String eventId){
		return eventService.uploadPicture(request, merchantId, eventId, PictureType.QR);
	}
	
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
    public ModelAndView add(Event event) {
		ModelAndView mv = new ModelAndView();
		EventReturnMsg returnMsg = new EventReturnMsg();
//		if(StringUtils.isEmpty(merchant.getUsername()))
//			errormsg = "username cannot be empty";
		
//		if(!returnMsg.validatedForEdit())
		if(returnMsg.validatedForEdit()) {
			mv.addObject("returnMsg", returnMsg);
			mv.setViewName("event/create");
		} else {
			Timestamp createTime = DateUtils.convertToTimestamp(new Date());
			event.setCreatetime(createTime);
			event.setStatus(EventEnums.STATUS.PENDING.getCode());
			ServerResponse response =  eventService.save(event);
			if(response.isSuccess()) {
				returnMsg.setErrormsg("event creation succeed");
				mv.addObject("returnMsg", returnMsg);
				mv.addObject("event",response.getData());
				mv.setViewName("event/detail");
			} else {
				returnMsg.setErrormsg(response.getMsg());
				mv.addObject("returnMsg", returnMsg);
				mv.setViewName("event/create");
			}
		}
		return mv;
    }
	
	@RequestMapping(value = "edit.do", method = RequestMethod.POST)
    public ModelAndView edit(Event event) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("event/detail");
		EventReturnMsg returnMsg = new EventReturnMsg();
		if(event.getId() == null) 
			returnMsg.setId("no event id not found");
		else if(returnMsg.validatedForEdit())
			mv.addObject("returnMsg", returnMsg);
		else {
			Timestamp lastupdatetime = DateUtils.convertToTimestamp(new Date());
			event.setUpdatetime(lastupdatetime);
			ServerResponse response = eventService.update(event);
			if(response.isSuccess()) {
				returnMsg.setErrormsg("event info updated");
				mv.addObject("event",response.getData());
			} else
				returnMsg.setErrormsg(response.getMsg());
			mv.addObject("returnMsg", returnMsg);
		}
		return mv;
	}
	
	@RequestMapping(value = "detail.do")
    public ModelAndView detail(String eventId) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("event/detail");
		EventReturnMsg returnMsg = new EventReturnMsg();
		if(returnMsg.validatedForEdit())  //test
			mv.addObject("returnMsg", returnMsg);
		else {
			ServerResponse response = eventService.query(eventId);
			if(response.isSuccess()) 
				mv.addObject("event",response.getData());
			mv.addObject("returnMsg", returnMsg);
		}
		return mv;
	}
	
	@RequestMapping(value = "listByMerchant.do", method = RequestMethod.POST)
	public ModelAndView listByMerchant(String merchantId, Integer pageNum, Integer pageSize) {
		ModelAndView mv = new ModelAndView();
		String errormsg = null;
		if(StringUtils.isEmpty(merchantId))
			errormsg = "merchant id not found";
		if(errormsg != null) {
			mv.addObject("errormsg", errormsg);
			mv.setViewName("/WEB-INF/jsp/merchant/list");
		} else {
			ServerResponse response = eventService.queryByMerchant(merchantId, pageNum, pageSize);
			mv.addObject("page", response.getData());
		}
		return mv;
	}
	
	@RequestMapping(value = "listByProperties.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<PageInfo> listByProperties(HttpServletRequest request) {
		Map<String, Object> properties = new HashMap<String, Object>();
		String merchantId = request.getParameter("merchantId");
		String statusStr = request.getParameter("status");
		String pageNumStr = request.getParameter("pageNum");
		String pageSizeStr = request.getParameter("pageSize");
		String startStr = request.getParameter("start");
		String endStr = request.getParameter("end");
		Date startDate = null;
    	Date endDate = null;
		if(StringUtils.isNotEmpty(startStr) && StringUtils.isNotEmpty(endStr)) {
			startDate = DateUtils.parseDateRemoteDetails(startStr);
			endDate = DateUtils.parseDateRemoteDetails(endStr);
			properties.put("start", startDate);
			properties.put("end", endDate);
		}
		Integer status = Integer.valueOf(statusStr);
		properties.put("merchantId", merchantId);
		properties.put("status", status);
		
		Integer pageNum = Integer.valueOf(pageNumStr);
		Integer pageSize = Integer.valueOf(pageSizeStr);
		return eventService.queryByProperties(properties, pageNum, pageSize);
	}
	
	@RequestMapping(value = "list_doc.do")
    public ModelAndView list_doc(String eventId, Integer type, Integer status) {
		ModelAndView mv = new ModelAndView();
		EventEnums.PictureType fileType = EventEnums.PictureType.getEnumByCode(type);
		List<EventPicture> list = eventService.selectPictureByEventIdAndType(eventId, fileType.getDesc());
		mv.addObject("list",list);
		assembleReturnObjForMv(mv, eventId, status);
		if(fileType == EventEnums.PictureType.QR)
			mv.setViewName("event/qr");
		else if(fileType == EventEnums.PictureType.BANNER)
			mv.setViewName("event/banner");
		return mv;
	}
	
	@RequestMapping(value = "uploadSingleDoc.do", method = RequestMethod.POST)
    public ModelAndView uploadSingleDoc(String eventId, Integer type, Integer status, MultipartHttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		EventReturnMsg returnMsg = new EventReturnMsg();
		if(StringUtils.isEmpty(eventId)) {
			returnMsg.setErrormsg("event id cannot be empty");
			return new ModelAndView("event/list");
		}
			
		
		if(returnMsg.validatedForEdit())
			mv.addObject("returnMsg", returnMsg);
		else {
			ServerResponse response = eventService.uploadSingleDoc(request, eventId, PictureType.getEnumByCode(type).getDesc());
			if(response.isSuccess()) {
				PictureType fileType = PictureType.getEnumByCode(type);
				List<EventPicture> list = eventService.selectPictureByEventIdAndType(eventId, fileType.getDesc());
				mv.addObject("list",list);
				assembleReturnObjForMv(mv, eventId, status);
				if(type != null && type.intValue() == PictureType.BANNER.getCode()) {
					returnMsg.setErrormsg("banner updated");
					mv.setViewName("event/banner");
					mv.addObject("banner",response.getData());
				} else if(type != null && type.intValue() == PictureType.QR.getCode()) {
					returnMsg.setErrormsg("qr code updated");
					mv.setViewName("event/qr");
					mv.addObject("qr",response.getData());
				} 
			} else
				returnMsg.setErrormsg(response.getMsg());
			mv.addObject("returnMsg", returnMsg);
		}
		return mv;
	}
	
	private void assembleReturnObjForMv(ModelAndView mv, String eventId, Integer status) {
		Event event = new Event();
		event.setId(eventId);
		event.setStatus(status);
		mv.addObject("event", event);
	}
}
