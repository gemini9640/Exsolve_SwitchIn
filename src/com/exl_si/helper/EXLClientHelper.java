package com.exl_si.helper;

import com.exl_si.db.EXLClient;

public class EXLClientHelper {
	public static EXLClient assembleSIMember4ChangePassword(String username, String password) {
		EXLClient client = new EXLClient();
		client.setUsername(username);
		client.setPassword(password);
		return client;
	}
}
