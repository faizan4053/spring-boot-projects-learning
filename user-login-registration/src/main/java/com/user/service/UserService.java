package com.user.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.user.dto.UserRegistrationDto;
import com.user.model.User;

public interface UserService extends UserDetailsService{
	
	User save(UserRegistrationDto registrationDto);

}
