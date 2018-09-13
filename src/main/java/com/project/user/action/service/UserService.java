package com.project.user.action.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.user.action.model.User;
import com.project.user.action.repository.UserRepository;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	//this is for checking valid email 
	private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

	//To check valid email
	private boolean isValidEmail(String email) {
		Pattern ptr = Pattern.compile(EMAIL_REGEX,Pattern.CASE_INSENSITIVE);
		Matcher matcher = ptr.matcher(email);
		return matcher.matches();
		}
	
	//To Save password in encrypted format
	private String pwdEncryption(String pwd) {
		return BCrypt.hashpw(pwd, BCrypt.gensalt(12));
	}
	
	//To make new user account
	public HttpStatus create(User u) {
		
		if(isValidEmail(u.getEmail())){
			String  encrypt_pwd = pwdEncryption(u.getPassword());
			u.setPassword(encrypt_pwd);
			u.setEmail(u.getEmail().toLowerCase());
			userRepository.save(u);
			return HttpStatus.OK; //"Success:200";
		}
		else {
			return HttpStatus.ACCEPTED; //"InvalidEmailPattern:200";
		}
	}
	
	//To make Login
	public String login(String username, String password) {
		
		try {
		User u = getByUserName(username);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
		if(BCrypt.checkpw(password, u.getPassword())) {
			return "Success:200";
		}
		}
		catch(Exception e) {
			return "You don't have Account"+e.getMessage();
		}
		return "NoValidUser:";
	}
	
	//To find users by username
	public User getByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
	//To Find unsers by email id
	public User getByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	//To Find users by his firstname
	public List<User> getByFirstName(String username) {
		
		return userRepository.findByFirstName(username);
	}
	
}
