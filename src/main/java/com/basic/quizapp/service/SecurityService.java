package com.basic.quizapp.service;

import org.springframework.stereotype.Service;

import com.basic.quizapp.entity.UserDetail;

@Service
public class SecurityService {

	public boolean validatePassword(String username, String password) {
		return true;
	}
	
	public UserDetail getUserDetails(String username) {
		UserDetail userDetail = new UserDetail();
		userDetail.setRole("ROLE_USER");
		return userDetail;
	}
}
