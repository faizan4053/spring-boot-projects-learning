package com.eldorado.authservice.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RoleTest {
	
	private Role role;
	
	
	@BeforeEach
	public void  setUser() {
		role=new Role();
		role.setId(1L);
		role.setName("USER");
	}
	
	@Test
	public void testUserRole() {
		String expected="USER";
		String actual=role.getAuthority();
		assertEquals(expected, actual);
	}
	
	
}
