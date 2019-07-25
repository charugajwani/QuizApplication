package com.basic.quizapp.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.basic.quizapp.entity.UserDetail;

@Repository
public interface UserDetailRepository extends CrudRepository<UserDetail, Serializable> {

	public UserDetail findByUserId(Long userId);
}
