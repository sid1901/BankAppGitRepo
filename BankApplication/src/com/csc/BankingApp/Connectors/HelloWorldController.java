package com.csc.BankingApp.Connectors;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.servlet.ModelAndView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.servlet.ModelAndView;

@Controller  
public class HelloWorldController {  
    @RequestMapping("/Login")  
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
    	
    	System.out.println("I AM HERE");
    	
    	
    	try {
    		Class.forName("com.mysql.jdbc.Driver"); 
			Connection con=DriverManager.getConnection("jdbc:mysql://20.198.11.120:3306/world","sid","sid1901");
			System.out.println("hii connected");
		} catch (SQLException e) {
			System.out.println("Ni Ho Paya");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Class NFound");
			e.printStackTrace();
			System.out.println("Class NFound");
		}
        

    	
    	String userName=request.getParameter("uid");
    	String password=request.getParameter("pwd");
    	String message;
    	if(userName != null 
    			&& !userName.equals("") 
    			&& userName.equals("sid") 
    			&& password != null 
    			&& !password.equals("") 
    			&& password.equals("123")){
    		
    		HttpSession session = request.getSession();
    		session.setAttribute("user", userName);
    		session.setMaxInactiveInterval(30*60); //30 minutes
    		
    		message = "Welcome " +userName + ".";
    		return new ModelAndView("welcome", "message", message);
    	}
    	else{
    		message = "Wrong username or password.";
    		return new ModelAndView("errorPage", "message", message); } 
    	}     
   
    

    
       

   

    
}  