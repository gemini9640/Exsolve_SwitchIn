package com.exl_si.enums;

public final class MerchantEnums {
	public enum LOGIN_PIC {
		MERCHANT("MERCHANT","MERCHANT"),
		PIC("PIC","PIC");

	    private String code;
	    private String desc;

	    private LOGIN_PIC(String code, String desc) {
	        this.code = code;
	        this.desc = desc;
	    }

	    public String getCode() {
	        return code;
	    }

	    public String getDesc() {
	        return desc;
	    }
	}
	
	public enum STATUS {
		INIT(0,"init"),
		ACTIVE(1,"active"),
	    EXPIRE(2,"expire");
		
	    private int code;
	    private String desc;

	    private STATUS(int code, String desc) {
	        this.code = code;
	        this.desc = desc;
	    }

	    public int getCode() {
	        return code;
	    }

	    public String getDesc() {
	        return desc;
	    }
	}
}
