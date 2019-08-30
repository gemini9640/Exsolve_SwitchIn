package com.exl_si.helper;

import java.util.ArrayList;
import java.util.List;

import com.exl_si.db.EXLAgentFile;
import com.exl_si.db.EXLClient;
import com.exl_si.db.EXLClientFile;
import com.exl_si.db.vo.SubFile;

public class EXLClientHelper {
	public static EXLClient assembleSIMember4ChangePassword(String username, String password) {
		EXLClient client = new EXLClient();
		client.setUsername(username);
		client.setPassword(password);
		return client;
	}
	
	public static List<EXLClientFile> assembleInitClientFile(String clientId, String type, List<SubFile> files) {
		List<EXLClientFile> clientFiles = new ArrayList<EXLClientFile>();
		for (int i = 0; i < files.size(); i++) {
			EXLClientFile clientFile = (EXLClientFile) files.get(i);
			clientFile.setClientId(clientId);
			clientFile.setType(type);
			clientFile.setIndx(-1);
			clientFiles.add(clientFile);
		}
		return clientFiles;
	}
	
	public static EXLClientFile assembleEdittedClientFile(EXLClientFile file, List<SubFile> files) {
		EXLClientFile clientFile = (EXLClientFile) files.get(0);
		file.setNameNew(clientFile.getNameNew());
		file.setNameOld(clientFile.getNameOld());
		file.setPath(clientFile.getPath());
		return file;
	}
}
