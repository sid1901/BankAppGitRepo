package com.csc.BankingApp.Dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.csc.BankingApp.ValueObjects.AccountDetailsVO;
import com.csc.BankingApp.ValueObjects.LoginVO;

public class BankServiceDao {
	private JdbcTemplate jdbcTemplate;  
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	this.jdbcTemplate = jdbcTemplate;  
	}  
	  

	 public String Txn(AccountDetailsVO accVO){
		return null;  
		  
	 }
}
