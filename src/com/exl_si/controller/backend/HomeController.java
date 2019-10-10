package com.exl_si.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value = "/voucher/add.htm")
	public ModelAndView voucher_add() {
		return new ModelAndView("voucher/create");
	}

	@RequestMapping(value = "/voucher/pending.htm")
	public ModelAndView voucher_pending() {
		return new ModelAndView("voucher/list_pending");
	}

	@RequestMapping(value = "/voucher/active.htm")
	public ModelAndView voucher_active() {
		return new ModelAndView("voucher/list_active");
	}

	@RequestMapping(value = "/voucher/expired.htm")
	public ModelAndView voucher_expired() {
		return new ModelAndView("voucher/list_expired");
	}

	@RequestMapping(value = "/voucher/rejected.htm")
	public ModelAndView voucher_draft() {
		return new ModelAndView("voucher/list_rejected");
	}

	@RequestMapping(value = "/event/add.htm")
	public ModelAndView event_add() {
		return new ModelAndView("event/create");
	}

	@RequestMapping(value = "/event/pending.htm")
	public ModelAndView list_pending() {
		return new ModelAndView("event/list_pending");
	}

	@RequestMapping(value = "/event/active.htm")
	public ModelAndView list_active() {
		return new ModelAndView("event/list_active");
	}

	@RequestMapping(value = "/event/expired.htm")
	public ModelAndView list_expired() {
		return new ModelAndView("event/list_expired");
	}

	@RequestMapping(value = "/event/rejected.htm")
	public ModelAndView list_draft() {
		return new ModelAndView("event/list_rejected");
	}

	@RequestMapping(value = "/user/merchant/pending.htm")
	public ModelAndView merchant_pending() {
		return new ModelAndView("user/merchant/list_pending");
	}

	@RequestMapping(value = "/user/merchant/active.htm")
	public ModelAndView merchant_active() {
		return new ModelAndView("user/merchant/list_active");
	}

	@RequestMapping(value = "/user/merchant/rejected.htm")
	public ModelAndView merchant_rejected() {
		return new ModelAndView("user/merchant/list_rejected");
	}

	@RequestMapping(value = "/user/merchant/add.htm")
	public ModelAndView merchant_add() {
		return new ModelAndView("user/merchant/create");
	}

	@RequestMapping(value = "/user/member/list.htm")
	public ModelAndView member_list() {
		return new ModelAndView("user/member/list");
	}

	@RequestMapping(value = "/user/member/add.htm")
	public ModelAndView member_add() {
		return new ModelAndView("user/member/create");
	}

	@RequestMapping(value = "/user/exlagent/list.htm")
	public ModelAndView exl_agent_list() {
		return new ModelAndView("user/exl_agent/list");
	}

	@RequestMapping(value = "/user/exlagent/add.htm")
	public ModelAndView exl_agent_add() {
		return new ModelAndView("user/exl_agent/create");
	}

	@RequestMapping(value = "/user/exlclient/list.htm")
	public ModelAndView exl_client_list() {
		return new ModelAndView("user/exl_client/list");
	}

	@RequestMapping(value = "/user/exlclient/add.htm")
	public ModelAndView exl_client_add() {
		return new ModelAndView("user/exl_client/create");
	}
}
