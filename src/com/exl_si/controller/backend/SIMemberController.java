package com.exl_si.controller.backend;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.exl_si.common.Constants;
import com.exl_si.common.ServerResponse;
import com.exl_si.controller.base.BaseController;
import com.exl_si.controller.vo.SIMemberReturnMsg;
import com.exl_si.db.SIMember;
import com.exl_si.enums.MemberEnums;
import com.exl_si.enums.ResponseCode;
import com.exl_si.service.SIMemberService;
import com.exl_si.utils.DateUtils;
import com.exl_si.utils.StringUtils;

@Controller
@RequestMapping("/manage/member")
public class SIMemberController extends BaseController {
	@Autowired
	private SIMemberService memberService;
//	add
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse add(SIMember member) {
		SIMemberReturnMsg returnMsg = new SIMemberReturnMsg();
		String errormsg = null;
		if(StringUtils.isEmpty(member.getUsername()))
			returnMsg.setUsername("username cannot be empty");
		
		if(!returnMsg.validatedForNew())
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ERROR_PARAM, returnMsg);
		else {
			Timestamp createTime = DateUtils.convertToTimestamp(new Date());
			member.setCreatetime(createTime);
			member.setLastupdatetime(createTime);
			member.setStatus(MemberEnums.STATUS.INIT.getCode());
			return memberService.save(member);
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
		return memberService.changePasswordWithoutCheckPassword(getSessionMerchant().getUsername(), password);
	}
	
//	edit
	@RequestMapping(value = "edit.do", method = RequestMethod.POST)
	@ResponseBody
    public ServerResponse edit(SIMember member) {
		SIMemberReturnMsg returnMsg = new SIMemberReturnMsg();
		if(!returnMsg.validatedForEdit())
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ERROR_PARAM, returnMsg);
		else {
			Timestamp lastupdatetime = DateUtils.convertToTimestamp(new Date());
			member.setLastupdatetime(lastupdatetime);
			return memberService.update(member);
		}
	}
	
}
