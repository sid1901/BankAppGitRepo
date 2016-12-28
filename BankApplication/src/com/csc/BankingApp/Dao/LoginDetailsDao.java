package com.csc.BankingApp.Dao;

import org.springframework.jdbc.core.JdbcTemplate;
import com.csc.BankingApp.ValueObjects.LoginVO;  

public class LoginDetailsDao {  
private JdbcTemplate jdbcTemplate;  
  
public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
    this.jdbcTemplate = jdbcTemplate;  
}  
  
public int registerUser(LoginVO o){  
    String query1="insert into login_details values('" +o.getUname() +"','" +o.getUpwd()+ "')";  
    int results=0;
    results=jdbcTemplate.update(query1);
    
    String query2="insert into customer_info values('" +o.getUname() +"','" +o.getCust_fnmae()+ "','" +o.getCust_lname()+ "','" +o.getCust_add_l1()
    + "','" +o.getCust_add_l2()+ "','" +o.getCust_mobile()+ "','" +o.getCust_age()+ "','" +o.getCust_gender()+ "')";  

    results=results+jdbcTemplate.update(query2);
    
    return results;  
}  

public int ValidateUser(LoginVO o){  
	int result=0;
	String query="select count(*) from login_details where uname = '" +o.getUname() +"' and upwd='" +o.getUpwd()+ "'";  
	 result = jdbcTemplate.queryForInt(query);
        
    return result;  
}  


public int updateLogin(LoginVO o){  
    String query="update login_details "
    		+ "set uname='"+o.getUname()+"',upwd='"+o.getUpwd()+"' where id='"+o.getUname()+"' ";  
    return jdbcTemplate.update(query);  
}  
public int deleteLogin(LoginVO o){  
    String query="delete from login_details where id='"+o.getUname()+"' ";  
    return jdbcTemplate.update(query);  
}  
  
}  