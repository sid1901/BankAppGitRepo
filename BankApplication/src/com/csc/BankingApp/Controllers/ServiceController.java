package com.csc.BankingApp.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csc.BankingApp.Dao.AccountDetailsDao;
import com.csc.BankingApp.Dao.BankServiceDao;
import com.csc.BankingApp.Dao.LoginDetailsDao;
import com.csc.BankingApp.ValueObjects.AccountDetailsVO;


@Controller
public class ServiceController {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("BeanConfig.xml");  
    AccountDetailsDao accdao=(AccountDetailsDao)ctx.getBean("accdao");
	
	
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
	public ModelAndView Txn_fun(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		HttpSession session = request.getSession();
		String uid=(String) session.getAttribute("uid");
		String Amount = request.getParameter("Amount");
	    System.out.println(Amount);
	    session.setAttribute("Amount", Amount);
	    session.setAttribute("uid", uid);
	
		return new ModelAndView("Txn");
	}
	
	@RequestMapping("/TxnResult")
	public ModelAndView Txn_Result(HttpServletRequest request, HttpServletResponse response, ModelMap model){
		System.out.println("hello");
		HttpSession session = request.getSession();
		String uid=(String) session.getAttribute("uid");
		System.out.println(uid);
		String Amount=(String) session.getAttribute("Amount");
		//Double Amount = Double.parseDouble(request.getAttribute("Amount"));
		System.out.println(Amount);
		String AccType = request.getParameter("AccType");
	
		System.out.println(AccType);
	
	    AccountDetailsVO accountDetailsVO = new AccountDetailsVO();
		accountDetailsVO.setCust_uid(uid);
		accountDetailsVO.setAcc_type(AccType);
	
		Double Amount_dbl = Double.parseDouble(Amount);
		accountDetailsVO.setTransfer_amount(Amount_dbl);
	
		// set acc no
		accountDetailsVO = accdao.FindAccNoByUidAndType(accountDetailsVO);
		
		// set payee_acc_no
		
		String service_provider_acc_no = "9571650934";
		accountDetailsVO.setPayee_acc_no(service_provider_acc_no);
		System.out.println(service_provider_acc_no);
		
		AccountDetailsDao ob = new AccountDetailsDao();
		int result =ob.CheckForEnoughBalAndDeduct(accountDetailsVO);
		System.out.println(result);
		
		if(result==0)
	    {
	    	String message1="Sorry! You dont have enough balance.";
	    	model.addAttribute("message1",message1);
	    	return new ModelAndView("welcome");
	    }
	    
	    if(result==2)
	    {
	    	String message1="Amount of Rs."+Amount+" is successfully Recharged.";
	    	model.addAttribute("message1",message1);
	    	return new ModelAndView("welcome");
	    }
		
		
		return new ModelAndView("welcome");
		
		
	}
	
	
	}
	

	


	
	
