package com.exl_si.controller.backend;

import java.sql.Timestamp;
import java.util.Date;

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

@Controller
@RequestMapping("/manage/client")
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
		
		if(!returnMsg.validatedForNew())
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
	
}
