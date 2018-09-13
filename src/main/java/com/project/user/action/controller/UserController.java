package com.project.user.action.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.project.user.action.model.User;
import com.project.user.action.service.UserService;

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
	public HttpStatus login(@RequestBody User u) {//@RequestParam String username,@RequestParam String password) {
		String tmp = userService.login(u.getUserName(),u.getPassword());//username,password);
		
		if(tmp.equals("Success:200")) {
			return HttpStatus.OK;
		}
		else {
			return HttpStatus.UNAUTHORIZED;
		}
	}
	
	@GetMapping("/greeting")
	public String index() {
		
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


	
	
	
	
	
}