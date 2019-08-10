package com.exl_si.controller.vo;


public class EXLAgentReturnMsg extends ReturnMsg{
	
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

    private String username;

    private String password;

    private String realname;

    private String sex;

    private String dob;
    
    private String policyNo;
    
    private String agentIdNo;

    private String position;

    private String qualification;

    private String phone;

    private String email;

    private String facebook;

    private String googleplus;

    private String profilepicture;

    private String status;

	public EXLAgentReturnMsg() {
	}

	public EXLAgentReturnMsg(String errormsg) {
		super(errormsg);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
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

	public String getProfilepicture() {
		return profilepicture;
	}

	public void setProfilepicture(String profilepicture) {
		this.profilepicture = profilepicture;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getAgentIdNo() {
		return agentIdNo;
	}

	public void setAgentIdNo(String agentIdNo) {
		this.agentIdNo = agentIdNo;
	}
	
	
    
}
