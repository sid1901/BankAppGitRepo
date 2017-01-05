package com.csc.BankingApp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.servlet.ModelAndView;

import com.csc.BankingApp.Dao.LoginDetailsDao;
import com.csc.BankingApp.ValueObjects.LoginVO;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  

@Controller  
public class LoginController {
@RequestMapping("/Validate")
public ModelAndView Validate_fun(HttpServletRequest request, HttpServletResponse response, ModelMap modal) {
	
	HttpSession session = request.getSession();
	System.out.println("testing uid" +session.getAttribute("uid"));
	if (session.getAttribute("uid")==null)
	{
    	    ApplicationContext ctx=new ClassPathXmlApplicationContext("BeanConfig.xml");  
    	    LoginDetailsDao dao=(LoginDetailsDao)ctx.getBean("ldao");
    	   
    	    LoginVO obj = new LoginVO();
    	    obj.setUid(request.getParameter("uid"));
    	    obj.setUpwd(request.getParameter("pwd"));
    	    int status=0;
    	    status=dao.ValidateUser(obj);  
    	    System.out.println(status);

    	    if (status==1){
    	    	String uid = request.getParameter("uid");
    	    	String Fname = dao.FindCustomerNameById(uid);  
        		String welcome_message = "Welcome User: " +Fname+ ".";
        		modal.addAttribute("UserName", Fname);
        		modal.addAttribute("message",welcome_message);
        		
        		session = request.getSession();
        		session.setAttribute("uid", uid);
        		
        		//setting session to expiry in 30 mins
    			//session.setMaxInactiveInterval(30*60);
    		
    			//response.sendRedirect("LoginSuccess.jsp");
    			
        		return new ModelAndView("welcome");
        	}
        	else{
        		String error_message = "Wrong username or password.";
        		return new ModelAndView("errorPage", "message", error_message); } 
        	}
	else {
		System.out.println("here");
		modal.addAttribute("message","");
		return new ModelAndView("welcome"); }
	
}
    		
@RequestMapping("/Logout")
public ModelAndView Logout_fun(HttpServletRequest request, HttpServletResponse response) {
    	
    	HttpSession session = request.getSession();
		session.removeAttribute("uid");
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
	System.out.println("HELLO SID");
	String message = "Dummy Message";
	return new ModelAndView("LoginForm", "message", message); 
}

@RequestMapping("/NewUser")  
public ModelAndView enterdb_fun(HttpServletRequest request, HttpServletResponse response) {
	System.out.println("HELLO SID");
	
  	ApplicationContext ctx=new ClassPathXmlApplicationContext("BeanConfig.xml");  
    LoginDetailsDao dao=(LoginDetailsDao)ctx.getBean("ldao");
    LoginVO obj = new LoginVO();
    
    obj.setUid(request.getParameter("uid"));
    obj.setUpwd(request.getParameter("pwd"));
    obj.setCust_fname(request.getParameter("fname"));
    obj.setCust_lname(request.getParameter("lname"));
    obj.setCust_add_l1(request.getParameter("add1"));
    obj.setCust_add_l2(request.getParameter("add2"));
    obj.setCust_mobile(request.getParameter("mob"));
    obj.setCust_email(request.getParameter("email"));
    obj.setCust_age(Integer.parseInt(request.getParameter("age")));
    obj.setCust_gender(request.getParameter("gen"));
    
    int status=dao.registerUser(obj);  
    System.out.println(status);
    String message=null;
    
    if(status==2){
    System.out.println("Creds Updated !!!");
    System.out.println("Customer Info Updated !!!");
    message = "User Successfully Created! Please Login with your credentials";
    
    HttpSession session = request.getSession();
	session.setAttribute("uid", request.getParameter("uid"));
	
    return new ModelAndView("AccNoGeneration");
    }
    else{
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
    
	ApplicationContext ctx=new ClassPathXmlApplicationContext("BeanConfig.xml");  
    LoginDetailsDao dao=(LoginDetailsDao)ctx.getBean("ldao");
    
    String email = null;
    email = dao.FindEmailByUid(uid);
    if (email==null){
    	String message = "Sorry! no such user exists.";
    	return new ModelAndView("LoginPage", "message", message); 
    }
    else{
    model.addAttribute("email",email);
    model.addAttribute("uid",uid);
	return new ModelAndView("RecoverByMail");
    }
}

@RequestMapping("/SendMail")  
public ModelAndView SendMail_fun(HttpServletRequest request, HttpServletResponse response) {
	String message = "Sorry ! This Page is Under Construction...";
	return new ModelAndView("LoginPage", "message", message); 
}

@RequestMapping("/Profile")
public ModelAndView view_prof_fun(HttpServletRequest request, HttpServletResponse response, ModelMap map){
	ApplicationContext ctx=new ClassPathXmlApplicationContext("BeanConfig.xml");  
    LoginDetailsDao dao=(LoginDetailsDao)ctx.getBean("ldao");
    HttpSession session = request.getSession();
    String uid = (String) session.getAttribute("uid");
    LoginVO obj = new LoginVO();
    obj = dao.FindDetailsByUId(uid);
    System.out.println("Fetching object :");
    System.out.println(obj.getCust_fname());
    System.out.println(obj.getCust_lname());
    System.out.println(obj.getCust_add_l1());
    System.out.println(obj.getCust_add_l2());
    System.out.println(obj.getCust_mobile());
    System.out.println(obj.getCust_age());
    System.out.println(obj.getCust_email());
    
    
    
    
    map.addAttribute("fname",obj.getCust_fname());
    map.addAttribute("lname",obj.getCust_lname());
    map.addAttribute("add1",obj.getCust_add_l1());
    map.addAttribute("add2",obj.getCust_add_l2());
    map.addAttribute("mob",obj.getCust_mobile());
    map.addAttribute("email",obj.getCust_email());
    map.addAttribute("age",obj.getCust_age());
    
    
    
    return new ModelAndView("Profile");
}	

@RequestMapping("/SaveProfile")
public ModelAndView save_prof_fun(HttpServletRequest request, HttpServletResponse response, ModelMap map) throws IOException{
	  ApplicationContext ctx=new ClassPathXmlApplicationContext("BeanConfig.xml");  
	  LoginDetailsDao dao=(LoginDetailsDao)ctx.getBean("ldao");
	  
	  HttpSession session = request.getSession();
	  System.out.println("uid"+session.getAttribute("uid"));
	  
	  LoginVO obj = new LoginVO();
	  System.out.println("OE"+request.getParameter("fname"));
	  System.out.println(request.getParameter("lname"));
	  System.out.println(request.getParameter("add1"));
	  System.out.println(request.getParameter("add2"));
	  System.out.println(request.getParameter("mob")); 
	  System.out.println(request.getParameter("age"));
	  System.out.println(request.getParameter("email"));
	  System.out.println(request.getParameter("gender"));
	  
	  
	  obj.setUid((session.getAttribute("uid")).toString());
	  obj.setCust_fname(request.getParameter("fname"));
	  obj.setCust_lname(request.getParameter("lname"));
	    obj.setCust_add_l1(request.getParameter("add1"));
	    obj.setCust_add_l2(request.getParameter("add2"));
	    obj.setCust_mobile(request.getParameter("mob"));
	    obj.setCust_email(request.getParameter("email"));
	    obj.setCust_age(Integer.parseInt(request.getParameter("age")));
	    
	    
	  int result=0;
	  result = dao.updateProfile(obj);
	  String message = "Profile Successfully Updated !!";
	  
	  //response.sendRedirect("Profile.html");
	  
	  return new ModelAndView("DisplayMessagePage", "message", message); 
}





}
  

