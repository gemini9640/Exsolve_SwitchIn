package com.exl_si.controller.vo;

import com.exl_si.db.SIMerchant;
import com.exl_si.db.SIMerchantPIC;

public class SIMerchantWithPICParam {
	private SIMerchant merchant;
	private SIMerchantPIC merchantPIC;
	
	public SIMerchantWithPICParam() {
	}
	
	public SIMerchantWithPICParam(SIMerchant merchant, SIMerchantPIC merchantPIC) {
		this.merchant = merchant;
		this.merchantPIC = merchantPIC;
	}
	public SIMerchant getMerchant() {
		return merchant;
	}
	public void setMerchant(SIMerchant merchant) {
		this.merchant = merchant;
	}
	public SIMerchantPIC getMerchantPIC() {
		return merchantPIC;
	}
	public void setMerchantPIC(SIMerchantPIC merchantPIC) {
		this.merchantPIC = merchantPIC;
	}
	
}
