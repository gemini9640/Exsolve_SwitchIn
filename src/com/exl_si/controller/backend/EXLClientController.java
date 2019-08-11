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
import com.exl_si.controller.vo.EXLClientReturnMsg;
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
//	add
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse add(EXLClient client) {
		EXLClientReturnMsg returnMsg = new EXLClientReturnMsg();
		String errormsg = null;
		if(StringUtils.isEmpty(client.getUsername()))
			returnMsg.setUsername("username cannot be empty");
		
//		if(!returnMsg.validatedForNew())
		if(returnMsg.validatedForNew())
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ERROR_PARAM, returnMsg);
		else {
			Timestamp createTime = DateUtils.convertToTimestamp(new Date());
			client.setCreatetime(createTime);
			client.setLastupdatetime(createTime);
			client.setStatus(EXLClientEnums.STATUS.INIT.getCode());
			return exlClientService.save(client);
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
		return exlClientService.changePasswordWithoutCheckPassword(getSessionMerchant().getUsername(), password);
	}
	
//	edit
	@RequestMapping(value = "edit.do", method = RequestMethod.POST)
	@ResponseBody
    public ServerResponse edit(EXLClient client) {
		EXLClientReturnMsg returnMsg = new EXLClientReturnMsg();
		if(!returnMsg.validatedForEdit())
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ERROR_PARAM, returnMsg);
		else {
			Timestamp lastupdatetime = DateUtils.convertToTimestamp(new Date());
			client.setLastupdatetime(lastupdatetime);
			return exlClientService.update(client);
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
        return exlClientService.selectPageByProperties(properties, pageNum, pageSize);
    }
}
