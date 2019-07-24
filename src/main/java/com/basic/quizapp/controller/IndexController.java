package com.basic.quizapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {
	
	@GetMapping("/")
	public String homeView() {
		return "Welcome";
	}
	
	@GetMapping("/login") 
	public ModelAndView login(){
		return new ModelAndView("loginPage");
	}
	@GetMapping("/homepage")
	public ModelAndView homePage(){
		return new ModelAndView("homepage");
	}
	
}
