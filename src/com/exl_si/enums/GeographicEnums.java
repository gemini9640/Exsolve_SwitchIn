package com.exl_si.enums;

public enum GeographicEnums {
	KualaLumpur("KL","Kuala Lumpur"),
	ShahAlam("SA","Shah Alam"),
	Putrajaya("PTJ","Putra jaya"),
	PetalingJaya("PLJ","Petaling Jaya"),
	Puchong("PC","Puchong"),
	Ampang("AP","Ampang"),
	SubangJaya("SBJ","Subang Jaya"),
	Cyberjaya("CJ","Cyber jaya"),
	SeriKembangan("SKB","Seri Kembangan");
	
	public static String getDescByCode(String code) {
		for(GeographicEnums type : values()) {
			if(type.getCode().equals(code))
				return type.getDesc();
		}
		return null;
	}
	
	private GeographicEnums(String code, String desc) {
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
