package org.api;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AuthAdactin extends BaseClass{

	@Test
	public void login() throws FileNotFoundException, IOException {

		addHeader("Content-Type", "application/json");
		basicAuth(getpropertyFileValue("username"),getpropertyFileValue("password"));
		Response response = requestType("POST", "https://www.facebook.com/");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);
	}
	
}
