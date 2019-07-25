package com.basic.quizapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.quizapp.entity.Question;
import com.basic.quizapp.repository.QuestionRepository;

@Service
public class QuestionDao {
	
	@Autowired QuestionRepository questionRepository;
	
	public void submitQuestion(Question question) {
		questionRepository.save(question);
	}
	
	public List<Question> getQuestions(){
		return (List<Question>) questionRepository.findAll();
	}
}
