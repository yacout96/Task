package com.yacout.user_api;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;

public class LoginRequest extends BaseRequest {

    private String email;
    private String password;

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Set email and password, append login endpoint to baseurl and send to super
    public Response send() {
        Map<String, Object> credentials = new HashMap<>();
        credentials.put("password", password);
        credentials.put("email", email);

        return super.send("POST", constants.loginEndpoint, credentials);
    }
}