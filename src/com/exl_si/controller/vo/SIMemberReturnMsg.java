package com.exl_si.controller.vo;

import java.util.Date;

public class SIMemberReturnMsg extends ReturnMsg{
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
	
	private String username;

    private String id;

    private String password;

    private String realname;

    private String sex;

    private String age;

    private String dob;

    private String occupation;

    private String interestecategory;

    private String phone;

    private String email;

    private String facebook;

    private String googleplus;

    private String usertype;

    private String agentid;

    private String profilepicture;

    private String createtime;

    private String lastlogintime;

    private String lastupdatetime;

    private String updatetime;

    private String logintimes;

    private String status;

	public SIMemberReturnMsg() {
	}

	public SIMemberReturnMsg(String errormsg) {
		super(errormsg);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getInterestecategory() {
		return interestecategory;
	}

	public void setInterestecategory(String interestecategory) {
		this.interestecategory = interestecategory;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getGoogleplus() {
		return googleplus;
	}

	public void setGoogleplus(String googleplus) {
		this.googleplus = googleplus;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getAgentid() {
		return agentid;
	}

	public void setAgentid(String agentid) {
		this.agentid = agentid;
	}

	public String getProfilepicture() {
		return profilepicture;
	}

	public void setProfilepicture(String profilepicture) {
		this.profilepicture = profilepicture;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getLastlogintime() {
		return lastlogintime;
	}

	public void setLastlogintime(String lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

	public String getLastupdatetime() {
		return lastupdatetime;
	}

	public void setLastupdatetime(String lastupdatetime) {
		this.lastupdatetime = lastupdatetime;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getLogintimes() {
		return logintimes;
	}

	public void setLogintimes(String logintimes) {
		this.logintimes = logintimes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
    
}
