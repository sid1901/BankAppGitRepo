package com.csc.BankingApp.Dao;

import org.springframework.jdbc.core.JdbcTemplate;
import com.csc.BankingApp.ValueObjects.LoginVO;  

public class LoginDetailsDao {  
private JdbcTemplate jdbcTemplate;  
  
public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
    this.jdbcTemplate = jdbcTemplate;  
}  
  
public int saveLogin(LoginVO o){  
    String query="insert into login_details values('" +o.getUname() +"','" +o.getUpwd()+ "')";  
    return jdbcTemplate.update(query);  
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