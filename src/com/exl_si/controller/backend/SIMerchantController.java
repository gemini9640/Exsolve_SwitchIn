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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.exl_si.common.Constants;
import com.exl_si.common.ServerResponse;
import com.exl_si.controller.base.BaseController;
import com.exl_si.controller.vo.SIMemberReturnMsg;
import com.exl_si.controller.vo.SIMerchantReturnMsg;
import com.exl_si.controller.vo.SIMerchantWithPICParam;
import com.exl_si.db.SIMerchant;
import com.exl_si.db.SIMerchantDOC;
import com.exl_si.db.SIMerchantPIC;
import com.exl_si.db.vo.SIMerchantWithAssociated;
import com.exl_si.db.vo.SIMerchantWithPIC;
import com.exl_si.db.vo.SubFile;
import com.exl_si.enums.MerchantEnums;
import com.exl_si.enums.MerchantEnums.FileType;
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
    public ModelAndView add(SIMerchant merchant, MultipartHttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		SIMerchantReturnMsg returnMsg = new SIMerchantReturnMsg();
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
		if(returnMsg.validatedForNew()) {
			mv.addObject("returnMsg", returnMsg);
			mv.setViewName("user/merchant/create");
		} else{
			Timestamp createTime = DateUtils.convertToTimestamp(new Date());
			merchant.setCreatetime(createTime);
			merchant.setLastupdatetime(createTime);
			merchant.setStatus(MerchantEnums.STATUS.INIT.getCode());
			ServerResponse<SIMerchant> response = merchantService.save(merchant, request);
			if(response.isSuccess()) {
				returnMsg.setErrormsg("merchant creation succeed");
				mv.addObject("returnMsg", returnMsg);
				mv.addObject("merchant",response.getData());
				SIMerchantPIC pic = new SIMerchantPIC();
				pic.setId(response.getData().getLastloginpicid());
				mv.addObject("pic",pic);
				mv.setViewName("user/merchant/detail");
			} else {
				returnMsg.setErrormsg(response.getMsg());
				mv.addObject("returnMsg", returnMsg);
				mv.setViewName("user/merchant/create");
			}
		}
		return mv;
    }
	
	@RequestMapping(value = "edit.do", method = RequestMethod.POST)
	@ResponseBody
    public ModelAndView edit(SIMerchant merchant, MultipartHttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/merchant/detail");
		SIMerchantReturnMsg returnMsg = new SIMerchantReturnMsg();
		if(returnMsg.validatedForEdit())
			mv.addObject("returnMsg", returnMsg);
		else {
			Timestamp lastupdatetime = DateUtils.convertToTimestamp(new Date());
			merchant.setLastupdatetime(lastupdatetime);
			ServerResponse<SIMerchant> response = merchantService.update(merchant,request);
			if(response.isSuccess()) {
				returnMsg.setErrormsg("merchant info updated");
				mv.addObject("merchant",response.getData());
				SIMerchantPIC pic = new SIMerchantPIC();
				pic.setId(response.getData().getLastloginpicid());
				mv.addObject("pic",pic);
			} else
				returnMsg.setErrormsg(response.getMsg());
			mv.addObject("returnMsg", returnMsg);
		}
		return mv;
	}
	
	@RequestMapping(value = "detail.do")
    public ModelAndView detail(String merchantId) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/merchant/detail");
		SIMemberReturnMsg returnMsg = new SIMemberReturnMsg();
		if(returnMsg.validatedForEdit())  //test
			mv.addObject("returnMsg", returnMsg);
		else {
			ServerResponse<SIMerchant> response = merchantService.query(merchantId);
			if(response.isSuccess()) {
				mv.addObject("merchant",response.getData());
				SIMerchantPIC pic = new SIMerchantPIC();
				pic.setId(response.getData().getLastloginpicid());
				mv.addObject("pic",pic);
			}
			mv.addObject("returnMsg", returnMsg);
		}
		return mv;
	}
	
	@RequestMapping(value = "pic.do")
    public ModelAndView pic(String id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/merchant/pic");
		SIMemberReturnMsg returnMsg = new SIMemberReturnMsg();
		if(returnMsg.validatedForEdit())  //test
			mv.addObject("returnMsg", returnMsg);
		else {
			ServerResponse<SIMerchantPIC> response = merchantService.queryPIC(id);
			if(response.isSuccess()) {
				mv.addObject("pic",response.getData());
				SIMerchant merchant = new SIMerchant();
				merchant.setId(response.getData().getMerchantid());
				mv.addObject("merchant",merchant);
			}
			mv.addObject("returnMsg", returnMsg);
		}
		return mv;
	}
	
	@RequestMapping(value = "edit_pic.do")
    public ModelAndView editPic(SIMerchantPIC pic) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/merchant/pic");
		SIMemberReturnMsg returnMsg = new SIMemberReturnMsg();
		if(returnMsg.validatedForEdit())  //test
			mv.addObject("returnMsg", returnMsg);
		else {
			ServerResponse<SIMerchantPIC> response = merchantService.updatePIC(pic);
			if(response.isSuccess()) {
				returnMsg.setErrormsg("pic info updated");
				mv.addObject("pic",response.getData());
				SIMerchant merchant = new SIMerchant();
				merchant.setId(response.getData().getMerchantid());
				mv.addObject("merchant",merchant);
			} else 
				returnMsg.setErrormsg(response.getMsg());
			mv.addObject("returnMsg", returnMsg);
		}
		return mv;
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
	
	@RequestMapping(value = "uploadSingleDoc.do", method = RequestMethod.POST)
    public ModelAndView uploadSingleDoc(String merchantId, String picId, Integer type, MultipartHttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		SIMerchantReturnMsg returnMsg = new SIMerchantReturnMsg();
		if(StringUtils.isEmpty(merchantId)) {
			returnMsg.setErrormsg("merchant id cannot be empty");
			return new ModelAndView("user/merchant/list");
		}
			
		
		if(returnMsg.validatedForEdit())
			mv.addObject("returnMsg", returnMsg);
		else {
			ServerResponse<SubFile> response = merchantService.uploadSingleDoc(request, merchantId, FileType.getEnumByCode(type));
			if(response.isSuccess()) {
				MerchantEnums.FileType fileType = MerchantEnums.FileType.getEnumByCode(type);
				List<SIMerchantDOC> list = merchantService.selectDocByMerchantIdAndType(merchantId, fileType.getDesc());
				mv.addObject("list",list);
				assembleReturnObjForMv(mv, merchantId, picId);
				if(type != null && type.intValue() == FileType.BANNER.getCode()) {
					returnMsg.setErrormsg("banner updated");
					mv.setViewName("user/merchant/banner");
					mv.addObject("banner",response.getData());
				} else if(type != null && type.intValue() == FileType.QR.getCode()) {
					returnMsg.setErrormsg("qr code updated");
					mv.setViewName("user/merchant/qr");
					mv.addObject("qr",response.getData());
				} else if(type != null && type.intValue() == FileType.DCUMENT.getCode()) {
					returnMsg.setErrormsg("document updated");
					mv.setViewName("user/merchant/doc");
					mv.addObject("document",response.getData());
				} 
			} else
				returnMsg.setErrormsg(response.getMsg());
			mv.addObject("returnMsg", returnMsg);
		}
		return mv;
	}
	
	@RequestMapping(value = "list_doc.do")
    public ModelAndView list_doc(String merchantId, String picId, Integer type) {
		ModelAndView mv = new ModelAndView();
		MerchantEnums.FileType fileType = MerchantEnums.FileType.getEnumByCode(type);
		List<SIMerchantDOC> list = merchantService.selectDocByMerchantIdAndType(merchantId, fileType.getDesc());
		mv.addObject("list",list);
		assembleReturnObjForMv(mv, merchantId, picId);
		if(fileType == MerchantEnums.FileType.DCUMENT)
			mv.setViewName("user/merchant/doc");
		else if(fileType == MerchantEnums.FileType.BANNER)
			mv.setViewName("user/merchant/banner");
		else if(fileType == MerchantEnums.FileType.QR)
			mv.setViewName("user/merchant/qr");
		return mv;
	}
	
	private void assembleReturnObjForMv(ModelAndView mv, String merchantId, String picId) {
		SIMerchant merchant = new SIMerchant();
		merchant.setId(merchantId);
		mv.addObject("merchant", merchant);
		SIMerchantPIC pic = new SIMerchantPIC();
		pic.setId(picId);
		mv.addObject("pic", pic);
	}
}
