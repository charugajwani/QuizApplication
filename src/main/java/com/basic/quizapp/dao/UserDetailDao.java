package com.basic.quizapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.quizapp.entity.UserDetail;
import com.basic.quizapp.repository.UserDetailRepository;

@Service
public class UserDetailDao {

	@Autowired private UserDetailRepository userDetailRepository;
	
	public UserDetail getUserDetails(Long userId) {
		return userDetailRepository.findByUserId(userId);
	}
}
