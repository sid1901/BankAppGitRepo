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
    String query1="insert into login_details values('" +o.getUid() +"','" +o.getUpwd()+ "')";  
    int results=0;
    results=jdbcTemplate.update(query1);
    
    String query2="insert into customer_info values('" +o.getUid() +"','" +o.getCust_fname()+ "','" +o.getCust_lname()+ "','" +o.getCust_add_l1()
    + "','" +o.getCust_add_l2()+ "','" +o.getCust_mobile()+ "','" +o.getCust_age()+ "','" +o.getCust_gender()+ "','" +o.getCust_email()+ "')";  

    results=results+jdbcTemplate.update(query2);
    
    return results;  
}
 
 public int updateProfile(LoginVO o){
	 int result =0;
	 String query="UPDATE CUSTOMER_INFO SET CUST_FNAME='" +o.getCust_fname()+"', CUST_LNAME='"+o.getCust_lname()
	 +"', CUST_ADD_L1='"+o.getCust_add_l1()+"', CUST_ADD_L2='"+o.getCust_add_l2()+"', CUST_MOBILE='"+o.getCust_mobile()
	 +"', CUST_AGE='"+o.getCust_age()+"', CUST_EMAIL='"+o.getCust_email()
	 +"' where CUST_UID='"+o.getUid()+"'";
	 result=jdbcTemplate.update(query);
	 return result;
}


public int ValidateUser(LoginVO o){  
	int result=0;
	String query="select count(*) from login_details where uid = '" +o.getUid() +"' and upwd='" +o.getUpwd()+ "'";  
	 result = jdbcTemplate.queryForInt(query);
        
    return result;  
}  

public int updateLogin(LoginVO o){  
    String query="update login_details "
    		+ "set uid='"+o.getUid()+"',upwd='"+o.getUpwd()+"' where id='"+o.getUid()+"' ";  
    return jdbcTemplate.update(query);  
}  

public int deleteLogin(LoginVO o){  
    String query="delete from login_details where id='"+o.getUid()+"' ";  
    return jdbcTemplate.update(query);  
}

public String FindCustomerNameById(String uid) {
	// TODO Auto-generated method stub
	String sql = "SELECT CUST_FNAME FROM CUSTOMER_INFO WHERE CUST_UID = ?";

	String name = (String)jdbcTemplate.queryForObject(
			sql, new Object[] { uid }, String.class);

	return name;
}  
  
public List<LoginVO> FindAllUsers(){
	String sql = "SELECT * FROM LOGIN_DETAILS";
	List<LoginVO> users  = jdbcTemplate.query(sql,
			new BeanPropertyRowMapper(LoginVO.class));
	return users;
}

public LoginVO FindDetailsByUId(String uid){
	String sql = "SELECT * FROM CUSTOMER_INFO WHERE CUST_UID = ?";
	LoginVO details = (LoginVO)jdbcTemplate.queryForObject(
			sql, new Object[] { uid }, new BeanPropertyRowMapper(LoginVO.class));
	return details;
}


public String FindEmailByUid(String uid) {
	// TODO Auto-generated method stub
	String sql = "SELECT CUST_EMAIL FROM CUSTOMER_INFO WHERE CUST_UID = ?";

	try{
		String email = (String)jdbcTemplate.queryForObject(
				sql, new Object[] { uid }, String.class);
	
	return email;
	}
	catch(Exception e)
	{
	String email = null;
	return email;
	}
}  

}  