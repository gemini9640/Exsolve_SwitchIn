package com.exl_si.enums;

public final class StatusEnums {
	public enum Event {
		INIT(0,"init"),
		ACTIVE(1,"active"),
	    EXPIRE(2,"expire");

	    private int code;
	    private String desc;

	    private Event(int code, String desc) {
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
