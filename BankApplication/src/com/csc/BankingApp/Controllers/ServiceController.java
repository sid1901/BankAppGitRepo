package com.csc.BankingApp.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServiceController {
	@RequestMapping("/Services")  
	public ModelAndView Services_fun(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(30*60); //30 minutes
		
		System.out.println("I am here ");
		String message = "Select your Services";
		return new ModelAndView("OHello", "message", message); 
		
	}
	
	@RequestMapping("/sumbitservice")
	public ModelAndView submitservice_fun(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("I am in submit service");
		System.out.println(request.getParameter("Services11"));
		System.out.println("Hi " +request.getParameter("Service11"));
    	if ((request.getParameter("Service11").equals("MB"))){
    			String message = "Please Enter your 10 digit mobile Number";
    			System.out.println("checking");
    			return new ModelAndView("Mobile", "message", message); 
    			}
    	else if ((request.getParameter("Service11").equals("EB"))){
				
    			System.out.println("I AM HERE");
				System.out.println("Hi " +request.getParameter("Service11"));
				String message = "Pay Your Electricity Bill";
				return new ModelAndView("Elebill","message",message);
		    }
    	else if ((request.getParameter("Service11").equals("DTH"))){
			
			System.out.println("I AM HERE");
			System.out.println("Hi " +request.getParameter("Service11"));
			String message = "Pay For Your DTH Connection";
			return new ModelAndView("Dth","message",message);
	    }
    	else {
    		String message = "Plese select any one";
        	return new ModelAndView("OHello", "message", message); 
    	}
	}
		
		
}
	


	
	
