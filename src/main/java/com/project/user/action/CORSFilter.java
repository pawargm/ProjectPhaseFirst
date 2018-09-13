package com.project.user.action;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

public class CORSFilter extends GenericFilterBean implements Filter  {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		
		HttpServletResponse httpresponse =(HttpServletResponse) response;
		httpresponse.setHeader("Access-Control-Allow-Origin", "*");
		httpresponse.setHeader("Access-Control-Allow-Methods", "*");
		httpresponse.setHeader("Access-Control-Allow-Headers", "*");
		httpresponse.setHeader("Access-Control-Allow-Credentials", "false");
		httpresponse.setHeader("Access-Control-Max-Age", "3600");
		System.out.println("CROS filter complete");
		chain.doFilter(request, httpresponse);

		
		
	}


	
	
	
	
}
