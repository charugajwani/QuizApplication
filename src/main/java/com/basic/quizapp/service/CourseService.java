package com.basic.quizapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.quizapp.dao.CourseDao;
import com.basic.quizapp.entity.Course;

@Service
@Transactional
public class CourseService {
	
	@Autowired CourseDao courseDao;
	
	public void submitCourse(String courseName) {
		
		Course courseList = new Course();
		
		courseList.setCourseName(courseName);
		
		courseDao.submitCourse(courseList);
		
	}
	
	public Course getCourseById(Long id) {
		return courseDao.getCourseById(id);
	}
	
	public List<Course> getCourseList(){
		return courseDao.getCourseList();
	}
}
