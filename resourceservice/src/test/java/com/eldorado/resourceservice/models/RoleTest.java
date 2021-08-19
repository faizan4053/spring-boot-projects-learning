package com.eldorado.resourceservice.models;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Role Test Class
 */

public class RoleTest {

	private Role role;

	/*
	 * Creating Role class Object before each test case
	 */

	@BeforeEach
	public void setUser() {
		role = new Role();
		role.setId(1L);
		role.setName("USER");
	}

	/*
	 * Testing for getAuthority() function
	 */

	@Test
	public void testUserRole() {
		String expected = "USER";
		String actual = role.getAuthority();
		assertEquals(expected, actual);
	}

	/*
	 * Testing for getName() function
	 */

	@Test
	public void testUserRoleName() {
		String expected = "USER";
		String actual = role.getName();
		assertEquals(expected, actual);
	}

}
