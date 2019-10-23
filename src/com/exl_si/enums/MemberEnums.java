package com.exl_si.enums;

public final class MemberEnums {
	public enum TYPE {
		SI_MERCHANT("SI_MERCHANT","SI_Merchant"),
		SI_MEMBER("SI_MEMBER","SI_Member"),
		EXL_AGENT("EXL_AGENT","EXL_Agent"),
		EXL_CLIENT("EXL_CLIENT","EXL_Client");

	    private String code;
	    private String desc;

	    private TYPE(String code, String desc) {
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
	    EXPIRE(2,"expire"),
		DELETE(3,"delete");
		
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
	
	public enum VIP {
		NORMAL("NORMAL","Normal"),
		PREMIUM("PREMIUM","Premium");
		
		private String code;
	    private String desc;

	    private VIP(String code, String desc) {
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
	
	public enum FileType {
		PROFILE(0, "PROFILE");
		
		private int code;
	    private String desc;
	    
		private FileType(int code, String desc) {
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
