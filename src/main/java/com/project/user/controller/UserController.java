package com.project.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.HashMap;

import com.project.user.model.User;
import com.project.user.service.UserService;

@RestController
public class UserController {
	
	//What is @Autowired?
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String dis() {
		System.out.println("dsffs");
		return "";
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public HttpStatus create(@RequestBody User user) {
		System.out.println(user.getFirstName());
		//String u = 
		HttpStatus u=userService.create(user);
		return u;//u;
	}
	
	@RequestMapping(value="/login1",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public HttpStatus login(@RequestBody User u,HttpSession session) {//@RequestParam String username,@RequestParam String password) {
		String tmp = userService.login(u.getUserName(),u.getPassword());//username,password);
		
		session.setAttribute("usrsession", "logout");
		if(tmp.equals("Success:200")) {
			session.setAttribute("usrsession", "login");
			return HttpStatus.OK;
		}
		else {
			session.setAttribute("usrsession", "logout");
			return HttpStatus.UNAUTHORIZED;
		}
	}
	
	@GetMapping("/greeting")
	public String index(HttpSession session) {
		
		System.out.println(session.getAttribute("usrsession"));
		session.removeValue("usrsession");
		return "index";
	}
	
	@RequestMapping(value="/checkemail",method=RequestMethod.GET)
	public HttpStatus checkEmail(@RequestParam String email)
	{
		User u = null;
		try {
		 u = userService.getByEmail(email);
		}
		catch(Exception e) {
			return HttpStatus.BAD_REQUEST;
		}
		if(u == null) {
			return HttpStatus.NOT_FOUND;
		}
		return HttpStatus.FOUND;
	}
	
	@RequestMapping(value="/checkusername",method=RequestMethod.GET)
	public HttpStatus checkUsername(@RequestParam String username) {
		
		User u = null;
		try {
			u = userService.getByUserName(username);
		}
		catch(Exception e) {
			return HttpStatus.BAD_REQUEST;
		}	
		if(u == null) {
			return HttpStatus.NOT_FOUND;
		}
		return HttpStatus.FOUND;
		
	}
	
	@RequestMapping(value="/islogin",method=RequestMethod.GET)
	public HttpStatus checkSession(HttpSession session) {
		
		if(session.getValue("usrsession") != null)
		{
			if(session.getValue("usrsession").equals("login")) {
				return HttpStatus.OK;
				}
			
		}
		return HttpStatus.NOT_ACCEPTABLE;
	}

}
