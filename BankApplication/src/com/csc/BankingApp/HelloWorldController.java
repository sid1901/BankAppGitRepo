package com.csc.BankingApp;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.servlet.ModelAndView;  
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;   
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.servlet.ModelAndView;

@Controller  
public class HelloWorldController {  
    @RequestMapping("/Login")  
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
    	String userName=request.getParameter("uid");
    	String password=request.getParameter("pwd");
    	String message;
    	if(userName != null 
    			&& !userName.equals("") 
    			&& userName.equals("sid") 
    			&& password != null 
    			&& !password.equals("") 
    			&& password.equals("123")){
    		message = "Welcome " +userName + ".";
    		return new ModelAndView("welcome", "message", message);
    	}
    	else{
    		message = "Wrong username or password.";
    		return new ModelAndView("errorPage", "message", message); } 
    	}     
   
    

    @RequestMapping("/smita")  
    public ModelAndView smitafunc() {  
    	System.out.println("I am smita");
        String message2 = "This is my message";  
        return new ModelAndView("Hello3", "message2", message2);  
    }  

    
}  