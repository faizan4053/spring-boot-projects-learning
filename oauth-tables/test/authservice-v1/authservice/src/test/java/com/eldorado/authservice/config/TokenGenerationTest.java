package com.eldorado.authservice.config;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import io.restassured.response.Response;

class TokenGenerationTest {

	/*
	 * Initializing constanst related to Oauth token generation
	 */

	public static String CLIENT_ID = "couponclientapp";
	public static String CLIENT_SECRET = "9999";
	public static String SCOPES = "";
	public static String USER_NAME = "doug@123.com";
	public static String PASSWORD = "doug";
	public static String BASE_URI = "http://localhost:9092";
	
	/*
	 * Method to get Access Token from Authorization 
	 * Server
	 */

	public String getAccessToken() throws JSONException {

		Response response = given().auth().preemptive().basic(CLIENT_ID, CLIENT_SECRET)
				.contentType("application/x-www-form-urlencoded").log().all().formParam("grant_type", "password")
				.formParam("username", USER_NAME).formParam("password", PASSWORD).when()
				.post(BASE_URI + "/oauth/token");

		JSONObject jsonObject = new JSONObject(response.getBody().asString());
		String accessToken = jsonObject.get("access_token").toString();
		return accessToken;
	}

	/*
	 * Testing for token generation 
	 */
	
	@Test
	 void testOAuthTokenGenerationCode() throws JSONException {

		String accessToken = getAccessToken();
		assertNotNull(accessToken);

	}
	
}
