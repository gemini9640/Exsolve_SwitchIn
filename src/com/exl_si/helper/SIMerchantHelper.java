package com.exl_si.helper;

import com.exl_si.common.Constants;
import com.exl_si.db.SIMerchant;
import com.exl_si.utils.MD5;
import com.exl_si.utils.MD5Util;

public class SIMerchantHelper {
	public static SIMerchant assembleSIMerchant4ChangePassword(String username, String password) {
		SIMerchant merchant = new SIMerchant();
		merchant.setPassword(getPassword(username, password));
		return merchant;
	}
	
	public static String getPassword(String username, String password) {
		return MD5Util.MD5EncodeUtf8(username+password+Constants.MD5_SALT).toLowerCase();
	}
}
