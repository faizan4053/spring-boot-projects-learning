package com.eldorado.authservice.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserTest {
	
	
	private AuthUser user;
	
	
	private PasswordEncoder passwordEncoder;
	
	@BeforeEach
	public void  setUser() {
		passwordEncoder=new BCryptPasswordEncoder();
		user=new AuthUser();
		user.setFirstName("Mohammad");
		user.setLastName("Faizan");
		user.setEmail("faizan@gmail.com");
		user.setPassword(passwordEncoder.encode("faizan@123"));
		
	}
	
	@Test
	public void testFirstName() {
		String expected="Mohammad";
		String actual=user.getFirstName();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testLastName() {
		String expected="Faizan";
		String actual=user.getLastName();
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void testEmail() {
		String expected="faizan@gmail.com";
		String actual=user.getEmail();
		assertEquals(expected, actual);
	}
	

	@Test
	public void testPassword() {
		String expected=passwordEncoder.encode("faizan@123");
		String actual=user.getPassword();
		assertNotEquals(expected, actual);
	}
	
}
