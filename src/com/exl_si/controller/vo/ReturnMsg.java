package com.exl_si.controller.vo;

public class ReturnMsg {
	private String errormsg;

	public ReturnMsg() {
	}

	public ReturnMsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	
}
