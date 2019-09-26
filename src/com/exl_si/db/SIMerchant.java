package com.exl_si.db;

import java.util.Date;

public class SIMerchant {
    private String id;

    private String companyname;

    private String companyregno;

    private Integer totalstaff;

    private String companytype;

    private String industrytype;

    private String companyaddress;

    private Date expireddatessm;

    private String username;

    private String password;

    private String usertitle;

    private String realname;

    private Date dob;

    private String companylogo;

    private String credentialno;

    private String credentialtype;

    private String email;

    private String phone;

    private String officephone;

    private String facebook;

    private String googleplus;

    private String companydiscription;

    private Date createtime;

    private Date lastlogintime;

    private Date lastupdatetime;

    private String lastloginpictype;

    private String lastloginpicid;

    private Integer logintimes;

    private Integer status;
    
    private String rejectReason;

    public SIMerchant(String id, String companyname, String companyregno, Integer totalstaff, String companytype, String industrytype, String companyaddress, Date expireddatessm, String username, String password, String usertitle, String realname, Date dob, String companylogo, String credentialno, String credentialtype, String email, String phone, String officephone, String facebook, String googleplus, String companydiscription, Date createtime, Date lastlogintime, Date lastupdatetime, String lastloginpictype, String lastloginpicid, Integer logintimes, Integer status, String rejectReason) {
        this.id = id;
        this.companyname = companyname;
        this.companyregno = companyregno;
        this.totalstaff = totalstaff;
        this.companytype = companytype;
        this.industrytype = industrytype;
        this.companyaddress = companyaddress;
        this.expireddatessm = expireddatessm;
        this.username = username;
        this.password = password;
        this.usertitle = usertitle;
        this.realname = realname;
        this.dob = dob;
        this.companylogo = companylogo;
        this.credentialno = credentialno;
        this.credentialtype = credentialtype;
        this.email = email;
        this.phone = phone;
        this.officephone = officephone;
        this.facebook = facebook;
        this.googleplus = googleplus;
        this.companydiscription = companydiscription;
        this.createtime = createtime;
        this.lastlogintime = lastlogintime;
        this.lastupdatetime = lastupdatetime;
        this.lastloginpictype = lastloginpictype;
        this.lastloginpicid = lastloginpicid;
        this.logintimes = logintimes;
        this.status = status;
        this.rejectReason = rejectReason;
    }

    public SIMerchant() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname == null ? null : companyname.trim();
    }

    public String getCompanyregno() {
        return companyregno;
    }

    public void setCompanyregno(String companyregno) {
        this.companyregno = companyregno == null ? null : companyregno.trim();
    }

    public Integer getTotalstaff() {
        return totalstaff;
    }

    public void setTotalstaff(Integer totalstaff) {
        this.totalstaff = totalstaff;
    }

    public String getCompanytype() {
        return companytype;
    }

    public void setCompanytype(String companytype) {
        this.companytype = companytype == null ? null : companytype.trim();
    }

    public String getIndustrytype() {
        return industrytype;
    }

    public void setIndustrytype(String industrytype) {
        this.industrytype = industrytype == null ? null : industrytype.trim();
    }

    public String getCompanyaddress() {
        return companyaddress;
    }

    public void setCompanyaddress(String companyaddress) {
        this.companyaddress = companyaddress == null ? null : companyaddress.trim();
    }

    public Date getExpireddatessm() {
        return expireddatessm;
    }

    public void setExpireddatessm(Date expireddatessm) {
        this.expireddatessm = expireddatessm;
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

    public String getUsertitle() {
        return usertitle;
    }

    public void setUsertitle(String usertitle) {
        this.usertitle = usertitle == null ? null : usertitle.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getCompanylogo() {
        return companylogo;
    }

    public void setCompanylogo(String companylogo) {
        this.companylogo = companylogo == null ? null : companylogo.trim();
    }

    public String getCredentialno() {
        return credentialno;
    }

    public void setCredentialno(String credentialno) {
        this.credentialno = credentialno == null ? null : credentialno.trim();
    }

    public String getCredentialtype() {
        return credentialtype;
    }

    public void setCredetialtype(String credentialtype) {
        this.credentialtype = credentialtype == null ? null : credentialtype.trim();
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

    public String getOfficephone() {
        return officephone;
    }

    public void setOfficephone(String officephone) {
        this.officephone = officephone == null ? null : officephone.trim();
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

    public String getCompanydiscription() {
        return companydiscription;
    }

    public void setCompanydiscription(String companydiscription) {
        this.companydiscription = companydiscription == null ? null : companydiscription.trim();
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

    public String getLastloginpictype() {
        return lastloginpictype;
    }

    public void setLastloginpictype(String lastloginpictype) {
        this.lastloginpictype = lastloginpictype == null ? null : lastloginpictype.trim();
    }

    public String getLastloginpicid() {
        return lastloginpicid;
    }

    public void setLastloginpicid(String lastloginpicid) {
        this.lastloginpicid = lastloginpicid == null ? null : lastloginpicid.trim();
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
    
    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason == null ? null : rejectReason.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", companyname=").append(companyname);
        sb.append(", companyregno=").append(companyregno);
        sb.append(", totalstaff=").append(totalstaff);
        sb.append(", companytype=").append(companytype);
        sb.append(", industrytype=").append(industrytype);
        sb.append(", companyaddress=").append(companyaddress);
        sb.append(", expireddatessm=").append(expireddatessm);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", usertitle=").append(usertitle);
        sb.append(", realname=").append(realname);
        sb.append(", dob=").append(dob);
        sb.append(", companylogo=").append(companylogo);
        sb.append(", credentialno=").append(credentialno);
        sb.append(", credentialtype=").append(credentialtype);
        sb.append(", email=").append(email);
        sb.append(", phone=").append(phone);
        sb.append(", officephone=").append(officephone);
        sb.append(", facebook=").append(facebook);
        sb.append(", googleplus=").append(googleplus);
        sb.append(", companydiscription=").append(companydiscription);
        sb.append(", createtime=").append(createtime);
        sb.append(", lastlogintime=").append(lastlogintime);
        sb.append(", lastupdatetime=").append(lastupdatetime);
        sb.append(", lastloginpictype=").append(lastloginpictype);
        sb.append(", lastloginpicid=").append(lastloginpicid);
        sb.append(", logintimes=").append(logintimes);
        sb.append(", status=").append(status);
        sb.append(", rejectReason=").append(rejectReason);
        sb.append("]");
        return sb.toString();
    }
}