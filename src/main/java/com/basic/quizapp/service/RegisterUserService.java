package com.basic.quizapp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.quizapp.dao.RegisterUserDao;
import com.basic.quizapp.entity.RegisterUser;
import com.basic.quizapp.request.RegisterUserRequest;

@Service
@Transactional
public class RegisterUserService {

	@Autowired RegisterUserDao registerUserDao;
	
	public void registerNewUser(RegisterUserRequest newUserInfo) {
		RegisterUser user = new RegisterUser();
		user.setFirstName(newUserInfo.getFirstName());
		user.setMiddleName(newUserInfo.getMiddleName());
		user.setLastName(newUserInfo.getLastName());
		user.setEmail(newUserInfo.getEmail());
		user.setGender(newUserInfo.getGender());
		user.setPassword(newUserInfo.getPassword());
		user.setMobileNumber(Long.parseLong(newUserInfo.getMobileNumber()));
		
		registerUserDao.registerUser(user);
	}
}
