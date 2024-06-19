package com.teklab.framework.utilities.apiiutils;

import java.net.MalformedURLException;
import java.net.URL;
import org.json.simple.JSONObject;

import com.teklab.framework.utilities.reportmanagers.Log4jManager;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import static org.hamcrest.Matchers.*;

public class Endpoint {

	private RequestSpecification requestSpecification;
	private Response response;
//	private String endpointUrl;
	private static String baseAPIUrl = "https://reqres.in"; // please provide your company's base URI

	public enum RequstMethod { // RequestMethod
		GET, POST, PUT, DELETE // Endpoint.RequestMethod.GET
	}

	public Endpoint() { // constructor
		requestSpecification = given().contentType(ContentType.JSON);
		// could also add authentication here as well
	}

	public RequestSpecification setHeader() {
		// String token = "<your api key goes here>";
		// String tokenKey = "X-Auth-Token";
		// Header header = new Header(tokenKey, token);
		// requestSpecification.header(header);
		return requestSpecification;
	}

	// Use in with Post Request. Put request //add new information to our request
	public RequestSpecification setRequestBody(JSONObject requestParams) {
		return requestSpecification.body(requestParams.toJSONString());
	}

	// public RequestSpecification sendRequest(String endpointUrl, RequstMethod
	// requestMethod)
	public Response sendRequest(String pathUrl, RequstMethod requestMethod) {

		try {
//			String baseAPIUrl = "https://reqres.in";    
			URL endpointAPIUrl = new URL(String.format("%s%s", baseAPIUrl, pathUrl));

			switch (requestMethod) {
			case GET:
				response = requestSpecification.when().get(endpointAPIUrl);
				break;
			case POST:
				response = requestSpecification.when().post(endpointAPIUrl);
				break;
			case PUT:
				response = requestSpecification.when().put(endpointAPIUrl);
				break;
			case DELETE:
				response = requestSpecification.when().delete(endpointAPIUrl);
				break;
			}
		} catch (MalformedURLException e) {
			Log4jManager.error("Error occured when sending api request");
//				e.printStackTrace();
		}

		// return requestSpecification;
		return response;
	}

	public ValidatableResponse readResponse() {
		return response.then();

	}

	public Response getResponse() {
		return response;
	}

//		public String getEndpointUrl() {
//			return endpointUrl;
//		}

	// Assertion methods
	public void verifySatusCode(int code) {
		readResponse().assertThat().statusCode(code);
	}

	public void verifyPathValue(String path, String expectedvalue) {

		readResponse().assertThat().body(path, equalTo(expectedvalue));

	}

	// method overloading
	public void verifyPathValue(String path, int expectedvalue) {
		response.then().assertThat().body(path, equalTo(expectedvalue));
	}

	// verify response time

}
