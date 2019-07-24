package com.basic.quizapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.quizapp.entity.RegisterUser;
import com.basic.quizapp.repository.RegisterUserRepo;

@Service
public class RegisterUserDao {
		
	@Autowired RegisterUserRepo registerUserRepo;
	public void registerUser(RegisterUser user) {
		registerUserRepo.save(user);
	}
}
