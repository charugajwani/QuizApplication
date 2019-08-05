package com.basic.quizapp.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.basic.quizapp.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Serializable>{

	public User findByEmail(String email);
}
