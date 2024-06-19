package com.teklab.framework.utilities.WebActionUtils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementActions {

   private WebDriver driver; 

   public ElementActions(WebDriver outsideDriver) {driver= outsideDriver;}
   
	public void sendText(By locator,String text) {WebDriverWait wait= new WebDriverWait(driver, Duration.ofMillis(2000));

   WebElement element= null;
   try {element= wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    element.sendKeys(text);

}    catch (Exception e) {System.out.println("log: failed to send text to element using this locator:"+locator);}


	}

	
	
   public void highlight(By locator) {		//for teaching purpose
		JavascriptExecutor js = (JavascriptExecutor) driver;   
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(2));
		
		WebElement element = null;
		
		try  {element= wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		}catch (Exception e) {System.out.println("Error: failed to highlight this element using "+locator);
	}

}















































}
