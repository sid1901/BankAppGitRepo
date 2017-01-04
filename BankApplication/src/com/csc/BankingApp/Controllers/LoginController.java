package com.csc.BankingApp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.servlet.ModelAndView;

import com.csc.BankingApp.Dao.LoginDetailsDao;
import com.csc.BankingApp.ValueObjects.LoginVO;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  

@Controller  
public class LoginController {  
    @RequestMapping("/Validate")  
    public ModelAndView Validate_fun(HttpServletRequest request, HttpServletResponse response, ModelMap modal) {
    	
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
        		
        		HttpSession session = request.getSession();
        		session.setAttribute("uid", uid);
        		
        		//setting session to expiry in 30 mins
    			session.setMaxInactiveInterval(30*60);
    		
    			//response.sendRedirect("LoginSuccess.jsp");
        		
        		
        		
        		return new ModelAndView("welcome");
        	}
        	else{
        		String error_message = "Wrong username or password.";
        		return new ModelAndView("errorPage", "message", error_message); } 
        	}
    	    
    	    
    	  //  obj.setUname("Rajesh3");
    	   // obj.setUpwd("Rajpwd3");
    	   // int status=dao.saveLogin(obj);  
    	   // System.out.println(status);
    	   // System.out.println("Database Updated !!!");
    	          
    	    /*int status=dao.updateEmployee(new Employee(102,"Sonoo",15000)); 
    	    System.out.println(status); 
    	    */  
    	          
    	    /*Employee e=new Employee(); 
    	    e.setId(102); 
    	    int status=dao.deleteEmployee(e); 
    	    System.out.println(status);*/  
    	         	
    
    		
    		/*HttpSession session = request.getSession();
    		session.setAttribute("user", userName);
    		session.setMaxInactiveInterval(30*60); //30 minutes
*/    		
    		
    @RequestMapping("/Logout")  
    public ModelAndView Logout_fun(HttpServletRequest request, HttpServletResponse response) {
    	
    	HttpSession session = request.getSession();
		session.removeAttribute("uid");
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		response.setHeader("Pragma","no-cache");
		response.setDateHeader("Expires", 0);
		session.invalidate();
		request.removeAttribute("uid");
		session.invalidate();
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
    
    String FName=request.getParameter("fname");
    System.out.println(FName);
    
    obj.setUid(request.getParameter("uid"));
    obj.setUpwd(request.getParameter("pwd"));
    obj.setCust_fnmae(request.getParameter("fname"));
    obj.setCust_lname(request.getParameter("lname"));
    obj.setCust_add_l1(request.getParameter("add1"));
    obj.setCust_add_l2(request.getParameter("add2"));
    obj.setCust_mobile(request.getParameter("mob"));
    obj.setCust_age(Integer.parseInt(request.getParameter("age")));
    obj.setCust_gender(request.getParameter("gen"));
    
    int status=dao.registerUser(obj);  
    System.out.println(status);
    System.out.println("Creds Updated !!!");
    System.out.println("Customer Info Updated !!!");
       
    
	String message = "User Successfully Created! Please Login with your credentials";
	return new ModelAndView("LoginPage", "message", message); 
}





}
  

