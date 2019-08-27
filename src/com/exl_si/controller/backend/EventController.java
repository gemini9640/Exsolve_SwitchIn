package com.exl_si.controller.backend;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.exl_si.common.AppProperties;
import com.exl_si.common.Constants;
import com.exl_si.common.ServerResponse;
import com.exl_si.controller.base.BaseController;
import com.exl_si.controller.vo.EventReturnMsg;
import com.exl_si.db.Event;
import com.exl_si.db.vo.SubFile;
import com.exl_si.db.vo.FileObjectProvider.FileObjectEnums;
import com.exl_si.enums.EventEnums;
import com.exl_si.enums.ResponseCode;
import com.exl_si.exception.UploadException;
import com.exl_si.helper.EventHelper;
import com.exl_si.service.EventService;
import com.exl_si.utils.DateUtils;
import com.exl_si.utils.DeleteFileUtil;
import com.exl_si.utils.StringUtils;
import com.exl_si.utils.UploadUtil;

@Controller
@RequestMapping("/manage/event")
public class EventController extends BaseController {
	@Autowired
    private EventService eventService;
	
	@RequestMapping(value="/uploadImg")
	@ResponseBody
	public ServerResponse uploadImg(HttpSession session, MultipartHttpServletRequest request, Integer eventId){
		try {
			List<SubFile> uploadedFiles = UploadUtil.uploadFileByIOStream(request, AppProperties.UPLOAD_PATH, FileObjectEnums.EVENT_PICTURE);
			if(uploadedFiles != null && !uploadedFiles.isEmpty())
				return eventService.saveEventPicture(EventHelper.assembleEventPicture(eventId, "", uploadedFiles));
			return ServerResponse.createByErrorMsg("upload fail");
		} catch (UploadException ue) {
			if(ue.getIoe() != null) {
				ue.getIoe().printStackTrace();
				if(ue.getPath() != null)
					DeleteFileUtil.delete(ue.getPath());
			} else 
				ue.printStackTrace();
			return ServerResponse.createByErrorMsg(ue.getMessage());
		} catch (InstantiationException e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMsg(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMsg(e.getMessage());
		} 
	}
	
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	@ResponseBody
    public ServerResponse add(Event event) {
		EventReturnMsg returnMsg = new EventReturnMsg();
//		if(StringUtils.isEmpty(merchant.getUsername()))
//			errormsg = "username cannot be empty";
		
		if(!returnMsg.validatedForEdit())
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ERROR_PARAM, returnMsg);	
		else {
			Timestamp createTime = DateUtils.convertToTimestamp(new Date());
			event.setCreatetime(createTime);
			event.setStatus(EventEnums.STATUS.INIT.getCode());
			return eventService.save(event);
		}
    }
	
	@RequestMapping(value = "edit.do", method = RequestMethod.POST)
	@ResponseBody
    public ServerResponse edit(Event event) {
		EventReturnMsg returnMsg = new EventReturnMsg();
		if(event.getId() == null)
			returnMsg.setId("no event id provided");
		if(!returnMsg.validatedForEdit())
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ERROR_PARAM, returnMsg);
		return eventService.update(event);
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
}
