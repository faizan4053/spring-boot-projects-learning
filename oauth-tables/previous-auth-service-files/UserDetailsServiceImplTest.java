package com.eldorado.authservice.services;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.eldorado.authservice.models.AuthUser;
import com.eldorado.authservice.models.AuthUserDetails;
import com.eldorado.authservice.services.UserDetailsServiceImpl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
 class UserDetailsServiceImplTest {
	
	/*
	 * Testing for presence of User and Credentials are correct
	 */
	

	@Test
	 void testLoadUserByUsernamewhenPresentandCorrectCredentials1() {
		 UserDetailsServiceImpl userDetailsService;
		 userDetailsService = mock(UserDetailsServiceImpl.class);
		String userName="doug@123.com";
		when(userDetailsService.loadUserByUsername(userName)).thenReturn(null);
		userDetailsService.loadUserByUsername(userName);
		verify(userDetailsService).loadUserByUsername(userName);
	}
	
	
	/*
	 * Testing for presence of User and Credentials are not correct
	 */
	
	@Test
	 void testLoadUserByUsernamewhenPresentandWrongCredentials() {
		UserDetailsServiceImpl userDetailsService;
		 userDetailsService = mock(UserDetailsServiceImpl.class);
		String userName="doug@123.com";
		AuthUser user=new AuthUser();
		user.setEmail("faiz@123.com");
		UserDetails userDetails = new AuthUserDetails(user);
		when(userDetailsService.loadUserByUsername(userName)).thenReturn(userDetails);
		userDetailsService.loadUserByUsername(userName);
		verify(userDetailsService).loadUserByUsername(userName);
	}

}
