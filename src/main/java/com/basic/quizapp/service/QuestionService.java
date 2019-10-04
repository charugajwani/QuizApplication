package com.basic.quizapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.quizapp.dao.QuestionDao;
import com.basic.quizapp.entity.Question;
import com.basic.quizapp.request.QuestionRequest;

@Service
@Transactional
public class QuestionService {
	
	@Autowired QuestionDao questionDao;
	@Autowired CourseService courseService;
	
	public void submitQuestion(QuestionRequest questionRequest) {
		Question question = new Question();
		question.setQuestionDescription(questionRequest.getQuestionDescription());
		question.setOption1(questionRequest.getOption1());
		question.setOption2(questionRequest.getOption2());
		question.setOption3(questionRequest.getOption3());
		question.setOption4(questionRequest.getOption4());
		question.setCorrectOption(questionRequest.getCorrectOption());
//		question.setCourseList(courseService.getCourseById(Long.valueOf(questionRequest.getCourseId())));
		
		questionDao.submitQuestion(question);
	}
	
	
	
	public List<Question> getQuestions(){
		return questionDao.getQuestions();
	}
}
