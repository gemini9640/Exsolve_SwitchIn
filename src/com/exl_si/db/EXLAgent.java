package com.exl_si.db;

import java.util.Date;

public class EXLAgent {
    private String id;

    private String username;

    private String password;

    private String realname;

    private String sex;

    private Date dob;

    private String position;

    private String qualification;

    private String policyno;

    private String agentidno;

    private String phone;

    private String email;

    private String facebook;

    private String googleplus;

    private String profilepicture;

    private Date createtime;

    private Date lastlogintime;

    private Date lastupdatetime;

    private Integer logintimes;

    private Integer status;

    private String remark;

    public EXLAgent(String id, String username, String password, String realname, String sex, Date dob, String position, String qualification, String policyno, String agentidno, String phone, String email, String facebook, String googleplus, String profilepicture, Date createtime, Date lastlogintime, Date lastupdatetime, Integer logintimes, Integer status, String remark) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.sex = sex;
        this.dob = dob;
        this.position = position;
        this.qualification = qualification;
        this.policyno = policyno;
        this.agentidno = agentidno;
        this.phone = phone;
        this.email = email;
        this.facebook = facebook;
        this.googleplus = googleplus;
        this.profilepicture = profilepicture;
        this.createtime = createtime;
        this.lastlogintime = lastlogintime;
        this.lastupdatetime = lastupdatetime;
        this.logintimes = logintimes;
        this.status = status;
        this.remark = remark;
    }

    public EXLAgent() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification == null ? null : qualification.trim();
    }

    public String getPolicyno() {
        return policyno;
    }

    public void setPolicyno(String policyno) {
        this.policyno = policyno == null ? null : policyno.trim();
    }

    public String getAgentidno() {
        return agentidno;
    }

    public void setAgentidno(String agentidno) {
        this.agentidno = agentidno == null ? null : agentidno.trim();
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
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", realname=").append(realname);
        sb.append(", sex=").append(sex);
        sb.append(", dob=").append(dob);
        sb.append(", position=").append(position);
        sb.append(", qualification=").append(qualification);
        sb.append(", policyno=").append(policyno);
        sb.append(", agentidno=").append(agentidno);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", facebook=").append(facebook);
        sb.append(", googleplus=").append(googleplus);
        sb.append(", profilepicture=").append(profilepicture);
        sb.append(", createtime=").append(createtime);
        sb.append(", lastlogintime=").append(lastlogintime);
        sb.append(", lastupdatetime=").append(lastupdatetime);
        sb.append(", logintimes=").append(logintimes);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}