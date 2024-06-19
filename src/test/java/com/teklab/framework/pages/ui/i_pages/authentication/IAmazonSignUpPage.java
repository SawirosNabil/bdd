package com.teklab.framework.pages.ui.i_pages.authentication;

import org.openqa.selenium.By;

import com.teklab.framework.bases.ui.IPageBase;

public interface IAmazonSignUpPage extends IPageBase {


	//locators for your page object classes
		By name = By.xpath(document.selectSingleNode("//SignUpPage/name").getText() );
		By email =  By.xpath(document.selectSingleNode("//SignUpPage/email").getText() );
		By firstPassword = By.xpath(document.selectSingleNode("//SignUpPage/firstPw").getText() );
		
		
		public void goToSignUpPage() ;
		public void enterSignUpContent(String theName, String emailValue, String pw);
		public void verifyTitle( String expectedTitle);



















}
