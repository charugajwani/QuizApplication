package com.basic.quizapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String questionDescription;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String correctOption;
	
	@ManyToOne
	private Course courseList;
	
}
