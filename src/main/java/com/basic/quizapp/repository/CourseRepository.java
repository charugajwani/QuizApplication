package com.basic.quizapp.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.basic.quizapp.entity.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Serializable>{

	public Course findById(Long id);
	
}
