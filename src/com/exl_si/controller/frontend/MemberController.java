package com.exl_si.controller.frontend;

import java.sql.Timestamp;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.exl_si.common.ServerResponse;
import com.exl_si.db.SIMember;
import com.exl_si.service.SIMemberService;
import com.exl_si.utils.DateUtils;
import com.exl_si.utils.StringUtils;

@Controller
@RequestMapping("/member")
//@CrossOrigin(origins = "dev.switch-in.com.my,mobile.switch-in.com.my", maxAge = 3600)
@CrossOrigin(origins = "*", maxAge = 3600)
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
	
	@RequestMapping(value = "register.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse register(String username, String password, String email, String phone, Integer isSubscribe) {
		if(StringUtils.isEmpty(username))
			return ServerResponse.createByErrorMsg("username cannot be empty");
		if(StringUtils.isEmpty(password))
			return ServerResponse.createByErrorMsg("password cannot be empty");
		if(StringUtils.isEmpty(email))
			return ServerResponse.createByErrorMsg("email cannot be empty");
		if(StringUtils.isEmpty(phone))
			return ServerResponse.createByErrorMsg("password cannot be empty");
		if(isSubscribe == null)
			isSubscribe = 1;
		SIMember member = new SIMember();
		member.setUsername(username);
		member.setPassword(password);
		member.setEmail(email);
		member.setPhone(phone);
		Timestamp createTime = DateUtils.convertToTimestamp(new Date());
		member.setCreatetime(createTime);
		member.setLastupdatetime(createTime);
//		member.setIsSubscribe(isSubscribe);
//		member.setVip(MemberEnums.VIP.NORMAL.getCode());
		return memberService.save(member, null);
	}
	
	@RequestMapping(value = "edit.do", method = RequestMethod.POST)
	@ResponseBody
    public ServerResponse edit(SIMember member, MultipartHttpServletRequest request) {
		if(StringUtils.isEmpty(member.getId()))
			return ServerResponse.createByErrorMsg("member id not found");
		
		Timestamp lastupdatetime = DateUtils.convertToTimestamp(new Date());
		member.setLastupdatetime(lastupdatetime);
		return memberService.update(member, request);
	}
}
