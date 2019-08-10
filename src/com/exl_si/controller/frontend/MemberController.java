package com.exl_si.controller.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exl_si.common.ServerResponse;
import com.exl_si.service.SIMemberService;
import com.exl_si.utils.StringUtils;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private SIMemberService memberService;
	
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse login(String username, String password) {
		if(StringUtils.isEmpty(username))
			return ServerResponse.createByErrorMsg("username cannot be empty");
		if(StringUtils.isEmpty(password))
			return ServerResponse.createByErrorMsg("password cannot be empty");
		return memberService.login(username, password);
	}
}
