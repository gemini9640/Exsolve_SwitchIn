package com.exl_si.service.helper;

import com.exl_si.db.SIMerchant;

public class SIMerchantHelper extends ServiceHelper{
	public static SIMerchant assembleSIMerchant4ChangePassword(String username, String password) {
		SIMerchant merchant = new SIMerchant();
		merchant.setUsername(username);
		merchant.setPassword(password);
		return merchant;
	}
}
