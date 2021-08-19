package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.entity.Contact;
import com.user.entity.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") Long id) {
		
		User user=userService.getUser(id);
		String url="http://localhost:9002/contact/user/"+user.getId();
//		List<Contact> list=restTemplate.getForObject(url,List.class);
		
		List list=restTemplate.getForObject(url,List.class);
		
		user.setContacts(list);
		
		return user;
	}

}
