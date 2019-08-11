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
import com.exl_si.common.ServerResponse;
import com.exl_si.controller.base.BaseController;
import com.exl_si.controller.vo.EXLAgentReturnMsg;
import com.exl_si.db.EXLAgent;
import com.exl_si.enums.EXLAgentEnums;
import com.exl_si.enums.ResponseCode;
import com.exl_si.service.EXLAgentService;
import com.exl_si.utils.DateUtils;
import com.exl_si.utils.StringUtils;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/manage/exlagent")
public class EXLAgentController extends BaseController {
	@Autowired
	private EXLAgentService exlAgentService;
//	add
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse add(EXLAgent agent) {
		EXLAgentReturnMsg returnMsg = new EXLAgentReturnMsg();
		String errormsg = null;
		if(StringUtils.isEmpty(agent.getUsername()))
			returnMsg.setUsername("username cannot be empty");
		
//		if(!returnMsg.validatedForNew())
		if(returnMsg.validatedForNew())
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ERROR_PARAM, returnMsg);
		else {
			Timestamp createTime = DateUtils.convertToTimestamp(new Date());
			agent.setCreatetime(createTime);
			agent.setLastupdatetime(createTime);
			agent.setStatus(EXLAgentEnums.STATUS.INIT.getCode());
			return exlAgentService.save(agent);
		}
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
		return exlAgentService.changePasswordWithoutCheckPassword(getSessionMerchant().getUsername(), password);
	}
	
//	edit
	@RequestMapping(value = "edit.do", method = RequestMethod.POST)
	@ResponseBody
    public ServerResponse edit(EXLAgent agent) {
		EXLAgentReturnMsg returnMsg = new EXLAgentReturnMsg();
		if(!returnMsg.validatedForEdit())
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ERROR_PARAM, returnMsg);
		else {
			Timestamp lastupdatetime = DateUtils.convertToTimestamp(new Date());
			agent.setLastupdatetime(lastupdatetime);
			return exlAgentService.update(agent);
		}
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
        return exlAgentService.selectPageByProperties(properties, pageNum, pageSize);
    }
}
