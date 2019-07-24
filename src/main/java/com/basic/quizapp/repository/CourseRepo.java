package com.basic.quizapp.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.basic.quizapp.entity.CourseList;

@Repository
public interface CourseRepo extends CrudRepository<CourseList, Serializable>{

	public CourseList findById(Long id);
	
}
