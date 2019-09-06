package com.basic.quizapp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.quizapp.dao.UserDao;
import com.basic.quizapp.dao.UserDetailDao;
import com.basic.quizapp.entity.User;
import com.basic.quizapp.entity.UserDetail;
import com.basic.quizapp.request.RegisterUserRequest;

@Service
@Transactional
public class UserService {

	@Autowired UserDao userDao;
	@Autowired UserDetailDao userDetailDao;
	
	public void registerNewUser(RegisterUserRequest newUserInfo) {
		User user = new User();
		user.setFirstName(newUserInfo.getFirstName());
		user.setMiddleName(newUserInfo.getMiddleName());
		user.setLastName(newUserInfo.getLastName());
		user.setEmail(newUserInfo.getEmail());
		user.setGender(newUserInfo.getGender());
		user.setPassword(newUserInfo.getPassword());
		user.setMobileNumber(Long.parseLong(newUserInfo.getMobileNumber()));
		
		user = userDao.registerUser(user);
		
		UserDetail userDetail = new UserDetail();
		userDetail.setRole("ROLE_USER");
		userDetail.setUser(user);
		userDetailDao.saveUserDetail(userDetail);
	}
}
