package com.basic.quizapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.basic.quizapp.dao.UserDetailDao;
import com.basic.quizapp.entity.UserDetail;

@Service
@Transactional
public class UserDetailService {

	@Autowired private UserDetailDao userDetailDao;
	
	public UserDetail getUserDetail(Long userId) {
		return userDetailDao.getUserDetails(userId);
	}
}
