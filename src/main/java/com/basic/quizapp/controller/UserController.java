package com.basic.quizapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.basic.quizapp.request.RegisterUserRequest;
import com.basic.quizapp.service.UserService;

@RestController
public class UserController {
	
	@Autowired UserService userService;
	
	@PostMapping("/registerUser")
	public String registerNewUser(RegisterUserRequest newUserInfo) {
			
		userService.registerNewUser(newUserInfo);
		
		return "user is registered succesfully";
		
	}
	
	@GetMapping("/registerForm")
	public ModelAndView registerForm() {
		return new ModelAndView("registerForm");
	}
}
