package com.outh2demo.controller;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.outh2demo.controller.dto.UserDto;
import com.outh2demo.model.AuthUser;
import com.outh2demo.repository.UserRepo;
import com.outh2demo.repository.UserRoleRepo;


@RestController
@RequestMapping("/oauth/users")
public class UserController {
	
	@Autowired
	private UserRepo userRepo;
	
	
	@Autowired
	private UserRoleRepo roleRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping
	public AuthUser register(@RequestBody UserDto userDto) {
		
		AuthUser user=new ObjectMapper().convertValue(userDto, AuthUser.class);
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setRoles(Collections.singletonList(roleRepo.findByRoleNameContaining("USER")));
		
		Optional<AuthUser> optUser=userRepo.findByUserNameOrEmail(userDto.getUserName(), userDto.getEmail());
		if(!optUser.isPresent())
			return userRepo.save(user);
		
		throw new RuntimeException("User is already registered !");
	}
}
