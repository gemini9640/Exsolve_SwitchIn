package com.exl_si.helper;

import java.util.ArrayList;
import java.util.List;

import com.exl_si.db.EXLAgent;
import com.exl_si.db.EXLAgentFile;
import com.exl_si.db.vo.SubFile;

public class EXLAgentHelper {
	public static EXLAgent assembleEXLAgent4ChangePassword(String username, String password) {
		EXLAgent agent = new EXLAgent();
		agent.setUsername(username);
		agent.setPassword(password);
		return agent;
	}
	
	public static List<EXLAgentFile> assembleInitAgentFile(String agentId, String type, List<SubFile> files) {
		List<EXLAgentFile> agentFiles = new ArrayList<EXLAgentFile>();
		for (int i = 0; i < files.size(); i++) {
			EXLAgentFile agentFile = (EXLAgentFile) files.get(i);
			agentFile.setAgentId(agentId);
			agentFile.setType(type);
			agentFile.setIndx(-1);
			agentFiles.add(agentFile);
		}
		return agentFiles;
	}
	
	public static EXLAgentFile assembleEdittedAgentFile(EXLAgentFile file, List<SubFile> files) {
		EXLAgentFile agentFile = (EXLAgentFile) files.get(0);
		file.setNameNew(agentFile.getNameNew());
		file.setNameOld(agentFile.getNameOld());
		file.setPath(agentFile.getPath());
		return file;
	}
}
