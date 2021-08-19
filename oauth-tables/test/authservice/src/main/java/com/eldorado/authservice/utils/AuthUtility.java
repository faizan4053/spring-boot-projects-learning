//package com.eldorado.authservice.utils;
//
//import static io.restassured.RestAssured.given;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//
//public class AuthUtility {
//	
//	public static String CLIENT_ID = "couponclientapp";
//	public static String CLIENT_SECRET = "9999";
//	public static String SCOPES = "";
//	public static String USER_NAME = "doug@123.com";
//	public static String PASSWORD = "doug";
//	public static String BASE_URI = "http://localhost:9092";
//	
//	public String getAccessToken() throws JSONException {
//
//		Response response = given().auth().preemptive().basic(CLIENT_ID, CLIENT_SECRET)
//				.contentType("application/x-www-form-urlencoded").log().all().formParam("grant_type", "password")
//				.formParam("username", USER_NAME).formParam("password", PASSWORD).when()
//				.post(BASE_URI + "/oauth/token");
//
//		JSONObject jsonObject = new JSONObject(response.getBody().asString());
//		String accessToken = jsonObject.get("access_token").toString();
//		return accessToken;
//	}
//
//}
