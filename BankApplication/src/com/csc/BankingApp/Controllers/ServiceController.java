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
	
	
	@RequestMapping("/Mobile")  
	public ModelAndView Mobile_fun(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("again checking");
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(30*60); //30 minutes
		String message = "Please Enter your 10 digit mobile Number";
		System.out.println("checking");
		return new ModelAndView("Mobile", "message", message); 
		
	}

}
