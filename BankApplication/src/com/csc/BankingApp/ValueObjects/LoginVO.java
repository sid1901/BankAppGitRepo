package com.csc.BankingApp.ValueObjects;

public class LoginVO {

	// no-arg constructor
	public LoginVO() {
	}

	// private attributes
	private String uid;
 	private String upwd;
	private String cust_fnmae;
	private String cust_lname;
	private String cust_add_l1;
	private String cust_add_l2;
	private String cust_mobile;
	private String cust_email;
	private String cust_gender;
	private int cust_age;

	// getters and setters
	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getCust_fnmae() {
		return cust_fnmae;
	}

	public void setCust_fnmae(String cust_fnmae) {
		this.cust_fnmae = cust_fnmae;
	}

	public String getCust_lname() {
		return cust_lname;
	}

	public void setCust_lname(String cust_lname) {
		this.cust_lname = cust_lname;
	}

	public String getCust_add_l1() {
		return cust_add_l1;
	}

	public void setCust_add_l1(String cust_add_l1) {
		this.cust_add_l1 = cust_add_l1;
	}

	public String getCust_add_l2() {
		return cust_add_l2;
	}

	public void setCust_add_l2(String cust_add_l2) {
		this.cust_add_l2 = cust_add_l2;
	}

	public String getCust_mobile() {
		return cust_mobile;
	}

	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}

	public String getCust_gender() {
		return cust_gender;
	}

	public void setCust_gender(String cust_gender) {
		this.cust_gender = cust_gender;
	}

	public int getCust_age() {
		return cust_age;
	}

	public void setCust_age(int cust_age) {
		this.cust_age = cust_age;
	}

	public String getCust_email() {
		return cust_email;
	}

	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}

}
