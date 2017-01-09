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

	public int SearchAccountByAccNoAndF_L_Name(String payeeAccNo, String fname, String lname) {
		
		int result = 0;
		// Check for Account existance
		String sql1 = "select count(*) from account_details A, customer_info C "
				+ "where A.cust_uid = C.cust_uid "
				+ "and A.acc_no= ? "
				+ "and C.cust_fname = ? and C.cust_lname = ?";
		System.out.println(sql1);
		
		try{
		result =  result + jdbcTemplate.queryForObject(
				sql1, new Object[] { payeeAccNo, fname, lname }, Integer.class);
		}
		catch(Exception e) {
			result = 0;
			return result;
		}
		
		return result;
		
	}
	
	
	public int CheckForEnoughBalAndDeduct(String AccNo, Double amount, String PayeeAccNo) {
	
	// Check for sufficient Account Balance.
			String sql1 = "select acc_curr_bal from account_details where acc_no = '" +AccNo+"'";
			int available = jdbcTemplate.queryForInt(sql1);
			if(available < amount)
			{
				int result = 0;
				return result;
			}
			
			// Deduct Money from account.
			String sql2 = "update account_details set acc_curr_bal= acc_curr_bal - " +amount
					+ " , acc_last_updated= curdate() where acc_no= '" +AccNo+"'" ;
					int result=jdbcTemplate.update(sql2);
					System.out.println("result is "+result);
				
			// Add Money to Payed.
				String sql3 = "update account_details set acc_curr_bal= acc_curr_bal + " +amount
							+ " , acc_last_updated= curdate() where acc_no= '" +PayeeAccNo+"'";
							 result=result+jdbcTemplate.update(sql3);
							System.out.println("result is "+result);
								
					return result;
	}

	public int addPayeeInDB(String payeeAccNo, String uid, String payeeNickName) {
		// TODO Auto-generated method stub
		String query="insert into payee_details (payee_acc_no,payee_linked_uid,payee_nickname,payee_created_date) "
				+ "values ('"+ payeeAccNo +"','"+uid+"','"+payeeNickName+"',curtime())" ;
				
			    int results=0;
			    results=jdbcTemplate.update(query);
			     return results;
		
	}

	public String[] findPayeeNo_NickName_ByUID(String uid) {
		// TODO Auto-generated method stub
		String query="select concat(payee_nickname,'-',payee_acc_no) from payee_details where payee_linked_uid='"+uid+"'";
		return null;
	}
}