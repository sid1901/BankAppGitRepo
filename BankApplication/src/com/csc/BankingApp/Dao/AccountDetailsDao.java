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
		String query="insert into account_details values('" +o.getAcc_no() +"','" +o.getAcc_type() +"','"
		+uid +"','0', curdate(), curdate())";
	    int results=0;
	    results=jdbcTemplate.update(query);
	     return results;  
	}

	public int findAccNo(String accNo) {
		int result=1;
		String sql = "SELECT COUNT(*) FROM ACCOUNT_DETAILS WHERE ACC_NO = '"+ accNo +"'";
		result = jdbcTemplate.queryForInt(sql);
		return result;
	}

	public int findAccType(String uid, String accType) {
		int result=-1;
		String sql = "SELECT COUNT(*) FROM ACCOUNT_DETAILS WHERE CUST_UID = '"+ uid +"' and ACC_TYPE='"+accType+"'";
		System.out.println(sql);
		result = jdbcTemplate.queryForInt(sql);
		return result;
	}

	public int findAccByUid(String uid) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT COUNT(*) FROM ACCOUNT_DETAILS WHERE CUST_UID = '"+ uid +"'";
		int result = jdbcTemplate.queryForInt(sql);
		if (result==0)
			return 1;
		else 
			return 0;
	}
	
	
}
