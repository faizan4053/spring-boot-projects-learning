package com.eldorado.resourceservice;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.response.Response;

@SpringBootTest
@AutoConfigureMockMvc
class ResourceserviceApplicationTests {

	/*
	 * Initializing constanst related to Oauth token generation
	 */

	public static String CLIENT_ID = "couponclientapp";
	public static String CLIENT_SECRET = "9999";
	public static String SCOPES = "";
	public static String USER_NAME = "faizan@mohd.com";
	public static String PASSWORD = "john";
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
	 * Testing for token generation from auth server
	 */
	@Test
	 void testOAuthTokenGenerationCode() throws JSONException {

		String accessToken = getAccessToken();
		System.out.println(accessToken);
		assertNotNull(accessToken);

	}
	
	/*
	 * Testing dummy end point for testing 
	 * token validation
	 */

	@Test
	void testCouponApiCouponsEndPointForTokenValidation() throws JSONException {
		String accessToken = getAccessToken();
		System.out.println("token " + accessToken);
		given().header("Authorization", "Bearer " + accessToken).when()
				.get("http://localhost:9091/couponapi/coupons/SUPERSALE5").then().statusCode(200);
	}
	
	/*
	 * Testing dummy end point for testing 
	 * token validation
	 */

	@Test
	 void testCouponApiCouponsEndPointWithOutValidCoupon() throws JSONException {
		String accessToken = "tokenIsNotPresent";
		System.out.println("token " + accessToken);
		given().header("Authorization", "Bearer " + accessToken).when()
				.get("http://localhost:9091/couponapi/coupons/SUPERSALE5").then().statusCode(401);
	}
	
}
