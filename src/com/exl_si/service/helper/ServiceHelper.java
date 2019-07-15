package com.exl_si.service.helper;

import com.exl_si.utils.MD5Util;

public class ServiceHelper {
	public static String encriptPassword(String password) {
		return MD5Util.MD5EncodeUtf8(password);
	}
}
