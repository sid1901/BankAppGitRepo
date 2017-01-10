package com.csc.BankingApp.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csc.BankingApp.Dao.AccountDetailsDao;
import com.csc.BankingApp.Dao.BankServiceDao;
import com.csc.BankingApp.Dao.LoginDetailsDao;
import com.csc.BankingApp.ValueObjects.AccountDetailsVO;


@Controller
public class ServiceController {
	@RequestMapping("/Services")  
	public ModelAndView Services_fun(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(30*60); //30 minutes
		
		String message = "Select your Services";
		return new ModelAndView("OHello", "message", message); 
		
	}
	
	@RequestMapping("/sumbitservice")
	public ModelAndView submitservice_fun(HttpServletRequest request, HttpServletResponse response) {


    	if ((request.getParameter("Service11").equals("MB"))){
    			String message = "Please Enter your 10 digit mobile Number";
    			return new ModelAndView("Mobile", "message", message); 
    			}
    	else if ((request.getParameter("Service11").equals("EB"))){
				
				String message = "Pay Your Electricity Bill";
				return new ModelAndView("Elebill","message",message);
		    }
    	else if ((request.getParameter("Service11").equals("DTH"))){
			
			String message = "Pay For Your DTH Connection";
			return new ModelAndView("Dth","message",message);
	    }
    	else {
    		String message = "Plese select any one";
        	return new ModelAndView("OHello", "message", message); 
    	}
	}
		
	
	@RequestMapping("/Txn")  
	public ModelAndView Txn_fun(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(30*60); //30 minutes
		
		String message = "TXN page";
		return new ModelAndView("Txn", "message", message); 
		
	}
	@RequestMapping("/TxnResult")  
	public ModelAndView TxnResult_fun(HttpServletRequest request, HttpServletResponse response) {
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("BeanConfig.xml");  
		BankServiceDao dao=(BankServiceDao)ctx.getBean("ldao");
	    HttpSession session = request.getSession();
	    String uid = (String) session.getAttribute("uid");
	    
	    AccountDetailsVO obj = new AccountDetailsVO();
	    
	    obj.setAcc_type(request.getParameter("AccType"));
	    
	    String status=null;
	    status=dao.Txn(obj);
	    
	    
	    
		String message = "TXN page";
		return new ModelAndView("Txn", "message", message); 
		
	}
	
}
	


	
	
