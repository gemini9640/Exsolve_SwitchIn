package com.exl_si.controller.backend;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	
	
	
	@RequestMapping(value="/user/merchant/list.htm")
	public ModelAndView merchant_list(){
		return new ModelAndView("user/merchant/list");
	}
	
	@RequestMapping(value="/user/merchant/add.htm")
	public ModelAndView merchant_add(){
		return new ModelAndView("user/merchant/create");
	}
	
	@RequestMapping(value="/user/member/list.htm")
	public ModelAndView member_list(){
		return new ModelAndView("user/member/list");
	}
	
	@RequestMapping(value="/user/member/add.htm")
	public ModelAndView member_add(){
		return new ModelAndView("user/member/create");
	}
}
