package com.basic.quizapp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.basic.quizapp.security.CustomAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter {
 
	@Autowired private CustomAuthenticationProvider authProvider;
	
	@Autowired private CustomWebAuthenticationDetailsSource customAuthDetailSource;
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
          .authorizeRequests().antMatchers("/doLogin").permitAll()
          .anyRequest()
          .authenticated()
          .and()
          .formLogin().loginPage("/login").permitAll()
          .authenticationDetailsSource(customAuthDetailSource)
          .loginProcessingUrl("/doLogin");
//          .defaultSuccessUrl("/homepage", true)
//          .and()
//          .httpBasic();
    }
}
