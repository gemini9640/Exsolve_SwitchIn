package com.exl_si.db;

import java.util.Date;

public class SIMember {
    private String id;
    
    private String username;

    private String password;

    private String realname;

    private String sex;

    private Integer age;

    private Date dob;

    private String occupation;

    private String interestecategory;

    private String phone;

    private String email;

    private String facebook;

    private String googleplus;

    private String usertype;

    private String agentid;

    private String profilepicture;

    private Date createtime;

    private Date lastlogintime;

    private Date lastupdatetime;

    private Date updatetime;

    private Integer logintimes;

    private Integer status;
    
    private String memberType;
    
    private Integer isSubscribe;
    
    private String remark;

    public SIMember(String id, String username, String password, String realname, String sex, Integer age, Date dob, String occupation, String interestecategory, String phone, String email, String facebook, String googleplus, String usertype, String agentid, String profilepicture, Date createtime, Date lastlogintime, Date lastupdatetime, Date updatetime, Integer logintimes, Integer status, String memberType, Integer isSubscribe, String remark) {
    	this.id = id;
    	this.username = username;
        this.password = password;
        this.realname = realname;
        this.sex = sex;
        this.age = age;
        this.dob = dob;
        this.occupation = occupation;
        this.interestecategory = interestecategory;
        this.phone = phone;
        this.email = email;
        this.facebook = facebook;
        this.googleplus = googleplus;
        this.usertype = usertype;
        this.agentid = agentid;
        this.profilepicture = profilepicture;
        this.createtime = createtime;
        this.lastlogintime = lastlogintime;
        this.lastupdatetime = lastupdatetime;
        this.updatetime = updatetime;
        this.logintimes = logintimes;
        this.status = status;
        this.memberType = memberType;
        this.isSubscribe = isSubscribe;
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public SIMember() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation == null ? null : occupation.trim();
    }

    public String getInterestecategory() {
        return interestecategory;
    }

    public void setInterestecategory(String interestecategory) {
        this.interestecategory = interestecategory == null ? null : interestecategory.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook == null ? null : facebook.trim();
    }

    public String getGoogleplus() {
        return googleplus;
    }

    public void setGoogleplus(String googleplus) {
        this.googleplus = googleplus == null ? null : googleplus.trim();
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype == null ? null : usertype.trim();
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid == null ? null : agentid.trim();
    }

    public String getProfilepicture() {
        return profilepicture;
    }

    public void setProfilepicture(String profilepicture) {
        this.profilepicture = profilepicture == null ? null : profilepicture.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public Date getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(Date lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getLogintimes() {
        return logintimes;
    }

    public void setLogintimes(Integer logintimes) {
        this.logintimes = logintimes;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType == null ? null : memberType.trim();
    }

    public Integer getIsSubscribe() {
        return isSubscribe;
    }

    public void setIsSubscribe(Integer isSubscribe) {
        this.isSubscribe = isSubscribe;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", username=").append(username);
        sb.append(", id=").append(id);
        sb.append(", password=").append(password);
        sb.append(", realname=").append(realname);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", dob=").append(dob);
        sb.append(", occupation=").append(occupation);
        sb.append(", interestecategory=").append(interestecategory);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", facebook=").append(facebook);
        sb.append(", googleplus=").append(googleplus);
        sb.append(", usertype=").append(usertype);
        sb.append(", agentid=").append(agentid);
        sb.append(", profilepicture=").append(profilepicture);
        sb.append(", createtime=").append(createtime);
        sb.append(", lastlogintime=").append(lastlogintime);
        sb.append(", lastupdatetime=").append(lastupdatetime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", logintimes=").append(logintimes);
        sb.append(", status=").append(status);
        sb.append(", memberType=").append(memberType);
        sb.append(", isSubscribe=").append(isSubscribe);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}