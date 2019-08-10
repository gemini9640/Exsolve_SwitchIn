package com.exl_si.db.vo;

import com.exl_si.db.EventPicture;
import com.exl_si.db.SIMerchantDOC;

public class FileObjectProvider {
	public static SubFile newFileObject(FileObjectEnums obj) throws InstantiationException, IllegalAccessException {
		return (SubFile) obj.getCls().newInstance();
	}
	
	public enum FileObjectEnums {
		EVENT_PICTURE(EventPicture.class),
		SIMERCHANT_DOC(SIMerchantDOC.class);
		
	    private Class<?> cls;

	    private FileObjectEnums(Class<?> cls) {
	        this.cls = cls;
	    }

	    private Class<?> getCls() {
	        return cls;
	    }
	}
}
