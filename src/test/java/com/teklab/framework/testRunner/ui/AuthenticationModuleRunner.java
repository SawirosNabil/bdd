package com.teklab.framework.testRunner.ui;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)	
@CucumberOptions(
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber-report.json"},
		monochrome = true,		 
		features="src/test/resources/features/UI/authentication",
		glue={"com.teklab.framework.steps.ui", "com.teklab.framework.bases.ui"},
		tags= "@uiRegression",
//		publish = true,  // enable cucumber publish report, could also configure via cucumber.properties
//		tags= "@Authentication or @SignUp",
		dryRun= false// dryrun true: run feature without java implementation/ steps
		
)
public class AuthenticationModuleRunner {

}
