package com.basic.quizapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.quizapp.dao.UserDao;
import com.basic.quizapp.entity.User;
import com.basic.quizapp.entity.UserDetail;

@Service
public class SecurityService {

	@Autowired private UserDao userDao;
	@Autowired private UserDetailService userDetailService;
	
	public boolean validatePassword(String username, String password) {
		User user = userDao.getUserByEmail(username);
		if(password.equals(user.getPassword())) {
			return true;
		}
		return false;
	}
	
	public UserDetail getUserDetails(String username) {
		User user = userDao.getUserByEmail(username);
		UserDetail userDetail = userDetailService.getUserDetail(user.getId());
		return userDetail;
	}
}
