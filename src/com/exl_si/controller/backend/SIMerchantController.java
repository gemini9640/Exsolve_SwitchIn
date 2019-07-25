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
import com.exl_si.db.SIMerchant;
import com.exl_si.enums.ResponseCode;
import com.exl_si.service.SIMerchantService;
import com.exl_si.utils.DateUtils;
import com.exl_si.utils.StringUtils;

@Controller
@RequestMapping("/manage/merchant")
public class SIMerchantController extends BaseController {
	@Autowired
    private SIMerchantService merchantService;
	
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
    public ModelAndView add(SIMerchant merchant) {
		ModelAndView mv = new ModelAndView();
		String errormsg = null;
		if(StringUtils.isEmpty(merchant.getUsername()))
			errormsg = "username cannot be empty";
//		if(StringUtils.isEmpty(merchant.getPassword()))
//			return ServerResponse.createByErrorMsg("password cannot be empty");
//		else if(StringUtils.isEmpty(merchant.getFullName()))
//			errormsg = "full name cannot be empty";
//		else if(StringUtils.isEmpty(merchant.getEmail()))
//			errormsg = "email cannot be empty";
//		else if(StringUtils.isEmpty(merchant.getCompany()))
//			errormsg = "company cannot be empty";
//		else if(StringUtils.isEmpty(merchant.getRegNo()))
//			errormsg = "company reg. cannot be empty";
//		else if(StringUtils.isEmpty(merchant.getPhone()))
//			errormsg = "phone cannot be empty";
//		else if(StringUtils.isEmpty(merchant.getGender()))
//			errormsg = "gender cannot be empty";
//		else if(StringUtils.isEmpty(merchant.getIc()))
//			errormsg = "IC cannot be empty";
//		if(StringUtils.isEmpty(merchant.getRole()))
//			return ServerResponse.createByErrorMsg("must assign a role");
		;
		merchant.setCreatetime(DateUtils.convertToTimestamp(new Date()));
		merchant.setStatus(Constants.Flag.ENABLE);
			
		if(errormsg != null) {
			mv.addObject("errormsg", errormsg);
			mv.setViewName("/WEB-INF/jsp/user/merchant_detail");
		} else {
			ServerResponse response = merchantService.save(merchant);
			if(response.getStatus() == ResponseCode.ERROR.getCode()) {
				mv.addObject("errormsg", response.getMsg());
				mv.setViewName("/WEB-INF/jsp/user/merchant_detail");
			} else {
				mv.setViewName("forward:/home/user/merchant_detail.htm");
			}
		}
		return mv;
    }
}
