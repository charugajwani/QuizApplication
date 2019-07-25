package com.basic.quizapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.quizapp.entity.User;
import com.basic.quizapp.repository.UserRepository;

@Service
public class UserDao {
		
	@Autowired UserRepository userRepository;
	
	public void registerUser(User user) {
		userRepository.save(user);
	}
}
