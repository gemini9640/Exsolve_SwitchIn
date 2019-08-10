package com.exl_si.common;

public class Constants {
	public static final String CURRENT_USER = "currentUser";
    public static final String EMAIL = "email";
    public static final String MEMBER_SESSION = "MEMBER_SESSION";
    public static final String MERCHANT_SESSION = "MERCHANT_SESSION";
    public static final String MD5_SALT = "HELLO_GIRL";
    public static final String UPLOAD_PATH = "/Users/gemini9640/Documents/work/uploadFiles/";
    
    
    public interface Flag {
        int ENABLE = 0; // 普通用户
        int DISABLE = 1; // 管理员
    }
    
    public interface IdPrefix {
    	String SI_MEMBER = "SI_MB";
    	String SI_MERCHANT = "SI_MC";
    	String SI_MERCHANT_PIC = "SI_MC_PIC";
    	String EXL_AGENT = "EXL_AG";
    	String EXL_CLIENT = "EXL_CL";
    }
}
