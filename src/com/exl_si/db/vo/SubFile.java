package com.exl_si.db.vo;

public abstract class SubFile {
	public abstract void setId(String id);
	
	public abstract void setNameOld(String nameOld);
	
	public abstract void setNameNew(String nameNew);
	
	public abstract void setPath(String path);
	
	public abstract String getId();
	
	public abstract String getNameOld();
	
	public abstract String getNameNew();
	
	public abstract String getPath();
}
