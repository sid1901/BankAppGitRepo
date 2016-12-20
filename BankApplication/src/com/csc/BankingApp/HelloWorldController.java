package com.csc.BankingApp;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.servlet.ModelAndView;  
@Controller  
public class HelloWorldController {  
    @RequestMapping("/hello")  
    public ModelAndView helloWorld() {  
    	System.out.println("CALLING THIS");
        String message = "HELLO SPRING MVC HOW R Uasd";  
        return new ModelAndView("Hello2", "message", message);  
        
    }  
    

    @RequestMapping("/smita")  
    public ModelAndView smitafunc() {  
    	System.out.println("I am smita");
        String message2 = "This is my message";  
        return new ModelAndView("Hello3", "message2", message2);  
    }  

    
}  