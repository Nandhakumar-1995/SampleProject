package org.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ListUser {
	
	static RequestSpecification reqSpec;
	
	public static void main(String[] args) {

		reqSpec = RestAssured.given();
		
		reqSpec = reqSpec.header("Content-Type", "application/json");
		
		reqSpec = reqSpec.queryParam("page", "2");
		
		Response response = reqSpec.get("https://reqres.in/api/users?page=2");
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		
		ResponseBody body = response.getBody();
		String asString = body.asString();
		System.out.println(asString);
		
		String asPrettyString = body.asPrettyString();
		System.out.println(asPrettyString);
	}

}
