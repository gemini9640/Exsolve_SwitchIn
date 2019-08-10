package com.exl_si.controller.backend;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	
	
//	@RequestMapping(value="/user/merchant_detail.htm")
//	public ModelAndView merchant_detail(){
//		return new ModelAndView("/WEB-INF/jsp/user/merchant_detail");
//	}
	
	@RequestMapping(value="/user/merchant/list.htm")
	public ModelAndView merchant_list(){
		return new ModelAndView("user/merchant/list");
	}
	
	@RequestMapping(value="/user/merchant/add.htm")
	public ModelAndView staff_add(){
		return new ModelAndView("user/merchant/create");
	}
//	
//	@RequestMapping(value="/user/staff_detail.htm")
//	public ModelAndView staff_detail(){
//		return new ModelAndView("/WEB-INF/jsp/user/staff_detail");
//	}
//	
//	@RequestMapping(value="/user/staff_list.htm")
//	public ModelAndView staff_list(){
//		return new ModelAndView("/WEB-INF/jsp/user/staff_list");
//	}
//	
//	@RequestMapping(value="/user/sales_staff_add.htm")
//	public ModelAndView sales_staff_add(){
//		return new ModelAndView("/WEB-INF/jsp/user/sales_staff_detail");
//	}
//	
//	@RequestMapping(value="/user/sales_staff_detail.htm")
//	public ModelAndView sales_staff_detail(){
//		return new ModelAndView("/WEB-INF/jsp/user/sales_staff_detail");
//	}
//	
//	@RequestMapping(value="/user/sales_staff_list.htm")
//	public ModelAndView sales_staff_list(){
//		return new ModelAndView("/WEB-INF/jsp/user/sales_staff_list");
//	}
}
