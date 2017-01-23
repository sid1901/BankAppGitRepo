package com.csc.BankingApp.Dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.csc.BankingApp.ValueObjects.AccountDetailsVO;
import com.csc.BankingApp.ValueObjects.LoginVO;

public class AccountDetailsDao {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}
	
	public int saveAccDetails(AccountDetailsVO accVO){  
		int results=0;
		String query="insert into account_details values(?,?,?,?,curdate(), curdate())";
	    results=jdbcTemplate.update(query,new Object[]{accVO.getAcc_no(),accVO.getAcc_type(),accVO.getCust_uid(),accVO.getAcc_curr_bal()});
	    return results;  
	}

	public int findAccNo(String accNo) {
		int result=1;
		String sql = "SELECT COUNT(*) FROM ACCOUNT_DETAILS WHERE ACC_NO = ?";
		result = jdbcTemplate.queryForInt(sql,new Object[]{accNo});
		return result;
	}

	public int findAccType(AccountDetailsVO accVO) {
		int result=-1;
		String sql = "SELECT COUNT(*) FROM ACCOUNT_DETAILS WHERE CUST_UID = ? and ACC_TYPE= ?";
		result = jdbcTemplate.queryForInt(sql,new Object[]{accVO.getCust_uid(),accVO.getAcc_type()});
		return result;
	}

	public int findAccByUid(AccountDetailsVO accVO) {
		String sql = "SELECT COUNT(*) FROM ACCOUNT_DETAILS WHERE CUST_UID = ?";
		int result = jdbcTemplate.queryForInt(sql,new Object[]{accVO.getCust_uid()});
		if (result==0)
			return 1;
		else 
			return 0;
	}

	public AccountDetailsVO FindAccNoByUidAndType(AccountDetailsVO accVO) {
		try{
 		String sql = "SELECT ACC_NO FROM ACCOUNT_DETAILS WHERE CUST_UID = ? AND ACC_TYPE= ? ";
		String acc_no = (String)jdbcTemplate.queryForObject(
				sql, new Object[] { accVO.getCust_uid(), accVO.getAcc_type() }, String.class);
		
		accVO.setAcc_no(acc_no);
		return accVO;
		}
		catch (Exception e)
		{
			accVO.setAcc_no("NA");
			return accVO;
		}
		
	}

	public int SearchAccountByAccNoAndF_L_Name(LoginVO loginVO , AccountDetailsVO accVO) {
		int result = 0;
		// Check for Account existance
		String sql1 = "select count(*) from account_details A, customer_info C "
				+ "where A.cust_uid = C.cust_uid "
				+ "and A.acc_no= ? "
				+ "and C.cust_fname = ? and C.cust_lname = ?";
		
		try{
		result =  result + jdbcTemplate.queryForObject(
				sql1, new Object[] { accVO.getPayee_acc_no(), loginVO.getCust_fname(), loginVO.getCust_lname() }, Integer.class);
		}
		catch(Exception e) {
			result = 0;
			return result;
		}
		return result;
	}
	
	
	public int CheckForEnoughBalAndDeduct(AccountDetailsVO accVO) {
	// Check for sufficient Account Balance.
		String sql1 = "select acc_curr_bal from account_details where acc_no = ?";
		System.out.println(accVO.getAcc_no());
		int available = jdbcTemplate.queryForObject(sql1, new Object[]{accVO.getAcc_no()},Integer.class);
		System.out.println(available);
		if(available < accVO.getTransfer_amount())
		{
			int result = 0;
			return result;
		}
		
		// Deduct Money from account.
		String sql2 = "update account_details set acc_curr_bal= acc_curr_bal - ? , "
						+ "acc_last_updated = curdate() where acc_no= ?" ;
		int result=jdbcTemplate.update(sql2,new Object[]{accVO.getTransfer_amount(),accVO.getAcc_no()});
			
		
		// Add Money to Payed.
		String sql3 = "update account_details set acc_curr_bal= acc_curr_bal + ? , "
							+ "acc_last_updated= curdate() where acc_no= ?";
		result=result+jdbcTemplate.update(sql3,new Object[]{accVO.getTransfer_amount(),accVO.getPayee_acc_no()});
		
		return result;
	}

	public int addPayeeInDB(String payeeAccNo, String uid, String payeeNickName) {
		int results=0;
		String query="insert into payee_details (payee_acc_no,payee_linked_uid,payee_nickname,payee_created_date) "
				+ "values ( ?, ?, ?, curtime())" ;
				
	    results=jdbcTemplate.update(query,new Object[]{payeeAccNo,uid,payeeNickName});
		return results;
		
	}

	public List findPayeeNo_NickName_ByUID(String uid) {
		List Payee_nick_no1 = null;
		String query="select concat(payee_nickname,'-',payee_acc_no) from payee_details where payee_linked_uid=?";
		Payee_nick_no1 = jdbcTemplate.queryForList(query, new Object[] {uid}, String.class);
		return Payee_nick_no1;
	}

	public int FindActivePayeeByUidAndPayeeAccNo(String uid, String payeeAccNo) {
		String query="SELECT TIMESTAMPDIFF(SECOND, payee_created_date, now()) from payee_details where "
				+ "payee_acc_no=? and payee_linked_uid= ?";
		
		int sec_diff = jdbcTemplate.queryForObject(query, new Object[] {payeeAccNo,uid}, Integer.class);
		return sec_diff;
					
	}
}