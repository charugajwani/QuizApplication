package com.basic.quizapp.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionRequest {
	
	private String id;
	
	private String questionDescription;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String correctOption;
	private String courseId;
	
}
