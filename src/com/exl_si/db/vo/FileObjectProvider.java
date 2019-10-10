package com.exl_si.db.vo;

import com.exl_si.db.VoucherPicture;
import com.exl_si.db.EventPicture;
import com.exl_si.db.SIMerchantDOC;
import com.exl_si.db.SIMemberFile;
import com.exl_si.db.EXLAgentFile;
import com.exl_si.db.EXLClientFile;

public class FileObjectProvider {
	public static SubFile newFileObject(FileObjectEnums obj) throws InstantiationException, IllegalAccessException {
		return (SubFile) obj.getCls().newInstance();
	}
	
	public enum FileObjectEnums {
		VOUCHER_PICTURE(VoucherPicture.class),
		EVENT_PICTURE(EventPicture.class),
		SIMERCHANT_DOC(SIMerchantDOC.class),
		SIMEMBER_FILE(SIMemberFile.class),
		EXLAGENT_FILE(EXLAgentFile.class),
		EXLClient_FILE(EXLClientFile.class);
		
	    private Class<?> cls;

	    private FileObjectEnums(Class<?> cls) {
	        this.cls = cls;
	    }

	    private Class<?> getCls() {
	        return cls;
	    }
	}
}
