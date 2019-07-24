package com.basic.quizapp.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequest {
	
	private String Id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String mobileNumber;
	private String password;
	private String gender;
	
}
