package com.csc.BankingApp.ValueObjects;

public class AccountDetailsVO {
	// no-arg constructor
	public AccountDetailsVO(){}
	
	// private attributes
	private String acc_no;
	private String acc_type;
	private double acc_curr_bal;
	private String acc_created_dt;
	private String acc_last_updated;
	
	// getters and setters
	public String getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(String acc_no) {
		this.acc_no = acc_no;
	}
	public String getAcc_type() {
		return acc_type;
	}
	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}
	public double getAcc_curr_bal() {
		return acc_curr_bal;
	}
	public void setAcc_curr_bal(double acc_curr_bal) {
		this.acc_curr_bal = acc_curr_bal;
	}
	public String getAcc_created_dt() {
		return acc_created_dt;
	}
	public void setAcc_created_dt(String acc_created_dt) {
		this.acc_created_dt = acc_created_dt;
	}
	public String getAcc_last_updated() {
		return acc_last_updated;
	}
	public void setAcc_last_updated(String acc_last_updated) {
		this.acc_last_updated = acc_last_updated;
	}
}
