package com.exl_si.helper;

import com.exl_si.db.EXLAgent;

public class EXLAgentHelper {
	public static EXLAgent assembleSIMember4ChangePassword(String username, String password) {
		EXLAgent agent = new EXLAgent();
		agent.setUsername(username);
		agent.setPassword(password);
		return agent;
	}
}
