package com.exl_si.service.helper;

import com.exl_si.db.SIMember;

public class SIMemberHelper extends ServiceHelper{
	public static SIMember assembleSIMember4ChangePassword(String username, String password) {
		SIMember member = new SIMember();
		member.setUsername(username);
		member.setPassword(password);
		return member;
	}
}
