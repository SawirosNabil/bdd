package com.teklab.framework.testRunner.api;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)	
@CucumberOptions(
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber-report.json"},
		monochrome = true,		  
		features="src/test/resources/features/API/authentication",
		glue={"com.teklab.framework.steps.api", "com.teklab.framework.bases.api"},
		tags= " @APIRegression",
		dryRun= false// dryrun true: run feature without java implementation/ steps
	
)
public class IDServiceRunner {

}
