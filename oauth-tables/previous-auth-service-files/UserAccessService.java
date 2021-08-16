package com.eldorado.authservice.services;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.eldorado.authservice.constants.AuthServiceConstants;
import com.eldorado.authservice.dto.UserCredentialsDto;
import com.eldorado.authservice.models.AuthUser;
import com.eldorado.authservice.repositories.UserRepository;

@Service
public class UserAccessService {
	
	@Value("${baseUri}")
	private String baseUri;
	
	@Autowired
	private UserRepository userRepository;

	public ResponseEntity<String> getAccessToken(UserCredentialsDto userCredentials) {
		
		ResponseEntity<String> response = null;
		AuthUser user = userRepository.findByEmail(userCredentials.getUserName());
		System.out.println(user);
		
		if(user.getCreatedDateTime()!=null && Duration.between(user.getCreatedDateTime(), LocalDateTime.now()).toDays()>=90)
		{
			user.setAccountNonExpired(false);
			userRepository.save(user);
			response=new ResponseEntity<String>(userCredentials.getUserName()+" your password is expired",HttpStatus.BAD_REQUEST);
            return response;
            
		}
		
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("username", userCredentials.getUserName());
		body.add("password", userCredentials.getPassword());
		body.add("grant_type", "password");
		
		

		String credentials = AuthServiceConstants.CLIENT_ID+":"+AuthServiceConstants.CLIENT_PASSWORD;
		String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Basic " + encodedCredentials);

		HttpEntity<?> request = new HttpEntity<Object>(body, headers);
		String access_token_url = baseUri+"oauth/token";
		response = restTemplate.exchange(access_token_url, HttpMethod.POST, request, String.class);
		return response;
	}
	
}
