package com.outh2demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.outh2demo.model.AuthUser;
import com.outh2demo.repository.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<AuthUser> optUser=userRepo.findByUserName(userName);
		if(optUser.isPresent()) {
			AuthUser user=optUser.get();
			 
			List<SimpleGrantedAuthority> roles=user.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getRoleName()))
				.collect(Collectors.toList());
			
			return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),roles);
		}
		
		throw new UsernameNotFoundException("UserName is not present");
		
	}
	

}
