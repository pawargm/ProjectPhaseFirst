package com.project.tutorial.controller;

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
import java.util.LinkedList;

import com.project.tutorial.model.Tutorial;
import com.project.tutorial.service.TutorialService;;


@RestController
public class TutorialController {

	@Autowired
	private TutorialService tutorialService;
	
	@RequestMapping(value="/tut/create",method=RequestMethod.POST)
	public HttpStatus create(@RequestBody Tutorial tut) {
		System.out.println("tutorial "+tut.getTechName());
		HttpStatus stat = tutorialService.create(tut);
		return stat;
	}
	
	@RequestMapping(value="/tut/tags",method=RequestMethod.GET)
	public List<Tutorial> checkTutByTag(@RequestParam LinkedList<String>lsttag) {
		return tutorialService.getTutOnTag(lsttag);
	}
	
	@RequestMapping(value="/tut/tag",method=RequestMethod.GET)
	public List<Tutorial> checkTutByTag(@RequestParam String lsttag){
		return tutorialService.getTutOnTag(lsttag);
	}
	
}
