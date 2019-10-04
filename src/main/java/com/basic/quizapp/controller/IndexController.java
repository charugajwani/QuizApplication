package com.basic.quizapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.basic.quizapp.entity.UserDetail;
import com.basic.quizapp.service.SecurityService;
import com.basic.quizapp.util.SessionVariables;

@RestController
public class IndexController {
	
	@Autowired private HttpServletRequest request;
	@Autowired private SecurityService securityService;
	
	@GetMapping("/")
	public ModelAndView homeView() {
		return new ModelAndView("homepage");
	}
	
	@GetMapping("/login") 
	public ModelAndView login(){
		return new ModelAndView("loginPage");
	}
	
	@GetMapping("/homepage")
	public ModelAndView homePage(){
		return new ModelAndView("homepage");
	}
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@GetMapping("/authToken")
	public JSONObject getAuthToken() {
		JSONObject obj = (JSONObject) new JSONObject();
		obj.put(SessionVariables.AUTH_TOKEN, (String) request.getSession().getAttribute(SessionVariables.AUTH_TOKEN));
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/isLoggedIn")
	public JSONObject isLoggedIn(@RequestParam("authToken") String authToken) {
		UserDetail ud = securityService.getUserDetailsByToken(authToken);
		JSONObject obj = new JSONObject();
		if(ud != null) {
			obj.put("isLoggedIn", "true");
		} else {
			obj.put("isLoggedIn", "false");
		}
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/loginFailed")
	public JSONObject loginFailed() {
		JSONObject obj = (JSONObject) new JSONObject();
		obj.put("error", "Invalid Credentials");
		return obj;
	}
	
	@GetMapping("/ui/**")
	public ModelAndView reactUI() {
		return new ModelAndView("homepage");
	}
	
}
