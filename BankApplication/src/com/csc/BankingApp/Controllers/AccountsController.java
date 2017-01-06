package com.csc.BankingApp.Controllers;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csc.BankingApp.Dao.AccountDetailsDao;
import com.csc.BankingApp.Services.CommonServices;
import com.csc.BankingApp.ValueObjects.AccountDetailsVO;



@Controller
public class AccountsController
{
	ApplicationContext ctx=new ClassPathXmlApplicationContext("BeanConfig.xml");  
    AccountDetailsDao accdao=(AccountDetailsDao)ctx.getBean("accdao");
    
@RequestMapping("/AccNoGen")
public ModelAndView AccNoGen_fun(HttpServletRequest request, HttpServletResponse response, ModelMap model) 
{
	int AccTypeexists=0;
	String AccType=request.getParameter("AccType");
	Double InitAmt=Double.parseDouble(request.getParameter("initAmt"));
	HttpSession session = request.getSession();
    String uid=(String) session.getAttribute("uid");
    
    AccTypeexists=accdao.findAccType(uid,AccType);
	if(AccTypeexists==1)
	{
		String message = "You already have a "+AccType+" account.";
		return new ModelAndView("multiAcc", "message", message);
	}
	
	int NewUser=-1;
	NewUser = accdao.findAccByUid(uid);
	
	//else if one acc exists then process and send to welcome
	//else process and send to LoginPage
	
	
	//Generate New accNo
	String AccNo = null;
	CommonServices commonServices= new CommonServices();
	int valid=-1;
	while(valid!=0)
	{
		AccNo= commonServices.randomNumGen();
		valid=accdao.findAccNo(AccNo);
	}
	
	System.out.println("Acctp: "+AccType);
	//save AccNo and AccType in database
	int status=0;
    AccountDetailsVO obj = new AccountDetailsVO();
	
    obj.setAcc_no(AccNo);
    obj.setAcc_type(AccType);
    obj.setAcc_curr_bal(InitAmt);
     session = request.getSession();
     uid=(String) session.getAttribute("uid");
    System.out.println("session uid: "+uid);
    status=accdao.saveAccDetails(obj,uid);
	if(status==1)
	{
	model.addAttribute("message1","Your account is successfully created!");
	model.addAttribute("message2","Your account number is "+AccNo+".");
		if(NewUser==1)
		{
			session.invalidate();
			model.addAttribute("message3","Please login with your credentials.");
			return new ModelAndView("LoginPage");
		}
		else
			return new ModelAndView("welcome");
	}
	else
		{
		String message = "ERROR!";
		return new ModelAndView("welcome", "message", message);
		}
	}

@RequestMapping("/multiAcc")
public ModelAndView multiAcc_fun(HttpServletRequest request, HttpServletResponse response) 
{
	String message="Hello";
	return new ModelAndView("multiAcc", "message", message);
}


@RequestMapping("/FundsTransfer")
public ModelAndView FundsTransfer_fun(HttpServletRequest request, HttpServletResponse response, ModelMap model)
{
	String S_AccNo = null;
	String C_AccNo = null;
	String sav_attr = "disabled='disabled'";;
	String cur_attr = "disabled='disabled'";;
	String Enable_Attr = "enabled='enabled'";
	
	HttpSession session = request.getSession();
    String uid=(String) session.getAttribute("uid");
    
    S_AccNo=accdao.FindAccNoByUidAndType(uid,"Savings");
    C_AccNo=accdao.FindAccNoByUidAndType(uid,"Current");
	
    if (S_AccNo != "NA")
    	sav_attr=Enable_Attr;
    if (C_AccNo != "NA")
    	cur_attr=Enable_Attr;
    
	model.addAttribute("savings", sav_attr);
	model.addAttribute("current", cur_attr);
	model.addAttribute("S_AccNo",S_AccNo);
	model.addAttribute("C_AccNo",C_AccNo);
	return new ModelAndView("SelectAcc");
}

@RequestMapping("/NEFT")
public ModelAndView NEFT_fun(HttpServletRequest request, HttpServletResponse response, ModelMap model)
{
	System.out.println("HERE");
	HttpSession session = request.getSession();
    String uid=(String) session.getAttribute("uid");
    String PayeeAccNo = request.getParameter("PayeeAccNo");
    Double Amount = Double.parseDouble(request.getParameter("Amount"));
    String PayeeFullName = request.getParameter("PayeeFullName");
    String AccType = request.getParameter("AccType");
    
    //Separate fname and lname
    String fname = null;
    String lname = null;
    
    int index=PayeeFullName.indexOf(" ");
    fname = PayeeFullName.substring(0, index);
    lname = PayeeFullName.substring(index+1,PayeeFullName.length());
    
    int result=accdao.SearchAccountByAccNoAndF_L_Name(PayeeAccNo, fname, lname);
    System.out.println("Final result is "+result);
    if(result=='0')
    {
    	String message1="Sorry! You have entered wrong account details. Please verify." ;
    	model.addAttribute("message1",message1);
    	return new ModelAndView("welcome");
    }
    
    
    String AccNo = accdao.FindAccNoByUidAndType(uid,AccType);
    result = accdao.CheckForEnoughBalAndDeduct(AccNo,Amount,PayeeAccNo);
    if(result==0)
    {
    	String message1="Sorry! You dont have enough balance.";
    	model.addAttribute("message1",message1);
    	return new ModelAndView("welcome");
    }
    
    if(result==2)
    {
    	String message1="Amount of Rs."+Amount+" is successfully transfered to "+PayeeFullName+".";
    	model.addAttribute("message1",message1);
    	return new ModelAndView("welcome");
    }
    
	return new ModelAndView("welcome");

}

}
