package com.exl_si.controller.backend;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.exl_si.common.ServerResponse;
import com.exl_si.controller.base.BaseController;
import com.exl_si.controller.vo.EXLClientReturnMsg;
import com.exl_si.controller.vo.SIMemberReturnMsg;
import com.exl_si.db.EXLAgent;
import com.exl_si.db.EXLClient;
import com.exl_si.enums.EXLClientEnums;
import com.exl_si.enums.ResponseCode;
import com.exl_si.service.EXLClientService;
import com.exl_si.utils.DateUtils;
import com.exl_si.utils.StringUtils;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/manage/exlclient")
public class EXLClientController extends BaseController {
	@Autowired
	private EXLClientService exlClientService;
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public ModelAndView add(EXLClient client, MultipartHttpServletRequest request) {
		EXLClientReturnMsg returnMsg = new EXLClientReturnMsg();
		ModelAndView mv = new ModelAndView();
		if(StringUtils.isEmpty(client.getUsername()))
			returnMsg.setUsername("username cannot be empty");
		
//		if(!returnMsg.validatedForNew())
		if(returnMsg.validatedForNew()) {
			mv.addObject("returnMsg", returnMsg);
			mv.setViewName("user/exl_client/create");
		} else {
			Timestamp createTime = DateUtils.convertToTimestamp(new Date());
			client.setCreatetime(createTime);
			client.setLastupdatetime(createTime);
			client.setStatus(EXLClientEnums.STATUS.INIT.getCode());
			ServerResponse<EXLClient> response = exlClientService.save(client, request);
			if(response.isSuccess()) {
				returnMsg.setErrormsg("client creation succeed");
				mv.addObject("returnMsg", returnMsg);
				mv.addObject("client",response.getData());
				mv.setViewName("user/exl_client/detail");
			} else {
				returnMsg.setErrormsg(response.getMsg());
				mv.addObject("returnMsg", returnMsg);
				mv.setViewName("user/exl_client/create");
			}
		}
		return mv;
	}
	
	@RequestMapping(value = "edit.do", method = RequestMethod.POST)
    public ModelAndView edit(EXLClient client, MultipartHttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/exl_client/detail");
		EXLClientReturnMsg returnMsg = new EXLClientReturnMsg();
		if(returnMsg.validatedForEdit())
			mv.addObject("returnMsg", returnMsg);
		else {
			Timestamp lastupdatetime = DateUtils.convertToTimestamp(new Date());
			client.setLastupdatetime(lastupdatetime);
			ServerResponse<EXLClient> response = exlClientService.update(client, request);
			if(response.isSuccess()) {
				returnMsg.setErrormsg("client info updated");
				mv.addObject("client",response.getData());
			} else
				returnMsg.setErrormsg(response.getMsg());
			mv.addObject("returnMsg", returnMsg);
		}
		return mv;
	}
	
	@RequestMapping(value = "detail.do")
    public ModelAndView detail(String id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/exl_client/detail");
		SIMemberReturnMsg returnMsg = new SIMemberReturnMsg();
		if(returnMsg.validatedForEdit())  //test
			mv.addObject("returnMsg", returnMsg);
		else {
			ServerResponse<EXLClient> response = exlClientService.query(id);
			if(response.isSuccess()) 
				mv.addObject("client",response.getData());
			mv.addObject("returnMsg", returnMsg);
		}
		return mv;
	}
//	edit password
	@RequestMapping(value = "editPassword.do", method = RequestMethod.POST)
	@ResponseBody
    public ServerResponse editPassword(String password, String confirmPassword) {
		String errormsg = null;
		if(StringUtils.isEmpty(password))
			errormsg = "password cannot be empty";
		else if(StringUtils.equals(password, confirmPassword))
			errormsg = "confirmPassword must be the same with new password";
		
		if(errormsg != null)
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ERROR_PARAM, errormsg);
		return exlClientService.changePasswordWithoutCheckPassword(getSessionMerchant().getUsername(), password);
	}
	
	@RequestMapping(value = "listPageByProperties.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PageInfo> listPageByProperties(HttpServletRequest request) {
		Map<String, Object> properties = new HashMap<String, Object>();
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
		Integer pageNum = Integer.valueOf(pageNumStr);
		Integer pageSize = Integer.valueOf(pageSizeStr);
        return exlClientService.selectPageByProperties(properties, pageNum, pageSize);
    }
	
	@RequestMapping(value = "ajaxEdit.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse ajaxEdit(EXLClient client) {
		if(client.getId() == null) 
			return ServerResponse.createByErrorMsg("client id not found"); 
		Timestamp lastupdatetime = DateUtils.convertToTimestamp(new Date());
		client.setLastupdatetime(lastupdatetime);
		return exlClientService.update(client, null);
	}
}
