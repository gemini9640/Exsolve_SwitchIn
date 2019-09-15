package com.exl_si.enums;

public final class EventEnums {
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
	
	public enum PictureType {
		BANNER(1, "BANNER"),
		QR(2, "QR");
		
		
		public static PictureType getEnumByCode(int code) {
			for(PictureType enumm : values()) {
				if(enumm.getCode() == code)
					return enumm;
			}
			return null;
		}
		
		private int code;
	    private String desc;
	    
		private PictureType(int code, String desc) {
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
