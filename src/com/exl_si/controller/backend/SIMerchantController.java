package com.exl_si.controller.backend;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.exl_si.common.Constants;
import com.exl_si.common.ServerResponse;
import com.exl_si.controller.base.BaseController;
import com.exl_si.controller.vo.SIMerchantReturnMsg;
import com.exl_si.controller.vo.SIMerchantWithAssociatedParam;
import com.exl_si.db.SIMerchant;
import com.exl_si.db.SIMerchantDOC;
import com.exl_si.db.SIMerchantPIC;
import com.exl_si.db.vo.SIMerchantWithAssociated;
import com.exl_si.enums.MerchantEnums;
import com.exl_si.enums.ResponseCode;
import com.exl_si.service.SIMerchantService;
import com.exl_si.utils.DateUtils;
import com.exl_si.utils.StringUtils;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/manage/merchant")
public class SIMerchantController extends BaseController {
	@Autowired
    private SIMerchantService merchantService;
	
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	@ResponseBody
    public ServerResponse add(SIMerchantWithAssociatedParam sIMerchantWithAssociatedParam) {
//		SIMerchant merchant, SIMerchantPIC pic, SIMerchantDOC doc
		SIMerchantReturnMsg returnMsg = new SIMerchantReturnMsg();
		String errormsg = null;
		SIMerchant merchant = sIMerchantWithAssociatedParam.getMerchant();
		SIMerchantPIC pic = sIMerchantWithAssociatedParam.getMerchantPIC();
		if(StringUtils.isEmpty(merchant.getUsername()))
			returnMsg.setUsername("username cannot be empty");
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
		
			
//		if(!returnMsg.validatedForNew())
		if(returnMsg.validatedForNew())//test
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ERROR_PARAM, returnMsg);
		else {
			Timestamp createTime = DateUtils.convertToTimestamp(new Date());
			merchant.setCreatetime(createTime);
			merchant.setLastupdatetime(createTime);
			merchant.setStatus(MerchantEnums.STATUS.INIT.getCode());
			
			if(pic != null) {
				pic.setCreatetime(createTime);
				pic.setLastupdatetime(createTime);
				pic.setStatus(MerchantEnums.STATUS.INIT.getCode());
			}
			List<SIMerchantDOC> docs = new ArrayList<SIMerchantDOC>();
			return merchantService.saveWithAssociated(merchant, pic, docs);
		}
    }
	
	@RequestMapping(value = "edit.do", method = RequestMethod.POST)
	@ResponseBody
    public ServerResponse edit(SIMerchant merchant, SIMerchantPIC pic) {
		SIMerchantReturnMsg returnMsg = new SIMerchantReturnMsg();
		if(!returnMsg.validatedForEdit())
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ERROR_PARAM, returnMsg);
		else {
			Timestamp lastupdatetime = DateUtils.convertToTimestamp(new Date());
			merchant.setLastupdatetime(lastupdatetime);
			pic.setLastupdatetime(lastupdatetime);
			return merchantService.updateWithPIC(merchant, pic);
		}
	}
	
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
		return merchantService.changePasswordWithoutCheckPassword(getSessionMerchant().getUsername(), password);
	}
	
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public ModelAndView login(String username, String password) {
		ModelAndView mv = new ModelAndView();
		ServerResponse response = merchantService.login(username, password);
		if(!response.isSuccess()) {
			SIMerchant merchant = (SIMerchant) response.getData();
			getSession().setAttribute(Constants.MERCHANT_SESSION, merchant);
			mv.addObject("errormsg", response.getMsg());
			mv.setViewName("/WEB-INF/jsp/index");
			return mv;
		} 
		mv.setViewName("/WEB-INF/jsp/user/merchant_detail");
		return mv;
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
        return merchantService.selectPageByProperties(properties, pageNum, pageSize);
    }
}
