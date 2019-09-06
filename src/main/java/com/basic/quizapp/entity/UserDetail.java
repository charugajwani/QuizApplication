package com.basic.quizapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String role;
	@OneToOne
	private User user;
	private String authToken;
	private Long createdTime;
	private Long expiry;
}
