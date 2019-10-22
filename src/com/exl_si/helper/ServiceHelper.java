package com.exl_si.helper;

import com.exl_si.common.Constants;
import com.exl_si.utils.MD5;
import com.exl_si.utils.MD5Util;

public class ServiceHelper {
	public static String encriptPassword(String username, String password) {
		String pass = MD5.md5(username+password+Constants.MD5_SALT).toLowerCase();
		return pass;
	}
}
