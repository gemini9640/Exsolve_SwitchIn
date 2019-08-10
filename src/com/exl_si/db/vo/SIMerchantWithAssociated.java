package com.exl_si.db.vo;

import java.util.List;

import com.exl_si.db.SIMerchant;
import com.exl_si.db.SIMerchantDOC;
import com.exl_si.db.SIMerchantPIC;

public class SIMerchantWithAssociated {
	private SIMerchant merchant;
	private List<SIMerchantPIC> merchantPIC;
	private List<SIMerchantDOC> merchantDOC;
	
	public SIMerchantWithAssociated() {
	}
	
	public SIMerchantWithAssociated(SIMerchant merchant, List<SIMerchantPIC> merchantPIC,
			List<SIMerchantDOC> merchantDOC) {
		this.merchant = merchant;
		this.merchantPIC = merchantPIC;
		this.merchantDOC = merchantDOC;
	}
	public SIMerchant getMerchant() {
		return merchant;
	}
	public void setMerchant(SIMerchant merchant) {
		this.merchant = merchant;
	}
	public List<SIMerchantPIC> getMerchantPIC() {
		return merchantPIC;
	}
	public void setMerchantPIC(List<SIMerchantPIC> merchantPIC) {
		this.merchantPIC = merchantPIC;
	}
	public List<SIMerchantDOC> getMerchantDOC() {
		return merchantDOC;
	}
	public void setMerchantDOC(List<SIMerchantDOC> merchantDOC) {
		this.merchantDOC = merchantDOC;
	}
	
}
