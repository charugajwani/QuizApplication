package com.basic.quizapp.service;

import org.springframework.stereotype.Service;

@Service
public class SecurityService {

	public boolean validatePassword(String username, String password) {
		return true;
	}
}
