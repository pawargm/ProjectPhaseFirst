package com.project.user.action.view;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppView {
	
	@RequestMapping("/indexview") 
	public ModelAndView index(@RequestParam("name") String myname) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("name",myname);
		mv.setViewName("index");
		
		return mv;
	}
	
	@RequestMapping("/singup") 
	public ModelAndView singup() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("testpostresponse");
		
		return mv;
	}

	@RequestMapping("/bootstrap123") 
	public ModelAndView bootstrap123() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bootstrap");
		
		return mv;
	}

	@RequestMapping("/singlepage")
	public ModelAndView singlepage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("singlepage");
		return mv;
	}
	
	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/blog")
	public ModelAndView blog() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("blog");
		return mv;
	}
	
	@RequestMapping("/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("about");
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}

	@RequestMapping("/singup1")
	public ModelAndView signup() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("singup");
		return mv;
	}
	
	@RequestMapping("/tutorial")
	public ModelAndView tutorial(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tutorial");
		return mv;
	}
	
/*	@RequestMapping("/afterlogin")
	public ModelAndView afterlogin(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("afterlogin");
		return mv;
	}
*/

	
}
