package com.yacout.user_api;
import io.restassured.response.Response;


public class PingRequest extends BaseRequest {

    public PingRequest() {
    }

    //Pings the base URL
    public Response send(String endpoint) {
        return super.send("GET", endpoint, "");
    }
}