package com.eldorado.authservice.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import com.eldorado.authservice.dto.RefreshTokenDto;
import com.eldorado.authservice.dto.UserCredentialsDto;

class UserAccessServiceTest {

	/**
	 * Testing UserAccessToken in UserAccessService
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 */
	
	@Test
	void testUserAccesToken() throws JsonGenerationException, JsonMappingException, IOException {
		UserAccessService userAccessService;
		userAccessService = mock(UserAccessService.class);

		UserCredentialsDto userCredentials = new UserCredentialsDto();
		userCredentials.setUserName("faiz@123.com");
		userCredentials.setPassword("doug");

		ResponseEntity<String> response = null;

		when(userAccessService.getAccessToken(userCredentials)).thenReturn(response);
		userAccessService.getAccessToken(userCredentials);
		verify(userAccessService).getAccessToken(userCredentials);
	}

	@Test
	void testUserRefreshToken() throws JsonGenerationException, JsonMappingException, IOException {
		UserAccessService userAccessService;
		userAccessService = mock(UserAccessService.class);

		RefreshTokenDto refreshToken = new RefreshTokenDto();
		refreshToken.setRefreshToken(
				"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiY291cG9uc2VydmljZSJdLCJ1c2VyX25hbWUiOiJmYWl6QDEyMy5jb20iLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiYXRpIjoiNWRlYmI0Y2MtYWNlMi00ZWM5LWE5ZWItZjRmNTFmNjk3OTEwIiwiZXhwIjoxNjI4NDgzMDYxLCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIl0sImp0aSI6ImIxM2U0MGY3LWExZWYtNGY4Mi05ZTAzLTE3ZTFlZTJlNGQyMyIsImNsaWVudF9pZCI6ImNvdXBvbmNsaWVudGFwcCJ9.iHMC8O3z3Nu7R0Tgg4iZV4tgwvYLQ2sDR0CZfg4xpPg");
		ResponseEntity<String> response = null;

		when(userAccessService.getRefreshToken(refreshToken)).thenReturn(response);
		userAccessService.getRefreshToken(refreshToken);
		verify(userAccessService).getRefreshToken(refreshToken);
	}
}
