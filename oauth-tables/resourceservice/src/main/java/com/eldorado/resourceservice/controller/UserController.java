package com.eldorado.resourceservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.eldorado.resourceservice.models.AuthUser;
import com.eldorado.resourceservice.repository.UserRepository;
import com.eldorado.resourceservice.service.SecurityService;

@Controller
public class UserController {
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/showReg")
	public String showRegistrationPage() {
		return "registerUser";
	}
	
	@PostMapping("/registerUser")
	public String register(AuthUser user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		repo.save(user);
		return "login";
	}
	
	@GetMapping("/")
	public String showLoginPage() {
		return "login";
	}
	
	
	@PostMapping("/login")
	public String login(String email,String password) {
		boolean response = securityService.login(email, password);
		
		if(response) {
			System.out.println("Inside index");
			return "index";
			
		}
		System.out.println("Inside login");
		return "login";
	}

}
