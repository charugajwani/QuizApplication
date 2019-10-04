package com.basic.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.basic.quizapp.entity.Course;
import com.basic.quizapp.service.CourseService;

@RestController
@RequestMapping("/quizapp")
public class CourseController {
	
	@Autowired CourseService courseService;
	
	@PostMapping("/submitCourse")
	public String submitCourse(@RequestParam("courseName") String courseName) {
		courseService.submitCourse(courseName);
		return "Course submitted successfully";
	}
	
	@GetMapping("/getCourses")
	public List<Course> getCourseList() {
		return courseService.getCourseList();
	}
}
