package com.yacout.user_api;

import io.restassured.response.Response;

public class WhoAmIRequest extends BaseRequest {

	public WhoAmIRequest() {
	}

	// Append the whoami endpoint to base request and send to super
	public Response send() {
		return super.send("GET", constants.whoAmIEndpoint, "");
	}

}