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
		+uid +"','"+o.getAcc_curr_bal()+"', curdate(), curdate())";
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

	public String FindAccNoByUidAndType(String uid, String acc_type) {

		try{
		String sql = "SELECT ACC_NO FROM ACCOUNT_DETAILS WHERE CUST_UID = ? AND ACC_TYPE= ? ";
		//	String sql = "SELECT ACC_NO FROM ACCOUNT_DETAILS WHERE CUST_UID = '"+uid+"' AND ACC_TYPE= '"+acc_type+ "'";
		String acc_no = (String)jdbcTemplate.queryForObject(
				sql, new Object[] { uid, acc_type }, String.class);
		return acc_no;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "NA";
		}
		
	}

	public int SearchAccountByAccNoAndF_L_Name(String payeeAccNo, String fname, String lname, Double amount) {
		// TODO Auto-generated method stub
		Integer result = 0;
		String sql1 = "select count(*) from account_details A, customer_info C"
				+ "where A.cust_uid = C.cust_uid"
				+ "and A.acc_no= ?"
				+ "and C.cust_fname = ? and and C.cust_lname = ?";
		
		result =  result + jdbcTemplate.queryForObject(
				sql1, new Object[] { payeeAccNo, fname, lname }, Integer.class);
		
		
		System.out.println("result is "+result);
	
	return 0;
	}
	
	
}
