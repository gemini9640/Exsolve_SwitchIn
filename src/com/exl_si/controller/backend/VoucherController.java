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

import com.exl_si.common.ServerResponse;
import com.exl_si.controller.base.BaseController;
import com.exl_si.controller.vo.VoucherReturnMsg;
import com.exl_si.db.Voucher;
import com.exl_si.db.VoucherPicture;
import com.exl_si.db.Voucher;
import com.exl_si.db.VoucherPicture;
import com.exl_si.enums.VoucherEnums;
import com.exl_si.enums.VoucherEnums.PictureType;
import com.exl_si.service.VoucherService;
import com.exl_si.utils.DateUtils;
import com.exl_si.utils.StringUtils;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/manage/voucher")
public class VoucherController extends BaseController {
	@Autowired
    private VoucherService voucherService;
	
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
    public ModelAndView add(Voucher voucher) {
		ModelAndView mv = new ModelAndView();
		VoucherReturnMsg returnMsg = new VoucherReturnMsg();
//		if(StringUtils.isEmpty(merchant.getUsername()))
//			errormsg = "username cannot be empty";
		
//		if(!returnMsg.validatedForEdit())
		if(returnMsg.validatedForEdit()) {
			mv.addObject("returnMsg", returnMsg);
			mv.setViewName("voucher/create");
		} else {
			Timestamp createTime = DateUtils.convertToTimestamp(new Date());
			voucher.setCreatetime(createTime);
			voucher.setStatus(VoucherEnums.STATUS.PENDING.getCode());
			ServerResponse response =  voucherService.save(voucher);
			if(response.isSuccess()) {
				returnMsg.setErrormsg("voucher creation succeed");
				mv.addObject("returnMsg", returnMsg);
				mv.addObject("voucher",response.getData());
				mv.setViewName("voucher/detail");
			} else {
				returnMsg.setErrormsg(response.getMsg());
				mv.addObject("returnMsg", returnMsg);
				mv.setViewName("voucher/create");
			}
		}
		return mv;
    }
	
	@RequestMapping(value = "edit.do", method = RequestMethod.POST)
    public ModelAndView edit(Voucher voucher, String editType) {
		ModelAndView mv = new ModelAndView();
		String successMsgType = "info";
		if(StringUtils.isNotEmpty(editType)) 
			successMsgType = editType;
		if(StringUtils.equals(editType, "category")) {
			mv.setViewName("voucher/category");
		} else if(StringUtils.equals(editType, "geographic")) {
			mv.setViewName("voucher/geographic");
		} else 
			mv.setViewName("voucher/detail");
		VoucherReturnMsg returnMsg = new VoucherReturnMsg();
		if(voucher.getId() == null) 
			returnMsg.setId("voucher id not found");
		else if(returnMsg.validatedForEdit())
			mv.addObject("returnMsg", returnMsg);
		else {
			Timestamp lastupdatetime = DateUtils.convertToTimestamp(new Date());
			voucher.setUpdateTime(lastupdatetime);
			ServerResponse response = voucherService.update(voucher);
			if(response.isSuccess()) {
				returnMsg.setErrormsg("voucher "+successMsgType+" updated");
				mv.addObject("voucher",response.getData());
			} else
				returnMsg.setErrormsg(response.getMsg());
			mv.addObject("returnMsg", returnMsg);
		}
		return mv;
	}

	@RequestMapping(value = "ajaxEdit.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse ajaxEdit(Voucher voucher) {
		if(voucher.getId() == null) 
			return ServerResponse.createByErrorMsg("voucher id not found"); 
		Timestamp lastupdatetime = DateUtils.convertToTimestamp(new Date());
		voucher.setUpdateTime(lastupdatetime);
		return voucherService.update(voucher);
	}
	
	@RequestMapping(value = "detail.do")
    public ModelAndView detail(String voucherId) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("voucher/detail");
		VoucherReturnMsg returnMsg = new VoucherReturnMsg();
		if(returnMsg.validatedForEdit())  //test
			mv.addObject("returnMsg", returnMsg);
		else {
			ServerResponse response = voucherService.query(voucherId);
			if(response.isSuccess()) 
				mv.addObject("voucher",response.getData());
			mv.addObject("returnMsg", returnMsg);
		}
		return mv;
	}
	
	@RequestMapping(value = "category.do")
    public ModelAndView category(String voucherId, Integer status) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("voucher/category");
		ServerResponse<String> response = voucherService.queryTagline(voucherId);
		assembleReturnObjForMvTacline(mv, voucherId, status, response.getData());
		return mv;
	}

	@RequestMapping(value = "geographic.do")
    public ModelAndView geographic(String voucherId, Integer status) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("voucher/geographic");
		ServerResponse<String> response = voucherService.queryGeographic(voucherId);
		assembleReturnObjForMvGeographic(mv, voucherId, status, response.getData());
		return mv;
	}
	
	@RequestMapping(value = "listByMerchant.do", method = RequestMethod.POST)
	public ModelAndView listByMerchant(String merchantId, Integer pageNum, Integer pageSize) {
		ModelAndView mv = new ModelAndView();
		String errormsg = null;
		if(StringUtils.isEmpty(merchantId))
			errormsg = "merchant id not found";
		if(errormsg != null) {
			mv.addObject("errormsg", errormsg);
			mv.setViewName("/WEB-INF/jsp/merchant/list");
		} else {
			ServerResponse response = voucherService.queryByMerchant(merchantId, pageNum, pageSize);
			mv.addObject("page", response.getData());
		}
		return mv;
	}
	
	@RequestMapping(value = "listByProperties.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse<PageInfo> listByProperties(HttpServletRequest request) {
		Map<String, Object> properties = new HashMap<String, Object>();
		String merchantId = request.getParameter("merchantId");
		String statusStr = request.getParameter("status");
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
		Integer status = Integer.valueOf(statusStr);
		properties.put("merchantId", merchantId);
		properties.put("status", status);
		
		Integer pageNum = Integer.valueOf(pageNumStr);
		Integer pageSize = Integer.valueOf(pageSizeStr);
		return voucherService.queryByProperties(properties, pageNum, pageSize);
	}
	
	@RequestMapping(value = "list_doc.do")
    public ModelAndView list_doc(String voucherId, Integer type, Integer status) {
		ModelAndView mv = new ModelAndView();
		VoucherEnums.PictureType fileType = VoucherEnums.PictureType.getEnumByCode(type);
		List<VoucherPicture> list = voucherService.selectPictureByVoucherIdAndType(voucherId, fileType.getDesc());
		mv.addObject("list",list);
		assembleReturnObjForMv(mv, voucherId, status);
		if(fileType == VoucherEnums.PictureType.QR)
			mv.setViewName("voucher/qr");
		else if(fileType == VoucherEnums.PictureType.BANNER)
			mv.setViewName("voucher/banner");
		return mv;
	}
	
	@RequestMapping(value = "uploadSingleDoc.do", method = RequestMethod.POST)
    public ModelAndView uploadSingleDoc(String voucherId, Integer type, Integer status, MultipartHttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		VoucherReturnMsg returnMsg = new VoucherReturnMsg();
		if(StringUtils.isEmpty(voucherId)) {
			returnMsg.setErrormsg("voucher id cannot be empty");
			return new ModelAndView("voucher/list");
		}
			
		
		if(returnMsg.validatedForEdit())
			mv.addObject("returnMsg", returnMsg);
		else {
			ServerResponse response = voucherService.uploadSingleDoc(request, voucherId, PictureType.getEnumByCode(type).getDesc());
			if(response.isSuccess()) {
				PictureType fileType = PictureType.getEnumByCode(type);
				List<VoucherPicture> list = voucherService.selectPictureByVoucherIdAndType(voucherId, fileType.getDesc());
				mv.addObject("list",list);
				assembleReturnObjForMv(mv, voucherId, status);
				if(type != null && type.intValue() == PictureType.BANNER.getCode()) {
					returnMsg.setErrormsg("banner updated");
					mv.setViewName("voucher/banner");
					mv.addObject("banner",response.getData());
				} else if(type != null && type.intValue() == PictureType.QR.getCode()) {
					returnMsg.setErrormsg("qr code updated");
					mv.setViewName("voucher/qr");
					mv.addObject("qr",response.getData());
				} 
			} else
				returnMsg.setErrormsg(response.getMsg());
			mv.addObject("returnMsg", returnMsg);
		}
		return mv;
	}
	
	private void assembleReturnObjForMv(ModelAndView mv, String voucherId, Integer status) {
		Voucher voucher = new Voucher();
		voucher.setId(voucherId);
		voucher.setStatus(status);
		mv.addObject("voucher", voucher);
	}
	
	private void assembleReturnObjForMvTacline(ModelAndView mv, String voucherId, Integer status, String categories) {
		Voucher voucher = new Voucher();
		voucher.setId(voucherId);
		voucher.setStatus(status);
		voucher.setTagline(categories);
		mv.addObject("voucher", voucher);
	}
	
	private void assembleReturnObjForMvGeographic(ModelAndView mv, String voucherId, Integer status, String geographic) {
		Voucher voucher = new Voucher();
		voucher.setId(voucherId);
		voucher.setStatus(status);
		voucher.setGeographic(geographic);
		mv.addObject("voucher", voucher);
	}
	
}
