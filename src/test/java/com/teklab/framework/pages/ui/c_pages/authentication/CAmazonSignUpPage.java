package com.teklab.framework.pages.ui.c_pages.authentication;

import org.junit.Assert;

import com.teklab.framework.bases.ui.CPageBase;
import com.teklab.framework.pages.ui.i_pages.authentication.IAmazonSignUpPage;
import com.teklab.framework.utilities.reportmanagers.Log4jManager;

public class CAmazonSignUpPage extends CPageBase implements IAmazonSignUpPage{

private String url = "https://www.amazon.com/rapids/register";
	
	public void goToSignUpPage() {
		// logger.createNode() ; //Cucumber does not need these extends report logger.;
		driver.get(url);
		Log4jManager.info("User landed on Amazon sign up page");
	}
	
	public void enterSignUpContent(String theName, String emailValue, String pw) {
		//send text Name
		weu.sendText(name, theName);
		weu.sendText(email, emailValue);
		weu.sendText(firstPassword, pw);
		Log4jManager.info("User entered name, email and password information");
	}
	

	public void verifyTitle( String expectedTitle) {
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expectedTitle);
		Log4jManager.info("Validate the title equals to  expected title");
	}


























}
