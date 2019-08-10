package com.exl_si.controller.vo;

public class EventReturnMsg extends ReturnMsg{
	/**
	 * todo
	 */
	public boolean validatedForNew() {
		return false;
	}
	
	/**
	 * todo
	 */
	public boolean validatedForEdit() {
		return false;
	}
	
	private String id;
	
    private String eventname;

    private String merchantname;

    private String startdate;

    private String enddate;

    private String tagline;

    private String price;

    private String csphone;

    private String location;

    private String address;

    private String map;

    private String maxpax;

    private String maxpaxperregister;

    private String comment;

    private String description;

    private String reminder;

	public EventReturnMsg() {
	}

	public EventReturnMsg(String errormsg) {
		super(errormsg);
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public String getMerchantname() {
		return merchantname;
	}

	public void setMerchantname(String merchantname) {
		this.merchantname = merchantname;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCsphone() {
		return csphone;
	}

	public void setCsphone(String csphone) {
		this.csphone = csphone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public String getMaxpax() {
		return maxpax;
	}

	public void setMaxpax(String maxpax) {
		this.maxpax = maxpax;
	}

	public String getMaxpaxperregister() {
		return maxpaxperregister;
	}

	public void setMaxpaxperregister(String maxpaxperregister) {
		this.maxpaxperregister = maxpaxperregister;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReminder() {
		return reminder;
	}

	public void setReminder(String reminder) {
		this.reminder = reminder;
	}
    
	
}
