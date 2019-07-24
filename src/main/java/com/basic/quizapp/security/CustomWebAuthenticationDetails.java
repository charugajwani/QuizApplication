package com.basic.quizapp.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {

	private static final long serialVersionUID = -8741551691998564708L;
	private String username;
	private String password;
	
	public CustomWebAuthenticationDetails(HttpServletRequest request) {

		super(request);
		this.username = request.getParameter("username");
		this.password = request.getParameter("password");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
