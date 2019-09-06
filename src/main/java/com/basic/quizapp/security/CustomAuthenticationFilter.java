package com.basic.quizapp.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import com.basic.quizapp.entity.UserDetail;
import com.basic.quizapp.service.SecurityService;

@Component
public class CustomAuthenticationFilter extends GenericFilterBean {
	
	@Autowired private SecurityService securityService;
	
	RequestMatcher patterns;
	RequestMatcher excludePatterns;
	
	public CustomAuthenticationFilter() {
		patterns = new OrRequestMatcher(new AntPathRequestMatcher("/**"));
		excludePatterns = new OrRequestMatcher(new AntPathRequestMatcher("/login"));
	}
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	if(securityService==null){
            ServletContext servletContext = request.getServletContext();
            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
            securityService = webApplicationContext.getBean(SecurityService.class);
        }        
    	HttpServletRequest httpRequest = (HttpServletRequest) request;
    	if(patterns.matches(httpRequest) && !excludePatterns.matches(httpRequest) && SecurityContextHolder.getContext().getAuthentication() == null) {
    		String token = httpRequest.getHeader("authToken");
    		if(null == token) {
    			chain.doFilter(request, response);
    		} else { 
	    		UserDetail userDetail = securityService.getUserDetailsByToken(token);
	    		if(userDetail == null) {
	    			chain.doFilter(request, response);
	    		} else {
		        	List<GrantedAuthority> authorities = new ArrayList<>();
		    		authorities.add(new SimpleGrantedAuthority(userDetail.getRole()));
		    		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(token, token, authorities);
		    		SecurityContextHolder.getContext().setAuthentication(authRequest);
	    		}
    		}
    	}
    	chain.doFilter(request, response);
    }
}