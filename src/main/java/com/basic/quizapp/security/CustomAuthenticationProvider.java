package com.basic.quizapp.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.basic.quizapp.entity.UserDetail;
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
        	UserDetail userDetail = securityService.getUserDetails(username);
        	Collection<GrantedAuthority> authorities = new ArrayList<>();
        	authorities.add(new SimpleGrantedAuthority(userDetail.getRole()));
            return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), authorities);
        } else {
        	throw new BadCredentialsException("Invalid Credentials");
        }
    }
 
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
