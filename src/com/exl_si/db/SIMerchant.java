package com.exl_si.db;

import java.util.Date;

public class SIMerchant {
    private String username;

    private String password;

    private String primarypic;

    private String secondarypic;

    private String phonepic;

    private String companyregno;

    private String companylogo;

    private String companyname;

    private String companyssmimage;

    private Date expireddatessm;

    private String business;

    private String email;

    private String phone;

    private String location;

    private String refenence;

    private String ownername;

    private String ownerphone;

    private Date createtime;

    private Date lastlogintime;

    private Date updatetime;

    private Integer logintimes;

    private Integer status;

    private String remark;

    public SIMerchant(String username, String password, String primarypic, String secondarypic, String phonepic, String companyregno, String companylogo, String companyname, String companyssmimage, Date expireddatessm, String business, String email, String phone, String location, String refenence, String ownername, String ownerphone, Date createtime, Date lastlogintime, Date updatetime, Integer logintimes, Integer status, String remark) {
        this.username = username;
        this.password = password;
        this.primarypic = primarypic;
        this.secondarypic = secondarypic;
        this.phonepic = phonepic;
        this.companyregno = companyregno;
        this.companylogo = companylogo;
        this.companyname = companyname;
        this.companyssmimage = companyssmimage;
        this.expireddatessm = expireddatessm;
        this.business = business;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.refenence = refenence;
        this.ownername = ownername;
        this.ownerphone = ownerphone;
        this.createtime = createtime;
        this.lastlogintime = lastlogintime;
        this.updatetime = updatetime;
        this.logintimes = logintimes;
        this.status = status;
        this.remark = remark;
    }

    public SIMerchant() {
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

    public String getPrimarypic() {
        return primarypic;
    }

    public void setPrimarypic(String primarypic) {
        this.primarypic = primarypic == null ? null : primarypic.trim();
    }

    public String getSecondarypic() {
        return secondarypic;
    }

    public void setSecondarypic(String secondarypic) {
        this.secondarypic = secondarypic == null ? null : secondarypic.trim();
    }

    public String getPhonepic() {
        return phonepic;
    }

    public void setPhonepic(String phonepic) {
        this.phonepic = phonepic == null ? null : phonepic.trim();
    }

    public String getCompanyregno() {
        return companyregno;
    }

    public void setCompanyregno(String companyregno) {
        this.companyregno = companyregno == null ? null : companyregno.trim();
    }

    public String getCompanylogo() {
        return companylogo;
    }

    public void setCompanylogo(String companylogo) {
        this.companylogo = companylogo == null ? null : companylogo.trim();
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname == null ? null : companyname.trim();
    }

    public String getCompanyssmimage() {
        return companyssmimage;
    }

    public void setCompanyssmimage(String companyssmimage) {
        this.companyssmimage = companyssmimage == null ? null : companyssmimage.trim();
    }

    public Date getExpireddatessm() {
        return expireddatessm;
    }

    public void setExpireddatessm(Date expireddatessm) {
        this.expireddatessm = expireddatessm;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business == null ? null : business.trim();
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getRefenence() {
        return refenence;
    }

    public void setRefenence(String refenence) {
        this.refenence = refenence == null ? null : refenence.trim();
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername == null ? null : ownername.trim();
    }

    public String getOwnerphone() {
        return ownerphone;
    }

    public void setOwnerphone(String ownerphone) {
        this.ownerphone = ownerphone == null ? null : ownerphone.trim();
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
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", primarypic=").append(primarypic);
        sb.append(", secondarypic=").append(secondarypic);
        sb.append(", phonepic=").append(phonepic);
        sb.append(", companyregno=").append(companyregno);
        sb.append(", companylogo=").append(companylogo);
        sb.append(", companyname=").append(companyname);
        sb.append(", companyssmimage=").append(companyssmimage);
        sb.append(", expireddatessm=").append(expireddatessm);
        sb.append(", business=").append(business);
        sb.append(", email=").append(email);
        sb.append(", phone=").append(phone);
        sb.append(", location=").append(location);
        sb.append(", refenence=").append(refenence);
        sb.append(", ownername=").append(ownername);
        sb.append(", ownerphone=").append(ownerphone);
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