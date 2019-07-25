package com.basic.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.basic.quizapp.entity.Course;
import com.basic.quizapp.request.CourseRequest;
import com.basic.quizapp.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired CourseService courseService;
	
	@PostMapping("/submitCourse")
	public String submitCourse(@RequestBody CourseRequest courseRequest) {
		courseService.submitCourse(courseRequest);
		return "Course submitted successfully";
	}
	
	@GetMapping("/getCourses")
	public List<Course> getCourseList() {
		return courseService.getCourseList();
	}
}
