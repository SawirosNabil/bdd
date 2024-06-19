package com.teklab.framework.pages.api.c_pages.authentication;

import org.json.simple.JSONObject;

import com.teklab.framework.bases.api.APIPageBase;
import com.teklab.framework.pages.api.i_pages.authentication.IregisterComponent;
import com.teklab.framework.utilities.reportmanagers.Log4jManager;
import com.teklab.framework.utilities.apiiutils.Endpoint;


public class CregisterComponent extends APIPageBase implements IregisterComponent {
	public void registerService(String emailValue, String pwValue) {
	
		
		JSONObject obj = new JSONObject();
		obj.put("email",            emailValue); 
		obj.put("password",    pwValue);
		apiHelper.setRequestBody(obj);
		apiHelper.sendRequest("/api/register", Endpoint.RequstMethod.POST);
		
		Log4jManager.info("Made the API call to the register service");
	}





}
