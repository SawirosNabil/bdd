package com.teklab.framework.bases.api;

import com.teklab.framework.utilities.apiiutils.Endpoint;
import com.teklab.framework.utilities.reportmanagers.Log4jManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class APITestBase extends  APIPageBase {

@Before 
public void intializeApi(Scenario scenario) {
	Log4jManager.info("--------------------------------");
	Log4jManager.info("------"+ "Starting-  "+ scenario.getName()+"----------");

apiHelper = new Endpoint();
apiHelper.setHeader();

}

@After

public void endEachTestCaseWithL(Scenario scenario) {
apiHelper= null;

Log4jManager.info("--------------------------------");
Log4jManager.info("------"+ scenario.getName()+ "status-"+scenario.getStatus()+ "----");
Log4jManager.info("--------------------------");



}











}
