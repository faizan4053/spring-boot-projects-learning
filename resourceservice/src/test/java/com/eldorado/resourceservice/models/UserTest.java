package com.eldorado.resourceservice.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
 * Test for AuthUser Pojo Class
 */

public class UserTest {
	
	/*
	 * Object of type AuthUser
	 */
	private AuthUser user;
	
	/*
	 * Object of type PasswordEncoder
	 */
	
	private PasswordEncoder passwordEncoder;
	
	/*
	 * Initializing passwordEncoder and user objects 
	 * before each test case 
	 */
	
	@BeforeEach
	public void  setUser() {
		passwordEncoder=new BCryptPasswordEncoder();
		user=new AuthUser();
		user.setFirstName("Mohammad");
		user.setLastName("Faizan");
		user.setEmail("faizan@gmail.com");
		user.setPassword(passwordEncoder.encode("faizan@123"));
		
	}
	
	/*
	 * Testing getFirstName() function
	 */
	
	@Test
	public void testFirstName() {
		String expected="Mohammad";
		String actual=user.getFirstName();
		assertEquals(expected, actual);
	}
	
	/*
	 * Testing getLastName() function
	 */
	
	@Test
	public void testLastName() {
		String expected="Faizan";
		String actual=user.getLastName();
		assertEquals(expected, actual);
	}
	
	/*
	 * Testing getEmail() function
	 */
	
	@Test
	public void testEmail() {
		String expected="faizan@gmail.com";
		String actual=user.getEmail();
		assertEquals(expected, actual);
	}
	
	/*
	 * Testing getPassword() function
	 */

	@Test
	public void testPassword() {
		String expected=passwordEncoder.encode("faizan@123");
		String actual=user.getPassword();
		assertNotEquals(expected, actual);
	}
	
}
