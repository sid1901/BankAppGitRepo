package com.csc.BankingApp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.servlet.ModelAndView;

import com.csc.BankingApp.Dao.LoginDetailsDao;
import com.csc.BankingApp.Services.CommonServices;
import com.csc.BankingApp.ValueObjects.LoginVO;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  

@Controller  
public class LoginController {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("BeanConfig.xml");  
    LoginDetailsDao dao=(LoginDetailsDao)ctx.getBean("ldao");
	
@RequestMapping("/Validate")
public ModelAndView Validate_fun(HttpServletRequest request, HttpServletResponse response, ModelMap modal) {
	
	
	CommonServices commonServices= new CommonServices();
	commonServices.sendMail();
	
	HttpSession session = request.getSession();
	if (session.getAttribute("uid")==null)
	{
    	    LoginVO loginVO = new LoginVO();
    	    loginVO.setUid(request.getParameter("uid"));
    	    loginVO.setUpwd(request.getParameter("pwd"));
    	    int status=0;
    	    status=dao.ValidateUser(loginVO);  
    	    
    	    if (status==1){
    	    	String uid = request.getParameter("uid");
    	    	session = request.getSession();
        		session.setAttribute("uid", uid);
        		session.setAttribute("name", loginVO.getCust_fname());
    	    	
    	    	
    	    	loginVO.setUid(uid);
    	    	loginVO=dao.FindCustomerNameById(loginVO);  
        		String welcome_message = "Welcome User: " +loginVO.getCust_fname()+ ".";
        		modal.addAttribute("UserName", loginVO.getCust_fname());
        		modal.addAttribute("message",welcome_message);
        		return new ModelAndView("welcome");
        	}
        	else{
        		String error_message = "Wrong username or password.";
        		return new ModelAndView("errorPage", "message", error_message); } 
        	}
	else {
		return new ModelAndView("welcome"); }
	
}
    		
@RequestMapping("/Logout")
public ModelAndView Logout_fun(HttpServletRequest request, HttpServletResponse response) {
    	
    	HttpSession session = request.getSession();
		session.removeAttribute("uid");
		session.removeAttribute("name");
		session.invalidate();
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		response.setHeader("Pragma","no-cache");
		response.setDateHeader("Expires", 0);
		request.removeAttribute("uid");
		String message = "Successfully Logged Out ! Visit Again";
	
    	return new ModelAndView("LoginPage", "message", message); 
    }    

@RequestMapping("/Register")  
public ModelAndView register_fun(HttpServletRequest request, HttpServletResponse response) {
	return new ModelAndView("LoginForm"); 
}

@RequestMapping("/NewUser")  
public ModelAndView enterdb_fun(HttpServletRequest request, HttpServletResponse response) {
	LoginVO loginVO = new LoginVO();
    
    loginVO.setUid(request.getParameter("uid"));
    loginVO.setUpwd(request.getParameter("pwd"));
    loginVO.setCust_fname(request.getParameter("fname"));
    loginVO.setCust_lname(request.getParameter("lname"));
    loginVO.setCust_add_l1(request.getParameter("add1"));
    loginVO.setCust_add_l2(request.getParameter("add2"));
    loginVO.setCust_mobile(request.getParameter("mob"));
    loginVO.setCust_email(request.getParameter("email"));
    loginVO.setCust_age(Integer.parseInt(request.getParameter("age")));
    loginVO.setCust_gender(request.getParameter("gen"));
    
    int status=dao.registerUser(loginVO);  
    String message=null;
    
    if(status==2)
    {
    	message = "User Successfully Created! Please Login with your credentials";
    	HttpSession session = request.getSession();
    	session.setAttribute("uid", request.getParameter("uid"));
    	return new ModelAndView("AccNoGeneration");
    }
    else
    {
    	message = "Sorry! User creation failed! please try again.";
    	return new ModelAndView("errorPage", "message", message);
    }
}




@RequestMapping("/Forgot")  
public ModelAndView ForgotPwd_Fun(HttpServletRequest request, HttpServletResponse response) {
	String message = "Dummy Message";
	return new ModelAndView("ForgotPWDPage", "message", message); 
}

@RequestMapping("/EmailForRecovery")  
public ModelAndView email_fun(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
	String uid = request.getParameter("uid");
	LoginVO loginVO = new LoginVO();
	loginVO.setUid(uid);
	dao.FindEmailByUid(loginVO);
    if (loginVO.getCust_email()==null){
    	String message = "Sorry! no such user exists.";
    	return new ModelAndView("LoginPage", "message", message); 
    }
    else
    {
    model.addAttribute("email",loginVO.getCust_email());
    model.addAttribute("uid",loginVO.getUid());
	return new ModelAndView("RecoverByMail");
    }
}

@RequestMapping("/SendMail")  
public ModelAndView SendMail_fun(HttpServletRequest request, HttpServletResponse response) {
	HttpSession session = request.getSession();
	String uid = (String) session.getAttribute("uid");
	String email = request.getParameter("email");
	
	CommonServices commonServices= new CommonServices();
	commonServices.sendMail();
	
	String message = "";
	return new ModelAndView("LoginPage", "message", message); 
}

@RequestMapping("/Profile")
public ModelAndView view_prof_fun(HttpServletRequest request, HttpServletResponse response, ModelMap map){
	HttpSession session = request.getSession();
    String uid = (String) session.getAttribute("uid");
    LoginVO loginVO = new LoginVO();
    loginVO.setUid(uid);
    loginVO=dao.FindDetailsByUId(loginVO);
    map.addAttribute("fname",loginVO.getCust_fname());
    map.addAttribute("lname",loginVO.getCust_lname());
    map.addAttribute("add1",loginVO.getCust_add_l1());
    map.addAttribute("add2",loginVO.getCust_add_l2());
    map.addAttribute("mob",loginVO.getCust_mobile());
    map.addAttribute("email",loginVO.getCust_email());
    map.addAttribute("age",loginVO.getCust_age());
    
    return new ModelAndView("Profile");
}	

@RequestMapping("/SaveProfile")
public ModelAndView save_prof_fun(HttpServletRequest request, HttpServletResponse response, ModelMap map) throws IOException{
	  
	  HttpSession session = request.getSession();
	  LoginVO loginVO = new LoginVO();
	  	  
	  loginVO.setUid((session.getAttribute("uid")).toString());
	  loginVO.setCust_fname(request.getParameter("fname"));
	  loginVO.setCust_lname(request.getParameter("lname"));
	  loginVO.setCust_add_l1(request.getParameter("add1"));
	  loginVO.setCust_add_l2(request.getParameter("add2"));
	  loginVO.setCust_mobile(request.getParameter("mob"));
	  loginVO.setCust_email(request.getParameter("email"));
	  loginVO.setCust_age(Integer.parseInt(request.getParameter("age")));
	    
	    
	  int result=0;
	  result = dao.updateProfile(loginVO);
	  String message = "Profile Successfully Updated !!";
	  
	  return new ModelAndView("DisplayMessagePage", "message", message); 
}





}
  

