package com.basic.quizapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.quizapp.dao.CourseDao;
import com.basic.quizapp.entity.CourseList;
import com.basic.quizapp.request.CourseRequest;

@Service
@Transactional
public class CourseService {
	
	@Autowired CourseDao courseDao;
	
	public void submitCourse(CourseRequest courseRequest) {
		
		CourseList courseList = new CourseList();
		
		courseList.setCourseName(courseRequest.getCourseName());
		
		courseDao.submitCourse(courseList);
		
	}
	
	public CourseList getCourseById(Long id) {
		return courseDao.getCourseById(id);
	}
	
	public List<CourseList> getCourseList(){
		return courseDao.getCourseList();
	}
}
