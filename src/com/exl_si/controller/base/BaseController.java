package com.exl_si.controller.base;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.exl_si.common.Constants;
import com.exl_si.db.SIMember;
import com.exl_si.db.SIMerchant;




public class BaseController {
	
	protected Logger logger = Logger.getLogger(this.getClass());

	
	public SIMember getSessionMember() {
		Object o = getSession().getAttribute(Constants.MEMBER_SESSION);
		if(o == null)
			return null;
		else 
			return (SIMember) o;
	}
	
	public SIMerchant getSessionMerchant() {
		Object o = getSession().getAttribute(Constants.MERCHANT_SESSION);
		if(o == null)
			return null;
		else 
			return (SIMerchant) o;
	}
	
	public HttpServletRequest getRequest() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	public HttpServletResponse getResponse() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
	}
	
	public void responseWriter(String content) {
		try {
			getResponse().setContentType("text/plain;charset=utf-8");
			PrintWriter writer = getResponse().getWriter();
			writer.write(content);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public HttpSession getSession() {
		return getRequest().getSession();
	}
	
}
