package com.exl_si.common;

public class Constants {
	public static final String CURRENT_USER = "currentUser";
    public static final String EMAIL = "email";
    public static final String CUSTOMER_SESSION = "CUSTOMER_SESSION";
    public static final String STAFF_SESSION = "STAFF_SESSION";
    
    public interface Flag {
        int ENABLE = 0; // 普通用户
        int DISABLE = 1; // 管理员
    }
    
    public interface IdPrefix {
    	String SI_MEMBER = "SI_MB";
    	String SI_AGENT = "SI_AG";
    	String SI_MERCHANT = "SI_MC";
    	String SI_MERCHANT_PIC = "SI_MC_PIC";
    	String EXL_AGENT = "EXL_AG";
    	String EXL_CLIENT = "EXL_CL";
    }
}
