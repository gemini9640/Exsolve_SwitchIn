package com.exl_si.enums;

public enum TagLineEnums {
	KidsFamily("KF","Kids & Family"),
	HealthyBeauty("HB","Healthy & Beauty"),
	SportActivities("SA","Sport & Activities"),
	LeisurePleasure("LP","Leisure & Pleasure"),
	FoodBeverage("FB","Food & Beverage"),
	ComputerAccessories("CA","Computer & Accessories"),
	FashionClothes("FC","Fashion & Clothes"),
	Education("EC","Education"),
	Workshop("WS","Workshop"),
	Pets("PS","Pets");

	public static String getDescByCode(String code) {
		for(TagLineEnums type : values()) {
			if(type.getCode().equals(code))
				return type.getDesc();
		}
		return null;
	}
	
	private TagLineEnums(String code, String desc) {
		this.code = code;
	    this.desc = desc;
	}
	
	private String code;
	private String desc;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
