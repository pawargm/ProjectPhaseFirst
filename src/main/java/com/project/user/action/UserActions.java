package com.project.user.action;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.project.user.action.CORSFilter;


@SpringBootApplication
public class UserActions {

	public static void main(String[]args) {
		SpringApplication.run(UserActions.class,args);
	}

	@Bean
	public FilterRegistrationBean corsFilterRegistration() {
		FilterRegistrationBean reg = new FilterRegistrationBean(new CORSFilter());
		reg.setName("CORS Filter");
		reg.addUrlPatterns("/*");
		reg.setOrder(1);
		return reg;	
	}
	
	
}
