package com.exl_si.controller.backend;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.exl_si.common.AppProperties;
import com.exl_si.common.Constants;
import com.exl_si.common.ServerResponse;
import com.exl_si.controller.base.BaseController;
import com.exl_si.controller.vo.SIMemberReturnMsg;
import com.exl_si.db.SIMember;
import com.exl_si.db.vo.SubFile;
import com.exl_si.db.vo.FileObjectProvider.FileObjectEnums;
import com.exl_si.enums.MemberEnums;
import com.exl_si.enums.MemberEnums.STATUS;
import com.exl_si.enums.ResponseCode;
import com.exl_si.exception.UploadException;
import com.exl_si.helper.EventHelper;
import com.exl_si.helper.SIMemberHelper;
import com.exl_si.service.SIMemberService;
import com.exl_si.utils.DateUtils;
import com.exl_si.utils.DeleteFileUtil;
import com.exl_si.utils.StringUtils;
import com.exl_si.utils.UploadUtil;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/manage/member")
public class SIMemberController extends BaseController {
	@Autowired
	private SIMemberService memberService;
//	add
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
//	@ResponseBody
	public ModelAndView add(SIMember member, MultipartHttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		SIMemberReturnMsg returnMsg = new SIMemberReturnMsg();
		if(StringUtils.isEmpty(member.getUsername())) 
			returnMsg.setUsername("username cannot be empty");
			
//		if(!returnMsg.validatedForNew())
		if(returnMsg.validatedForNew()) { //test
			mv.addObject("returnMsg", returnMsg);
			mv.setViewName("user/member/create");
		} else {
			Timestamp createTime = DateUtils.convertToTimestamp(new Date());
			member.setCreatetime(createTime);
			member.setLastupdatetime(createTime);
			member.setStatus(STATUS.INIT.getCode());
			ServerResponse response =  memberService.save(member, request);
			if(response.isSuccess()) {
				returnMsg.setErrormsg("member creation succeed");
				mv.addObject("returnMsg", returnMsg);
				mv.addObject("result",response.getData());
				mv.setViewName("user/member/detail");
			} else {
				returnMsg.setErrormsg(response.getMsg());
				mv.addObject("returnMsg", returnMsg);
				mv.setViewName("user/member/create");
			}
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
        return memberService.selectPageByProperties(properties, pageNum, pageSize);
    }
	
	@RequestMapping(value="/uploadProfile")
	@ResponseBody
	public ServerResponse uploadProfile(HttpSession session, MultipartHttpServletRequest request, String type){
		try {
			List<SubFile> uploadedFiles = UploadUtil.uploadFileByIOStream(request, AppProperties.UPLOAD_PATH, FileObjectEnums.EVENT_PICTURE);
			if(uploadedFiles != null && !uploadedFiles.isEmpty())
				return memberService.initUploadFile(SIMemberHelper.assembleInitMemberFile("", type, uploadedFiles));
			return ServerResponse.createByErrorMsg("upload fail");
		} catch (UploadException ue) {
			if(ue.getIoe() != null) {
				ue.getIoe().printStackTrace();
				if(ue.getPath() != null)
					DeleteFileUtil.delete(ue.getPath());
			} else 
				ue.printStackTrace();
			return ServerResponse.createByErrorMsg(ue.getMessage());
		} catch (InstantiationException e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMsg(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMsg(e.getMessage());
		} 
	}
}
