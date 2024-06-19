package com.teklab.framework.testRunner.ui;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)	
@CucumberOptions(
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber-report.json"},
		monochrome = true,		  
		features="src/test/resources/features/UI/news",
		glue={"com.teklab.framework.steps.ui"},
		tags= "@args",
		dryRun= false

		)	
		
		public class DataModuleRunner {

}
