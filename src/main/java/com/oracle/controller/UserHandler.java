package com.oracle.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.service.UserService;
import com.oracle.web.bean.User;

@Controller
@Scope(value="prototype")
public class UserHandler {

	private static final String NONE = null;
	@Autowired
	private UserService userservice;
	
    @RequestMapping(value="/register",method=RequestMethod.POST)
    public String Register(User user){
    	
   int i= userservice.save(user);
    	
    if(i>0){
    	
    	return "login";
    }else{
    	
    	return "register";
    }
    	
    }
    
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(User user){
    	
    User u=this.userservice.login(user);
    
    if(u==null){
    	
    	return "login";
    }
    if(!u.getPassword().equals(user.getPassword())){
    	
    	return "login";
    }
    
    return "index";
    }
    
    @RequestMapping(value="validate.action")
    @ResponseBody
    public String validateuser(String username,HttpServletResponse resp) throws IOException{
    	
    	User a= userservice.vlidateuser(username);
    	
    	resp.setContentType("text/html;charset=utf-8");

        if(a!=null){
			
            resp.getWriter().write("{\"valid\":\"false\"}");
		
			}else{
				
				resp.getWriter().write("{\"valid\":\"true\"}");//不存在
			}
		
		return NONE;
    }
}
