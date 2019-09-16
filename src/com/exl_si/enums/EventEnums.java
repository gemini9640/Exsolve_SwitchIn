package com.exl_si.enums;

public final class EventEnums {
	public enum STATUS {
		DRAFT(0,"draft"),
		PENDING(1,"pending"),
		ACTIVE(2,"active"),
	    EXPIRE(3,"expire");
		
		
		public static STATUS getStatusByCode(Integer code) {
			for (STATUS status : values()) {
				if(status.getCode() == code.intValue())
					return status;
			}
			return null;
		}
		
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
