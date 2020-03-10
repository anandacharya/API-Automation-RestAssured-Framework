/**
 * 
 */
package com.qa.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.qa.api.gorest.restclient.RestClient;

import io.restassured.response.Response;

/**
 * @author anand acharya
 *
 */
public class GetUserTest {

	String baseURI = "https://gorest.co.in";
	String basePath = "/public-api/users";
	String token = "hIHC07GrXLjsaU2zOjeLS9nzcUwvHy0cDq6G";
	
	@Test (priority=1)
	public void getAllUserListAPITest(){
		Map<String, String> authTokenMap = new HashMap<String, String>();
		authTokenMap.put("Authorizarion", "Bearer "+token);
		Response response = RestClient.doGet("JSON", baseURI, basePath, authTokenMap, null, true);
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
	}
	
	@Test (priority=2)
	public void getUserWithQueryParamsAPITest(){
		Map<String, String> authTokenMap = new HashMap<String, String>();
		authTokenMap.put("Authorizarion", "Bearer "+token);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("first_name", "John");
		params.put("gender", "male");
		
		Response response = RestClient.doGet("JSON", baseURI, basePath, authTokenMap, params, true);
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
	}
}
