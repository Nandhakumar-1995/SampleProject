package org.api;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Integration extends BaseClass{
	
	@Test(priority=3)
	public void getUser() {
		
		addHeader("Content-Type", "Application/json");
		queryParam("page", "2");
		Response response = requestType("GET", "https://reqres.in/api/users?page=2");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		ResponseBody body = getResponseBody(response);
		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);

	}

	@Test(priority=1)
	public void postUser() {
		
		addHeader("Content-Type", "Application/json");
		addBody("{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"leader\"\r\n" + 
				"}");
		Response response = requestType("POST", "https://reqres.in/api/users");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		ResponseBody body = getResponseBody(response);
		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);

	}
	
	@Test(priority=2)
	public void putUser() {
		
		addHeader("Content-Type", "Application/json");
		addBody("{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"zion resident\"\r\n" + 
				"}");
		requestType("POST", "https://reqres.in/api/users/2");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		ResponseBody body = getResponseBody(response);
		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);

	}
		
	@Test(priority=4)
	public void deleteUser() {

		addHeader("Content-Type", "Application/json");
		requestType("DELETE", "https://reqres.in/api/users/2");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);
	}
	
	

}
