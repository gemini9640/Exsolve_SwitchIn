package com.exl_si.enums;

public enum ResponseCode {
	SUCCESS(0,"SUCCESS"),
	ERROR(1,"error code[1]"),
    ERROR_SERVER(2,"service error, try again later"),
    ERROR_PARAM(3,"input parameter error, please check the input"),
    ILLIGAL_ARGUMENT(4,"ILLIGAL_ARGUMENT"),
    NEED_LOGIN(10,"NEED_LOGIN");

    private int code;
    private String desc;

    private ResponseCode(int code, String desc) {
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
