package org.api;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	RequestSpecification reqSpec;
	Response response;
	
	public void addHeader(String key, String value) {

		reqSpec = RestAssured.given().header(key, value);
	}
	
	public void basicAuth(String userName, String password) {

		reqSpec = reqSpec.auth().preemptive().basic(userName, password);
	}
	
	public void queryParam(String key, String value) {

		reqSpec = reqSpec.queryParams(key, value);
	}
	
	public void pathParam(String key, String value) {

		reqSpec = reqSpec.pathParams(key, value);
	}
	
	public void addBody(String reqBody) {

		reqSpec = reqSpec.body(reqBody);
	}
	
	public Response requestType(String reqType, String endPoint) {

		switch (reqType) {
		case "GET":
			response = reqSpec.get(endPoint);
			break;
			
		case "POST":
			response = reqSpec.post(endPoint);
			break;
			
		case "PUT":
			response = reqSpec.put(endPoint);
			break;
			
		case "DELETE":
			response = reqSpec.delete(endPoint);
			break;
			
		default:
			break;
		}
		return response;
	}
	
	public String getpropertyFileValue(String key) throws FileNotFoundException, IOException {

		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir")+ "\\config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;
	}
	
	public int getStatusCode(Response response) {

		int statusCode = response.getStatusCode();
		return statusCode;
	}
	
	public ResponseBody getResponseBody(Response response) {

		ResponseBody responseBody = response.getBody();
		return response;
	}
	
	public String getResBodyAsString(Response response) {

		String asString = getResponseBody(response).asString();
		return asString;
	}
	
	public String getResBodyAsPrettyString(Response response) {

		String asPrettyString = getResponseBody(response).asPrettyString();
		return asPrettyString;
	}
}

