package com.teklab.framework.steps.api.authentication;

import com.teklab.framework.pages.api.c_pages.authentication.CregisterComponent;
import com.teklab.framework.pages.api.c_pages.authentication.CsignInComponent;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ID_Steps {
	
	CregisterComponent r1 = new  CregisterComponent();
	 CsignInComponent   s1 = new CsignInComponent();
	 
	
	
	
	@Given("Execute the registration service with email {string} and password {string}")
	public void execute_the_registration_service_with_email_and_password(String emailValue, String pwValue) {
	   r1.registerService(emailValue, pwValue);
	}

	@When("Sign in with email {string} and password {string}")
	public void sign_in_with_email_and_password(String emailValue, String pwValue) {
	   s1.signInService(emailValue, pwValue);
	}

	@Then("Validate the token is {string}")
	public void validate_the_token_is(String expectedToken) {
	   s1.verify(200, expectedToken);
	}
}
