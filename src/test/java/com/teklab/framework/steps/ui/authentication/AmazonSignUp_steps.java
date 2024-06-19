package com.teklab.framework.steps.ui.authentication;

import com.teklab.framework.pages.ui.c_pages.authentication.CAmazonSignUpPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonSignUp_steps {

	CAmazonSignUpPage c1 = new CAmazonSignUpPage();

	@Given("User goes to Amazon sign up page")
	public void user_goes_to_amazon_sign_up_page() {
		c1.goToSignUpPage();
	}

	@When("User enter personal information")
	public void user_enter_personal_information() {
		c1.enterSignUpContent("JayC", "jayCteklab@gmail.com", "jfkjweskflje18721q4673264sjlfh");
	}

	@Then("User should be able to verify something")
	public void user_should_be_able_to_verify_something() {
		c1.verifyTitle("Amazon Registration");
	}

	@When("User click the privacy link")
	public void user_click_the_privacy_link() {

	}

	@Then("User should verify something and highlight headline")
	public void user_should_verify_something_and_highlight_headline() {

	}

}
