package com.teklab.framework.pages.api.c_pages.authentication;

import org.json.simple.JSONObject;

import com.teklab.framework.bases.api.APIPageBase;
import com.teklab.framework.pages.api.i_pages.authentication.IsignInComponent;

import com.teklab.framework.utilities.reportmanagers.Log4jManager;
import com.teklab.framework.utilities.apiiutils.Endpoint;

public class CsignInComponent extends APIPageBase implements IsignInComponent {

	public void signInService(String emailValue, String pwValue) {
		

		JSONObject obj = new JSONObject();
		obj.put("email", emailValue);
		obj.put("password", pwValue);
		apiHelper.setRequestBody(obj);
		apiHelper.sendRequest("/api/login", Endpoint.RequstMethod.POST);

		Log4jManager.info("Made the API call to the log in service");
	}

	@Override
	public void verify(int statusCode, String expectedValue) {
		
		apiHelper.verifySatusCode(statusCode);
		apiHelper.verifyPathValue("token", expectedValue);

		Log4jManager.info("verified status code and " + " the token to be : " + expectedValue);
	}












}
