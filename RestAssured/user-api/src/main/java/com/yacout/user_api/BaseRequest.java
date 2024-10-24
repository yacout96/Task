package com.yacout.user_api;

import java.util.HashMap;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIConstants;

public abstract class BaseRequest {
	protected String baseUrl;
	protected Map<String, String> headers;
	protected Map<String, String> cookies;
	protected APIConstants constants;

	public BaseRequest() {
		constants = new APIConstants();
		this.baseUrl = constants.baseURL;
		headers = new HashMap<String, String>();
		cookies = new HashMap<String, String>();
		headers.put("content-type", "application/json");
		headers.put("sec-fetch-mode", "cors");
		headers.put("sec-fetch-site", "same-origin");
		headers.put("x-requested-with", "XMLHttpRequest");
	}

	public void setHeader(String name, String value) {
		headers.put(name, value);
	}

	public void setCookie(String name, String value) {
		cookies.put(name, value);
	}

	// Create the POST/GET requests adding any necessary headers/cookies
	public Response send(String method, String endpoint, Object body) {
		RequestSpecification postRequest = RestAssured.given().baseUri(baseUrl).headers(headers).cookies(cookies);
		RequestSpecification getRequest = RestAssured.given().baseUri(baseUrl);

		switch (method) {
		case "GET":
			return getRequest.get(endpoint).then().extract().response();
		case "POST":
			postRequest.body(body);
			return postRequest.redirects().follow(false).post(endpoint).then().extract().response();
		default:
			throw new IllegalArgumentException("Invalid HTTP method: " + method);
		}
	}

	// Extract login token from valid login request
	public String extractToken(Response res) {
		return res.jsonPath().getString("token");
	}
}