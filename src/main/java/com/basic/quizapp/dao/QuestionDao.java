package com.basic.quizapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.quizapp.entity.Question;
import com.basic.quizapp.repository.QuestionRepo;

@Service
public class QuestionDao {
	
	@Autowired QuestionRepo questionRepo;
	
	public void submitQuestion(Question question) {
		questionRepo.save(question);
	}
	
	public List<Question> getQuestions(){
		return (List<Question>) questionRepo.findAll();
	}
}
