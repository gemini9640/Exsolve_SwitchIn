package com.exl_si.controller.vo;

import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

import com.exl_si.db.SIMerchant;

public class SIMerchantReturnMsg extends ReturnMsg{
	
//	public static void main(String[] a) {
//		SIMerchant merchant = new SIMerchant();
//		merchant.setPhone("6014647474722");
//		SIMerchantReturnMsg s = new SIMerchantReturnMsg(merchant);
//		s.validatedForNew();
//		System.out.println(s.getPhone());
//		
//	}
	private SIMerchant merchant;
	public boolean validatedForNew() {
		boolean valid_companyname = true;
		boolean valid_username = true;
		boolean valid_password = true;
		boolean valid_email = true;
		boolean valid_phone = true;
		
		if(StringUtils.isEmpty(merchant.getCompanyname())) {
			this.setCompanyname("Please enter company name");
			valid_companyname = false;
		} 
		
		if(StringUtils.isEmpty(merchant.getUsername())) {
			this.setUsername("Please enter username");
			valid_username = false;
		}
		String pattern_pass = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[A-Za-z0-9]{6,20}$";
		if(!Pattern.matches(pattern_pass, merchant.getPassword())) {
			this.setPassword("Password between 6 and 20 characters; must contain at least one lowercase letter, one uppercase letter, one numeric digit");
			valid_password = false;
		}
		
		String pattern_email = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		if(!StringUtils.isEmpty(merchant.getEmail()) && !Pattern.matches(pattern_email, merchant.getEmail())) {
			this.setEmail("Please enter an valid email");
			valid_email = false;
		}
		
		String pattern_phone = "^(60)\\d{9,11}$";
		if(!StringUtils.isEmpty(merchant.getPhone()) && !Pattern.matches(pattern_phone, merchant.getPhone())) {
			this.setPhone("Please enter an valid phone number");
			valid_phone = false;
		}
		return valid_companyname && valid_username && valid_password && valid_email && valid_phone;
	}
	
	public boolean validatedForEdit() {
		boolean valid_companyname = true;
		boolean valid_username = true;
		boolean valid_email = true;
		boolean valid_phone = true;
		
		if(StringUtils.isEmpty(merchant.getCompanyname())) {
			this.setCompanyname("Please enter company name");
			valid_companyname = false;
		} 
		
		if(StringUtils.isEmpty(merchant.getUsername())) {
			this.setUsername("Please enter username");
			valid_username = false;
		}
		
		String pattern_email = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		if(!StringUtils.isEmpty(merchant.getEmail()) && !Pattern.matches(pattern_email, merchant.getEmail())) {
			this.setEmail("Please enter an valid email");
			valid_email = false;
		}
		
		String pattern_phone = "^(60)\\d{9,11}$";
		if(!StringUtils.isEmpty(merchant.getPhone()) && !Pattern.matches(pattern_phone, merchant.getPhone())) {
			this.setPhone("Please enter an valid phone number");
			valid_phone = false;
		}
		return valid_companyname && valid_username  && valid_email && valid_phone;
	}
	
	private String companyname;
    private String companyregno;
    private String companytype;
    private String industrytype;
    private String companyaddress;
    private String username;
    private String password;
    private String usertitle;
    private String realname;
    private String companylogo;
    private String credentialno;
    private String email;
    private String phone;
    private String officephone;
    private String facebook;
    private String googleplus;
    private String companydiscription;

	public SIMerchantReturnMsg() {
	}
	
	public SIMerchantReturnMsg(SIMerchant merchant) {
		this.merchant = merchant;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getCompanyregno() {
		return companyregno;
	}

	public void setCompanyregno(String companyregno) {
		this.companyregno = companyregno;
	}

	public String getCompanytype() {
		return companytype;
	}

	public void setCompanytype(String companytype) {
		this.companytype = companytype;
	}

	public String getIndustrytype() {
		return industrytype;
	}

	public void setIndustrytype(String industrytype) {
		this.industrytype = industrytype;
	}

	public String getCompanyaddress() {
		return companyaddress;
	}

	public void setCompanyaddress(String companyaddress) {
		this.companyaddress = companyaddress;
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

	public String getUsertitle() {
		return usertitle;
	}

	public void setUsertitle(String usertitle) {
		this.usertitle = usertitle;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getCompanylogo() {
		return companylogo;
	}

	public void setCompanylogo(String companylogo) {
		this.companylogo = companylogo;
	}

	public String getCredentialno() {
		return credentialno;
	}

	public void setCredentialno(String credentialno) {
		this.credentialno = credentialno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOfficephone() {
		return officephone;
	}

	public void setOfficephone(String officephone) {
		this.officephone = officephone;
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

	public String getCompanydiscription() {
		return companydiscription;
	}

	public void setCompanydiscription(String companydiscription) {
		this.companydiscription = companydiscription;
	}

}
