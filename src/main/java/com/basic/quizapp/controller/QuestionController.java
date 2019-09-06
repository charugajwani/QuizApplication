package com.basic.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basic.quizapp.entity.Question;
import com.basic.quizapp.request.QuestionRequest;
import com.basic.quizapp.service.QuestionService;

@RestController
@RequestMapping("/quizApp")
public class QuestionController {
	 
	@Autowired QuestionService questionService;
	
	@PostMapping("/submitQuestion")
	public String submitQuestion(@RequestBody QuestionRequest questionRequest) {
		questionService.submitQuestion(questionRequest);
		return "Question submitted succesfully";
	}
	
	@GetMapping("/getQuestions")
	public List<Question> getQuestions(){
		return questionService.getQuestions();
	}
}
