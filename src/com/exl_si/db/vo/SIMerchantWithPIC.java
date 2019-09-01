package com.exl_si.db.vo;

import com.exl_si.db.SIMerchant;
import com.exl_si.db.SIMerchantPIC;

public class SIMerchantWithPIC {
	private SIMerchant merchant;
	private SIMerchantPIC merchantPIC;

	public SIMerchantWithPIC() {
	}

	public SIMerchantWithPIC(SIMerchant merchant, SIMerchantPIC merchantPIC) {
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
