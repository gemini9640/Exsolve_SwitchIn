package com.exl_si.db;

import java.util.Date;

public class SIMember {
    private Integer id;

    private String username;

    private String password;

    private String realname;

    private String sex;

    private Integer age;

    private Date dob;

    private String phone;

    private String email;

    private String occupation;

    private String interested;

    private String usertype;

    private String agentname;

    private String agentaccount;

    private Integer premier;

    private String profilepicture;

    private Date createtime;

    private Date lastlogintime;

    private Date updatetime;

    private Integer logintimes;

    private Integer status;

    private String remark;

    public SIMember(Integer id, String username, String password, String realname, String sex, Integer age, Date dob, String phone, String email, String occupation, String interested, String usertype, String agentname, String agentaccount, Integer premier, String profilepicture, Date createtime, Date lastlogintime, Date updatetime, Integer logintimes, Integer status, String remark) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.sex = sex;
        this.age = age;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.occupation = occupation;
        this.interested = interested;
        this.usertype = usertype;
        this.agentname = agentname;
        this.agentaccount = agentaccount;
        this.premier = premier;
        this.profilepicture = profilepicture;
        this.createtime = createtime;
        this.lastlogintime = lastlogintime;
        this.updatetime = updatetime;
        this.logintimes = logintimes;
        this.status = status;
        this.remark = remark;
    }

    public SIMember() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation == null ? null : occupation.trim();
    }

    public String getInterested() {
        return interested;
    }

    public void setInterested(String interested) {
        this.interested = interested == null ? null : interested.trim();
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype == null ? null : usertype.trim();
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname == null ? null : agentname.trim();
    }

    public String getAgentaccount() {
        return agentaccount;
    }

    public void setAgentaccount(String agentaccount) {
        this.agentaccount = agentaccount == null ? null : agentaccount.trim();
    }

    public Integer getPremier() {
        return premier;
    }

    public void setPremier(Integer premier) {
        this.premier = premier;
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
        sb.append(", age=").append(age);
        sb.append(", dob=").append(dob);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", occupation=").append(occupation);
        sb.append(", interested=").append(interested);
        sb.append(", usertype=").append(usertype);
        sb.append(", agentname=").append(agentname);
        sb.append(", agentaccount=").append(agentaccount);
        sb.append(", premier=").append(premier);
        sb.append(", profilepicture=").append(profilepicture);
        sb.append(", createtime=").append(createtime);
        sb.append(", lastlogintime=").append(lastlogintime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", logintimes=").append(logintimes);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}