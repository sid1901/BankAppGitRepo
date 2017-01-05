package com.csc.BankingApp.Dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.csc.BankingApp.ValueObjects.AccountDetailsVO;
import com.csc.BankingApp.ValueObjects.LoginVO;

public class AccountDetailsDao {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}
	
	
	
	public int saveAccDetails(AccountDetailsVO o , String uid){  
		//String query="insert into account_details values('" +o.getUid() +"','" +o.getUpwd()+ "')";  
	    int results=0;
	    //results=jdbcTemplate.update(query);
	     return results;  
	}
	
	
}
