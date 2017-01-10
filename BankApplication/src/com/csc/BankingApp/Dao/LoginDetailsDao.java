package com.csc.BankingApp.Dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.csc.BankingApp.ValueObjects.LoginVO;  

public class LoginDetailsDao {  
private JdbcTemplate jdbcTemplate;  
  
public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
    this.jdbcTemplate = jdbcTemplate;  
}  
  
 public int registerUser(LoginVO o){  
    String query1="insert into login_details values(?,?)";  
    int results=0;
    
    results=jdbcTemplate.update(query1,new Object[]{o.getUid(), o.getUpwd()});
        
    String query2="insert into customer_info values(?,?,?,?,?,?,?,?,?)";  
    
    results=results+jdbcTemplate.update(query2,new Object[]{o.getUid(),o.getCust_fname(),o.getCust_lname(),
    		o.getCust_add_l1(),o.getCust_add_l2(),o.getCust_mobile(),o.getCust_age(),
    		o.getCust_gender(),o.getCust_email()});
    
    return results;  
}
 
 public int updateProfile(LoginVO o){
	 int result =0;
	 String query="UPDATE CUSTOMER_INFO SET CUST_FNAME= ? ,CUST_LNAME= ? ,CUST_ADD_L1= ?, CUST_ADD_L2= ?, "
	 		+ "CUST_MOBILE= ?, CUST_AGE= ?, CUST_EMAIL= ? where CUST_UID = ?";
	 
	 result=jdbcTemplate.update(query,new Object[]{o.getCust_fname(),o.getCust_lname(),o.getCust_add_l1(),
			 o.getCust_add_l2(),o.getCust_mobile(),o.getCust_age(),o.getCust_email(),o.getUid()});
	
	 return result;
}

public int ValidateUser(LoginVO o){  
	int result=0;
	String query="select count(*) from login_details where uid = ? and upwd= ?";  
	 result = jdbcTemplate.queryForInt(query,new Object[]{o.getUid(),o.getUpwd()});
        
    return result;  
}  

public int updateLogin(LoginVO o){  
    int result =0;
	String query="update login_details "
    		+ "set uid=?, upwd=? where id=? ";  
    result = jdbcTemplate.update(query,new Object[]{o.getUid(),o.getUpwd(),o.getUid()});
    
    return result;
}  

public int deleteLogin(LoginVO o){  
    int result=0;
	String query="delete from login_details where id=?";  
    result = jdbcTemplate.update(query,new Object[]{o.getUid()});
    return result;
}

public LoginVO FindCustomerNameById(LoginVO loginVO) {
	// TODO Auto-generated method stub
	String sql = "SELECT CUST_FNAME FROM CUSTOMER_INFO WHERE CUST_UID = ?";

	String name = (String)jdbcTemplate.queryForObject(
			sql, new Object[] { loginVO.getUid() }, String.class);
	loginVO.setCust_fname(name);
	return loginVO;
}  
  
public List<LoginVO> FindAllUsers(){
	String sql = "SELECT * FROM LOGIN_DETAILS";
	List<LoginVO> users  = jdbcTemplate.query(sql,
			new BeanPropertyRowMapper<LoginVO>(LoginVO.class));
	return users;
}

public LoginVO FindDetailsByUId(LoginVO loginVO){
	String sql = "SELECT * FROM CUSTOMER_INFO WHERE CUST_UID = ?";
	loginVO = (LoginVO)jdbcTemplate.queryForObject(
			sql, new Object[] {loginVO.getUid()}, new BeanPropertyRowMapper<LoginVO>(LoginVO.class));
	return loginVO;
}


public LoginVO FindEmailByUid(LoginVO loginVO) {
	String sql = "SELECT CUST_EMAIL FROM CUSTOMER_INFO WHERE CUST_UID = ?";

	try{
		String email = (String)jdbcTemplate.queryForObject(
				sql, new Object[] {loginVO.getUid()}, String.class);
		loginVO.setCust_email(email);
	}
	catch(Exception e)
	{
		loginVO.setCust_email(null);
		return loginVO;
	}
	return loginVO;
}  

}  