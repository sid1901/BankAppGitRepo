package com.csc.BankingApp.Controllers;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

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
import com.csc.BankingApp.ValueObjects.LoginVO;


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
    
    AccountDetailsVO accountDetailsVO = new AccountDetailsVO();
    accountDetailsVO.setCust_uid(uid);
    accountDetailsVO.setAcc_type(AccType);
    AccTypeexists=accdao.findAccType(accountDetailsVO);
	if(AccTypeexists==1)
	{
		String message = "You already have a "+AccType+" account.";
		return new ModelAndView("multiAcc", "message", message);
	}
	
	int NewUser=-1;
	NewUser = accdao.findAccByUid(accountDetailsVO);
	
	//Generate New accNo
	String AccNo = null;
	CommonServices commonServices= new CommonServices();
	int valid=-1;
	while(valid!=0)
	{
		AccNo= commonServices.randomNumGen();
		valid=accdao.findAccNo(AccNo);
	}
	
	//save AccNo and AccType in database
	int status=0;
   
	accountDetailsVO.setAcc_no(AccNo);
	accountDetailsVO.setAcc_curr_bal(InitAmt);
     session = request.getSession();
     uid=(String) session.getAttribute("uid");
    status=accdao.saveAccDetails(accountDetailsVO);
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
    
    AccountDetailsVO accountDetailsVO = new AccountDetailsVO();
    accountDetailsVO.setCust_uid(uid);
    accountDetailsVO.setAcc_type("Savings");;
    accountDetailsVO=accdao.FindAccNoByUidAndType(accountDetailsVO);
    S_AccNo=accountDetailsVO.getAcc_no();
    accountDetailsVO.setAcc_type("Current");;
    accountDetailsVO=accdao.FindAccNoByUidAndType(accountDetailsVO);
    C_AccNo=accountDetailsVO.getAcc_no();
    
    if (S_AccNo != "NA")
    	sav_attr=Enable_Attr;
    if (C_AccNo != "NA")
    	cur_attr=Enable_Attr;
    
    model.addAttribute("savings", sav_attr);
	model.addAttribute("current", cur_attr);
	model.addAttribute("S_AccNo",S_AccNo);
	model.addAttribute("C_AccNo",C_AccNo);
	
	TreeMap<String, String> payees = new TreeMap<String, String>();
	
	List Payee_nick_no_list = accdao.findPayeeNo_NickName_ByUID(uid);
	Iterator it = Payee_nick_no_list.iterator();
	
	while(it.hasNext()){
		String value = (it.next()).toString();
		String Nick_Num[] = value.split("-");
		String nick = Nick_Num[0];
		String Num = Nick_Num[1];
		payees.put(Num,value);
	}
	
	model.addAttribute("payees",payees);
	
	return new ModelAndView("SelectAcc");
}

@RequestMapping("/NEFT")
public ModelAndView NEFT_fun(HttpServletRequest request, HttpServletResponse response, ModelMap model)
{
	
	HttpSession session = request.getSession();
    String uid=(String) session.getAttribute("uid");
    String PayeeAccNo = request.getParameter("Payee");
    Double Amount = Double.parseDouble(request.getParameter("Amount"));
    String AccType = request.getParameter("AccType");
	
	int remained_secs = accdao.FindActivePayeeByUidAndPayeeAccNo(uid,PayeeAccNo);
	if(remained_secs < 120)
		{
			String message1="Please wait ! You can transfer funds to this payee after "+ (120-remained_secs)+" seconds";
			model.addAttribute("message1",message1);
			return new ModelAndView("welcome");
		}
	
	AccountDetailsVO accountDetailsVO = new AccountDetailsVO();
	accountDetailsVO.setCust_uid(uid);
	accountDetailsVO.setAcc_type(AccType);
	accountDetailsVO = accdao.FindAccNoByUidAndType(accountDetailsVO);
	accountDetailsVO.setPayee_acc_no(PayeeAccNo);
	accountDetailsVO.setTransfer_amount(Amount);
	int result = accdao.CheckForEnoughBalAndDeduct(accountDetailsVO);
    
    if(result==0)
    {
    	String message1="Sorry! You dont have enough balance.";
    	model.addAttribute("message1",message1);
    	return new ModelAndView("welcome");
    }
    
    if(result==2)
    {
    	String message1="Amount of Rs."+Amount+" is successfully transfered to "+PayeeAccNo+".";
    	model.addAttribute("message1",message1);
    	return new ModelAndView("welcome");
    }
    
	return new ModelAndView("welcome");

}



@RequestMapping("/AddPayee")
public ModelAndView AddPayee_fun(HttpServletRequest request, HttpServletResponse response, ModelMap model)
{	
	return new ModelAndView("AddPayee");
}


@RequestMapping("/verifyPayee")
public ModelAndView verifyPayee_fun(HttpServletRequest request, HttpServletResponse response, ModelMap model)
{
	
	HttpSession session = request.getSession();
    String uid=(String) session.getAttribute("uid");
    String PayeeAccNo = request.getParameter("PayeeAccNo");
    String PayeeFullName = request.getParameter("PayeeFullName");
    String PayeeNickName = request.getParameter("PayeeNickName");
   
    
    //Separate fname and lname
    String fname = null;
    String lname = null;
    
    int index=PayeeFullName.indexOf(" ");
    fname = PayeeFullName.substring(0, index);
    lname = PayeeFullName.substring(index+1,PayeeFullName.length());
    
    LoginVO loginVO = new LoginVO();
    AccountDetailsVO accountDetailsVO = new AccountDetailsVO();
    
    loginVO.setCust_fname(fname);
    loginVO.setCust_lname(lname);
    accountDetailsVO.setPayee_acc_no(PayeeAccNo);
    
    int result=accdao.SearchAccountByAccNoAndF_L_Name(loginVO, accountDetailsVO);
    
    if(result==0)
    {
    	String message1="Sorry! You have entered wrong account details. Please verify." ;
    	model.addAttribute("message1",message1);
    	return new ModelAndView("welcome");
    }
	
    else
    {
    	int ins_result = accdao.addPayeeInDB(PayeeAccNo,uid,PayeeNickName);
    	if(ins_result==1){    	
    	String message1=fname+" is successfully added to your Payee List." ;
    	String message2= "You can now transfer funds to "+fname+" after two minutes." ;
    	model.addAttribute("message1",message1);
    	model.addAttribute("message2",message2);
    	return new ModelAndView("welcome");
    	}
    	else
    	{
    		String message1="Something went wrong! Please try again." ;
        	model.addAttribute("message1",message1);
        	return new ModelAndView("welcome");
    	}
    }
	
}




}
