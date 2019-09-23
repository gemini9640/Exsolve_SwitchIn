package com.exl_si.helper;

import com.exl_si.common.Constants;
import com.exl_si.utils.MD5Util;

public class ServiceHelper {
	public static String encriptPassword(String username, String password) {
		return MD5Util.MD5EncodeUtf8(username+password+Constants.MD5_SALT).toLowerCase();
	}
}
