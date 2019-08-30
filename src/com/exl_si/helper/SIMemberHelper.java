package com.exl_si.helper;

import java.util.ArrayList;
import java.util.List;

import com.exl_si.db.SIMember;
import com.exl_si.db.SIMemberFile;
import com.exl_si.db.vo.SIMemberWithAssociated;
import com.exl_si.db.vo.SubFile;

public class SIMemberHelper {
	public static SIMember assembleSIMember4ChangePassword(String username, String password) {
		SIMember member = new SIMember();
		member.setUsername(username);
		member.setPassword(password);
		return member;
	}

	public static List<SIMemberFile> assembleInitMemberFile(String memberId, String type, List<SubFile> files) {
		List<SIMemberFile> memberFiles = new ArrayList<SIMemberFile>();
		for (int i = 0; i < files.size(); i++) {
			SIMemberFile memberFile = (SIMemberFile) files.get(i);
			memberFile.setMemberId(memberId);
			memberFile.setType(type);
			memberFile.setIndx(-1);
			memberFiles.add(memberFile);
		}
		return memberFiles;
	}
	
	public static SIMemberFile assembleEdittedMemberFile(SIMemberFile file, List<SubFile> files) {
		SIMemberFile memberFile = (SIMemberFile) files.get(0);
		file.setNameNew(memberFile.getNameNew());
		file.setNameOld(memberFile.getNameOld());
		file.setPath(memberFile.getPath());
		return file;
	}

	public static SIMemberWithAssociated assembleSIMemberWithAssociated(SIMember member, SIMemberFile file) {
		return new SIMemberWithAssociated(member, file);
	}
	
}
