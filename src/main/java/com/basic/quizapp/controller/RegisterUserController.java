package com.basic.quizapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.basic.quizapp.request.RegisterUserRequest;
import com.basic.quizapp.service.RegisterUserService;

@RestController
public class RegisterUserController {
	
	@Autowired RegisterUserService registerUserService;
	
	@PostMapping("/registerUser")
	public String registerNewUser(@RequestBody RegisterUserRequest newUserInfo) {
			
		registerUserService.registerNewUser(newUserInfo);
		
		return "user is registered succesfully";
		
	}
}
