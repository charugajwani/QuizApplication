package com.basic.quizapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.basic.quizapp.util.SessionVariables;

@RestController
public class IndexController {
	
	@Autowired private HttpServletRequest request;
	
	@GetMapping("/")
	public ModelAndView homeView() {
		return new ModelAndView("homepage");
	}
	
	@GetMapping("/login") 
	public ModelAndView login(){
		return new ModelAndView("loginPage");
	}
	
	@GetMapping("/homepage")
	public ModelAndView homePage(){
		return new ModelAndView("homepage");
	}
	
	@GetMapping("/authToken")
	public String getAuthToken() {
		return (String) request.getSession().getAttribute(SessionVariables.AUTH_TOKEN);
	}
	
}
