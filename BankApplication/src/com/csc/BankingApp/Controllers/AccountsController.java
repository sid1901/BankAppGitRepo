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
import com.csc.BankingApp.ValueObjects.AccountDetailsVO;



@Controller
public class AccountsController
{
@RequestMapping("/AccNoGen")
public ModelAndView AccNoGen_fun(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
{
	//code to generate 10digit random acc no.
		int len=10;
		String ALPHA_NUM = "0123456789";
		String AccNo =null;

		StringBuffer sb = new StringBuffer(len);
			for (int i = 0; i < len; i++) {
				int ndx = (int) (Math.random() * ALPHA_NUM.length());
				sb.append(ALPHA_NUM.charAt(ndx));
			}
			AccNo= sb.toString();
	System.out.println("acc: "+AccNo);
	
	String AccType=request.getParameter("AccType");
	System.out.println("Acctp: "+AccType);
	//save AccNo and AccType in database
	int status=0;
 	ApplicationContext ctx=new ClassPathXmlApplicationContext("BeanConfig.xml");  
    AccountDetailsDao dao=(AccountDetailsDao)ctx.getBean("accdao");
    AccountDetailsVO obj = new AccountDetailsVO();
	
    obj.setAcc_no(AccNo);
    obj.setAcc_type(AccType);
    HttpSession session = request.getSession();
    String uid=(String) session.getAttribute("uid");
    System.out.println("session uid: "+uid);
    session.invalidate();
    
	status=dao.saveAccDetails(obj,uid);
	if(status==0)
	{
	model.addAttribute("message1","Your account is successfully created!");
	model.addAttribute("message2","Your account number is "+AccNo+".");
	model.addAttribute("message3","Please login with your credentials.");
	return new ModelAndView("LoginPage");
	}
	else
		{
		String message = "ERROR!";
		return new ModelAndView("welcome", "message", message);
		}
}
}
}
