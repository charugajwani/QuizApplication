package com.basic.quizapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.quizapp.entity.CourseList;
import com.basic.quizapp.repository.CourseRepo;

@Service
public class CourseDao {
	@Autowired CourseRepo courseRepo;
	
	public void submitCourse(CourseList courseList) {
		courseRepo.save(courseList);
	}
	
	public List<CourseList> getCourseList(){
		return (List<CourseList>) courseRepo.findAll();
	}
	
	public CourseList getCourseById(Long id) {
		return courseRepo.findById(id);
	}
}
