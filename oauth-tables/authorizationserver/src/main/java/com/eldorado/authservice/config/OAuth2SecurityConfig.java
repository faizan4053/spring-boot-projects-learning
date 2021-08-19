package com.eldorado.authservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*
 * OAuth2SecurityConfig is extending WebSecurityConfigurerAdapter
 * to override AuthenticationManager as bean
 */
@Configuration
public class OAuth2SecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*
	 * Bean for AuthenticationManager
	 */
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	/*
	 * AuthenticationManager BCryptPasswordEncoder
	 */
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
