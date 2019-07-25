package com.basic.quizapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.quizapp.entity.Course;
import com.basic.quizapp.repository.CourseRepository;

@Service
public class CourseDao {
	@Autowired CourseRepository courseRepository;
	
	public void submitCourse(Course courseList) {
		courseRepository.save(courseList);
	}
	
	public List<Course> getCourseList(){
		return (List<Course>) courseRepository.findAll();
	}
	
	public Course getCourseById(Long id) {
		return courseRepository.findById(id);
	}
}
