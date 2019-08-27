package com.exl_si.controller.backend;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exl_si.common.AppProperties;
import com.exl_si.common.Constants;
import com.exl_si.controller.base.BaseController;
import com.exl_si.utils.UploadUtil;



@Controller
@RequestMapping(value="manage/img")
public class ImgManageController extends BaseController {

	@RequestMapping(value="/showByPath.do")
	@ResponseBody
	public void showByPath(String path) {
		try{
			String filePath = AppProperties.UPLOAD_PATH+path;
			getResponse().setHeader("Pragma", "No-cache");
			getResponse().setHeader("Cache-Control", "no-cache");
			getResponse().setDateHeader("Expires", 0);
			getResponse().setHeader("content-type", "image/jpeg");
			UploadUtil.showByIOStream(filePath, getResponse().getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(getResponse().getOutputStream() != null) {
					getResponse().getOutputStream().flush();
					getResponse().getOutputStream().close();
					getResponse().flushBuffer();
				}
			} catch (IOException e) {
				e.printStackTrace();
				responseWriter("error");
			}
		}
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}
}
