package com.basic.quizapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.basic.quizapp.service.SecurityService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
 
	@Autowired private SecurityService securityService;
	
    @Override
    public Authentication authenticate(Authentication authentication) 
      throws AuthenticationException {
  
        CustomWebAuthenticationDetails customAuthDetails = (CustomWebAuthenticationDetails) authentication.getDetails();
        String username = customAuthDetails.getUsername();
        String password = customAuthDetails.getPassword();
        
        if(securityService.validatePassword(username, password)) {
            return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials());
        } else {
        	throw new BadCredentialsException("Invalid Credentials");
        }
    }
 
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
