package com.exl_si.helper;

import java.util.ArrayList;
import java.util.List;

import com.exl_si.common.Constants;
import com.exl_si.db.SIMerchant;
import com.exl_si.db.SIMerchantDOC;
import com.exl_si.db.vo.SubFile;
import com.exl_si.utils.MD5Util;

public class SIMerchantHelper {
	public static SIMerchant assembleSIMerchant4ChangePassword(String username, String password) {
		SIMerchant merchant = new SIMerchant();
		merchant.setPassword(getPassword(username, password));
		return merchant;
	}
	
	public static String getPassword(String username, String password) {
		return MD5Util.MD5EncodeUtf8(username+password+Constants.MD5_SALT).toLowerCase();
	}
	
	public static List<SIMerchantDOC> assembleInitMerchantDOC(String merchantId, String type, List<SubFile> files) {
		List<SIMerchantDOC> merchantDocs = new ArrayList<SIMerchantDOC>();
		for (int i = 0; i < files.size(); i++) {
			SIMerchantDOC merchantDoc = (SIMerchantDOC) files.get(i);
			merchantDoc.setMerchantId(merchantId);
			merchantDoc.setType(type);
			merchantDoc.setIndx(-1);
			merchantDocs.add(merchantDoc);
		}
		return merchantDocs;
	}
	
	public static SIMerchantDOC assembleEdittedMerchantDOC(SIMerchantDOC file, List<SubFile> files) {
		SIMerchantDOC merchantDoc = (SIMerchantDOC) files.get(0);
		file.setNameNew(merchantDoc.getNameNew());
		file.setNameOld(merchantDoc.getNameOld());
		file.setPath(merchantDoc.getPath());
		return file;
	}
}
