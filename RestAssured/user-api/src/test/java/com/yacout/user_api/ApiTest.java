package com.yacout.user_api;

import static org.junit.Assert.assertThat;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import resources.APIConstants;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ApiTest {
	APIConstants constants = new APIConstants();

    @Test //Ping Base URL
    public void PingBaseURL() {
    	PingRequest request = new PingRequest();
        Response response = request.send("");

        assertThat(response.getStatusCode(), is(200));
    }
    
    @Test //Ping /whoami endpoint
    public void pingWhoAmI() {
    	WhoAmIRequest request =  new WhoAmIRequest();
		Response response = request.send();
        System.out.print(response.body().asPrettyString());
        assertThat(response.getStatusCode(), is(200));
    }

    @Test //Try login with invalid Email
    public void inValidEmailLoginRequest() {
    	LoginRequest request = new LoginRequest(constants.inValidEmail,constants.validPassword);
        Response response = request.send();

        System.out.print(response.body().asPrettyString());
        assertThat(response.getStatusCode(), is(401));
		assertThat(response.jsonPath().getString("message"), equalTo(constants.incorrectCredentialsError));
    }
    
    @Test //Try login with invalid password
    public void inValidPasswordLoginRequest() {
    	LoginRequest request = new LoginRequest(constants.validEmail,constants.inValidPassword);
        Response response = request.send();

        System.out.print(response.body().asPrettyString());
        assertThat(response.getStatusCode(), is(401));
		assertThat(response.jsonPath().getString("message"), equalTo(constants.incorrectCredentialsError));
    }

	@Test //Try login with valid login
	public void validLoginRequest() {
		LoginRequest request = new LoginRequest(constants.validEmail,constants.validPassword );
		Response response = request.send();

		assertThat(response.getStatusCode(), is(200));
		assertThat(response.jsonPath().getString("token"), equalTo(constants.merchantUserSuccessToken));
	}
	
    @Test //Try many invalid requests
    public void blockLoginTooManyRequests() {
    	LoginRequest request = new LoginRequest(constants.inValidEmail2,constants.validPassword);
    	Response response = null;
    	for(int i = 0; i < 10; i++) {
    		response = request.send();
    	}

        assertThat(response.getStatusCode(), is(429));
        assertThat(response.getBody().asString(), containsString(constants.tooManyIncorrectPasswordsError));
    }
    

}