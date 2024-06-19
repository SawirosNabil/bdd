package com.teklab.framework.bases.ui;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.teklab.framework.utilities.reportmanagers.Log4jManager;
import com.teklab.framework.utilities.WebActionUtils.DriverUtil;
//import com.teklab.framework.utilities.WebActionUtils.ElementActions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class UITestBase extends CPageBase {

//	@Before					//final version, with run configuration.
	public void starUp(Scenario scenario) {
		Log4jManager.info("----------------------");
		Log4jManager.info("-----" + "Starting-" + scenario.getName() + "-----------------");
		String browser = System.getProperty("browser");
		driver = DriverUtil.startBrowser(browser);
		
//		driver = DriverUtil.startDockerContainerBrowser(browser);
//		driver = DriverUtil.startBrowserInPrivateMode(browser);
	}

	@Before							//practice
	public void startBrowserToCreatTest(Scenario scenario) {
		Log4jManager.info("----------------------");
		Log4jManager.info("-----" + "Starting-" + scenario.getName() + "-----------------");
		driver = DriverUtil.startBrowser("firefox");
	}

	@After(order = 0)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "My Screenshot");
		}

	}

}
