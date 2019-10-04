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
		if(user == null) {
			return false;
		}
		if(password.equals(user.getPassword())) {
			return true;
		}
		return false;
	}
	
	public UserDetail getUserDetailsByToken(String authToken) {
		UserDetail userDetail = userDetailService.getUserDetail(authToken);
		if(userDetail != null && (userDetail.getCreatedTime() + userDetail.getExpiry() > System.currentTimeMillis())) {
			return userDetail;
		}
		return null;
	}
	
	public UserDetail getUserDetailsByUsername(String username) {
		User user = userDao.getUserByEmail(username);
		UserDetail userDetail = userDetailService.getUserDetail(user.getId());
		return userDetail;
	}
}
