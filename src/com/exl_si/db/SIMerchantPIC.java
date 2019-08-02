package com.exl_si.db;

import java.util.Date;

public class SIMerchantPIC {
    private String username;

    private String password;

    private String merchantid;

    private String title;

    private String realname;

    private String email;

    private String phone;

    private String discription;

    private Date createtime;

    private Date lastlogintime;

    private Date lastupdatetime;

    private Integer logintimes;

    private Integer status;

    public SIMerchantPIC(String username, String password, String merchantid, String title, String realname, String email, String phone, String discription, Date createtime, Date lastlogintime, Date lastupdatetime, Integer logintimes, Integer status) {
        this.username = username;
        this.password = password;
        this.merchantid = merchantid;
        this.title = title;
        this.realname = realname;
        this.email = email;
        this.phone = phone;
        this.discription = discription;
        this.createtime = createtime;
        this.lastlogintime = lastlogintime;
        this.lastupdatetime = lastupdatetime;
        this.logintimes = logintimes;
        this.status = status;
    }

    public SIMerchantPIC() {
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

    public String getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid == null ? null : merchantid.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription == null ? null : discription.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", merchantid=").append(merchantid);
        sb.append(", title=").append(title);
        sb.append(", realname=").append(realname);
        sb.append(", email=").append(email);
        sb.append(", phone=").append(phone);
        sb.append(", discription=").append(discription);
        sb.append(", createtime=").append(createtime);
        sb.append(", lastlogintime=").append(lastlogintime);
        sb.append(", lastupdatetime=").append(lastupdatetime);
        sb.append(", logintimes=").append(logintimes);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}