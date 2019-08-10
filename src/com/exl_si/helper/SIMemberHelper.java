package com.exl_si.helper;

import com.exl_si.db.SIMember;

public class SIMemberHelper {
	public static SIMember assembleSIMember4ChangePassword(String username, String password) {
		SIMember member = new SIMember();
		member.setUsername(username);
		member.setPassword(password);
		return member;
	}
}
