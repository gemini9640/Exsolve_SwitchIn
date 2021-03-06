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
		PENDING(0,"pending"),
		ACTIVE(1,"active"),
	    REJECT(2,"reject"),
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
	
	public enum FileType {
		PROFILE(0, "PROFILE"),
		DCUMENT(1, "DCUMENT"),
		BANNER(2, "BANNER");
		
		
		public static FileType getEnumByCode(int code) {
			for(FileType enumm : values()) {
				if(enumm.getCode() == code)
					return enumm;
			}
			return null;
		}
		
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
