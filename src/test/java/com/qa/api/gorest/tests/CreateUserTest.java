/**
 * 
 */
package com.qa.api.gorest.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.api.gorest.pojo.User;
import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.ExcelUtil;

import io.restassured.response.Response;

/**
 * @author anand acharya
 *
 */
public class CreateUserTest {

	String baseURI = "https://gorest.co.in";
	String basePath = "/public-api/users";
	String token = "hIHC07GrXLjsaU2zOjeLS9nzcUwvHy0cDq6G";
	
	@DataProvider
	public Object[][] getUserData(){
		Object userData[][] = ExcelUtil.getTestData("userdata");
		return userData;
	}
	
	@Test(dataProvider = "getUserData")
	public void createUserAPIPOSTTest(String firstname, String lastname, String gender, String dob, String email, 
			String phonenumber, String website, String address, String status){
//		User user = new User("andy","downunder","male","01-01-1990","andydownunder@gmail.com","+61-040411425","https://www.downunder.com",
//				"test address Sydney","active");
		User user = new User(firstname, lastname, gender, dob, email, phonenumber, website, address, status);
		
		Response response = RestClient.doPost("JSON", baseURI, basePath, token, null, true, user); //to get obj we need to create pojo class
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		System.out.println("================================================");
	}
}
