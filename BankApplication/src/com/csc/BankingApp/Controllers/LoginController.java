package com.csc.BankingApp.Controllers;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.servlet.ModelAndView;

import com.csc.BankingApp.Dao.LoginDetailsDao;
import com.csc.BankingApp.ValueObjects.LoginVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  

@Controller  
public class LoginController {  
    @RequestMapping("/Validate")  
    public ModelAndView Validate_fun(HttpServletRequest request, HttpServletResponse response) {
    	
    	System.out.println("I AM HERE");
    	
    	    ApplicationContext ctx=new ClassPathXmlApplicationContext("BeanConfig.xml");  
    	      
    	    LoginDetailsDao dao=(LoginDetailsDao)ctx.getBean("ldao");
    	    LoginVO obj = new LoginVO();
    	    obj.setUname(request.getParameter("uid"));
    	    obj.setUpwd(request.getParameter("pwd"));
    	    
    	    int status=dao.ValidateUser(obj);  
    	    System.out.println(status);

    	    if (status==1){
    	    	String uname = request.getParameter("uid");
        		String welcome_message = "Welcome " +uname + ".";
        		return new ModelAndView("welcome", "message", welcome_message);
        	}
        	else{
        		String error_message = "Wrong username or password.";
        		return new ModelAndView("errorPage", "message", error_message); } 
        	}
    	    
    	    
    	  //  obj.setUname("Rajesh3");
    	   // obj.setUpwd("Rajpwd3");
    	   // int status=dao.saveLogin(obj);  
    	   // System.out.println(status);
    	   // System.out.println("Database Updated !!!");
    	          
    	    /*int status=dao.updateEmployee(new Employee(102,"Sonoo",15000)); 
    	    System.out.println(status); 
    	    */  
    	          
    	    /*Employee e=new Employee(); 
    	    e.setId(102); 
    	    int status=dao.deleteEmployee(e); 
    	    System.out.println(status);*/  
    	         	
    
    		
    		/*HttpSession session = request.getSession();
    		session.setAttribute("user", userName);
    		session.setMaxInactiveInterval(30*60); //30 minutes
*/    		
    		
    

@RequestMapping("/Register")  
public ModelAndView register_fun(HttpServletRequest request, HttpServletResponse response) {
	System.out.println("HELLO SID");
	String message = "Dummy Message";
	return new ModelAndView("LoginForm", "message", message); 
}

@RequestMapping("/NewUser")  
public ModelAndView enterdb_fun(HttpServletRequest request, HttpServletResponse response) {
	System.out.println("HELLO SID");
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("BeanConfig.xml");  
    LoginDetailsDao dao=(LoginDetailsDao)ctx.getBean("ldao");
    LoginVO obj = new LoginVO();
    
    String FName=request.getParameter("fname");
    System.out.println(FName);
    
    obj.setUname(request.getParameter("uid"));
    obj.setUpwd(request.getParameter("pwd"));
    obj.setCust_fnmae(request.getParameter("fname"));
    obj.setCust_lname(request.getParameter("lname"));
    obj.setCust_add_l1(request.getParameter("add1"));
    obj.setCust_add_l2(request.getParameter("add2"));
    obj.setCust_mobile(request.getParameter("mob"));
    obj.setCust_age(Integer.parseInt(request.getParameter("age")));
    obj.setCust_gender(request.getParameter("gen"));
    
    int status=dao.registerUser(obj);  
    System.out.println(status);
    System.out.println("Creds Updated !!!");
    System.out.println("Customer Info Updated !!!");
       
    
	String message = "Dummy Message";
	return new ModelAndView("index", "message", message); 
}
}
  

