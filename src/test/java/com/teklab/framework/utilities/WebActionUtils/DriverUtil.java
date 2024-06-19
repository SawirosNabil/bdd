package com.teklab.framework.utilities.WebActionUtils;



import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.teklab.framework.bases.ui.CPageBase;
import com.teklab.framework.utilities.reportmanagers.Log4jManager;


public class DriverUtil extends CPageBase {

	public static WebDriver startBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("ie"))
				return startIEBrowser();
			else if (browserName.equalsIgnoreCase("chrome"))
				return startChromeBrowser();
			else if (browserName.equalsIgnoreCase("firefox"))
				return startFirefoxBrowser();
			else if (browserName.equalsIgnoreCase("edge"))
				return startEdgeBrowser();
			else
				throw new Exception("ERROR!! You choose '" + browserName
						+ "', Currently supporting browsers are 'IE, Chrome, Firefox and Edge browser'");
		} catch (Exception ex) {
			Log4jManager.error("something went wrong at startLocalBrowser()");
		}
		return null;
	}

	public static WebDriver startBrowserInPrivateMode(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("ie"))
				return startIEBrowser();
			else if (browserName.equalsIgnoreCase("chrome"))
				return startChromeBrowserInPrivateMode();
			else if (browserName.equalsIgnoreCase("firefox"))
				return startFirefoxBrowserInPrivateMode();
			else if(browserName.equalsIgnoreCase("edge")) {
				 return startEdgeBrowserInPrivateMdoe();
			}else
				throw new Exception("ERROR!! You choose '" + browserName
						+ "', Currently supporting browsers are 'IE, Chrome and Firefox'");
		} catch (Exception ex) {
			Log4jManager.error("something went wrong at startBrowserInPrivateMode()");
		}
		return null;
	}

	public static WebDriver startDockerContainerBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("ie"))
				return startIEBrowser();
			else if (browserName.equalsIgnoreCase("edge"))
				return startDockerContainerEdgeBrowser();
			else if (browserName.equalsIgnoreCase("chrome"))
				return startDockerContainerChromeBrowser();
			else if (browserName.equalsIgnoreCase("firefox"))
				return startDockerContainerFirefoxBrowser();
			else
				throw new Exception("ERROR!! You choose '" + browserName
						+ "', Currently supporting browsers are 'IE, Chrome and Firefox'");
		} catch (Exception ex) {
			Log4jManager.error("something went wrong at startDockerContainerBrowser()");
//			ex.printStackTrace();
		}
		return null;
	}

	private static WebDriver startChromeBrowser() {
		System.out.println("Initiating Chrome Driver");
		try {
			String driverPath = System.getProperty("user.dir") + getLocalDriverPath("chromedriver");
			System.setProperty("webdriver.chrome.driver", driverPath);
     		driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().window().maximize();
			Log4jManager.info("Successfully Initiated Chrome Driver");
		} catch (Exception ex) {
			Log4jManager.error("failed to initiate Chrome Driver");
		}
		
		return driver;
	}

	private static WebDriver startChromeBrowserInPrivateMode() {
		System.out.println("Initiating Chrome Driver");
		try {
			String driverPath = System.getProperty("user.dir") + getLocalDriverPath("chromedriver");
			System.setProperty("webdriver.chrome.driver", driverPath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("incognito");
//			options.addArguments("--remote-allow-origins=*"); //bug in chrome v111
			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
//			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			Log4jManager.info("Successfully Initiated Chrome Driver in private mode");
		} catch (Exception ex) {
			Log4jManager.error("failed to initiate Chrome Driver in private mode");
		}
		return driver;
	}

	

	private static WebDriver startFirefoxBrowser() {
		System.out.println("Initiating Firefox Driver");
		try {
			String driverPath = System.getProperty("user.dir") + getLocalDriverPath("geckodriver");
			System.setProperty("webdriver.gecko.driver", driverPath);
				
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().window().maximize();
			Log4jManager.info("Successfully Initiated Firefox Driver");
		} catch (Exception ex) {
			Log4jManager.error("failed to initiate Firefox Driver");
		}
		
		return driver;
	}

	private static WebDriver startFirefoxBrowserInPrivateMode() {
		System.out.println("Initiating Firefox Driver");
		try {
			String driverPath = System.getProperty("user.dir") + getLocalDriverPath("geckodriver");
			System.setProperty("webdriver.gecko.driver", driverPath);
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("-private");
			//options.addArguments("--remote-allow-origins=*");
			driver = new FirefoxDriver(options);
			driver.manage().deleteAllCookies();
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().window().maximize();
			Log4jManager.info("Successfully Initiated Firefox Driver in private mode");
		} catch (Exception ex) {
			Log4jManager.error("failed to initiate Firefox Driver in private mode");
		}
		
		return driver;
	}

	
	private static WebDriver startDockerContainerChromeBrowser() {
		System.out.println("Initiating Chrome Driver in Docker Container");
		try {

			ChromeOptions cap = new ChromeOptions();
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			
			// for cloud testing: browserstack, saucelab, AWS (EC2)
			// driver = new REmoteWebDriver(new URL("https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub"), cap);
			driver.manage().deleteAllCookies();
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().window().maximize();
			Log4jManager.info("Successfully Initiated Chrome Driver in Docker Container");
		} catch (Exception ex) {
			Log4jManager.error("failed to initiate Chrome Driver in Docker Container");
		}
		return driver;
	}
	
	
	private static WebDriver startDockerContainerFirefoxBrowser() {
		System.out.println("Initiating Firefox Driver in Docker Container");
		try {
			
			FirefoxOptions options = new FirefoxOptions();
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
			// for cloud testing
			// driver = new REmoteWebDriver(new URL(""https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub""), cap);
			driver.manage().deleteAllCookies();
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().window().maximize();
			Log4jManager.info("Successfully Initiated Firefox Driver in Docker Container");
		} catch (Exception ex) {
			Log4jManager.error("failed to initiate Firefox Driver in Docker Container");
		}
		return driver;
	}
	
	private static WebDriver startDockerContainerEdgeBrowser() {
		System.out.println("Initiating Edge Driver in Docker Container");
		try {
			
			EdgeOptions options = new EdgeOptions();
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
			// for cloud testing
			// driver = new REmoteWebDriver(new URL(""https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub""), cap);
			driver.manage().deleteAllCookies();
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().window().maximize();
			Log4jManager.info("Successfully Initiated Edge Driver in Docker Container");
		} catch (Exception ex) {
			Log4jManager.error("failed to initiate Edge Driver in Docker Container");
		}
		return driver;
	}
	

	private static WebDriver startEdgeBrowser() {
		System.out.println("Initiating Edge Driver");
		try {
			String driverPath = System.getProperty("user.dir") + getLocalDriverPath("msedgedriver");
			System.setProperty("webdriver.edge.driver", driverPath);
			driver = new EdgeDriver();
			driver.manage().deleteAllCookies();
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().window().maximize();
			Log4jManager.info("Successfully Initiated Edge Driver");
		} catch (Exception ex) {
			Log4jManager.error("Failed to initiated Edge Driver");
		}
		
		return driver;
	}

	private static WebDriver startEdgeBrowserInPrivateMdoe() {
		System.out.println("Initiating Edge Driver");
		try {
			String driverPath = System.getProperty("user.dir") + getLocalDriverPath("msedgedriver");
			System.setProperty("webdriver.edge.driver", driverPath);
			EdgeOptions options = new EdgeOptions();
//			options.setCapability("InPrivate", true); // works with Selenium 3
			options.addArguments("-inprivate");		// works with Selenium 4
//			options.addArguments("--remote-allow-origins=*"); //bug in chrome v111
			driver = new EdgeDriver(options);
			driver.manage().deleteAllCookies();

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().window().maximize();
			Log4jManager.info("Successfully Initiated Edge Driver");
		} catch (Exception ex) {
			Log4jManager.error("Failed to initiated Edge Driver");
		}
		return driver;
	}
	
	private static WebDriver startIEBrowser() {
		System.out.println("Initiating IE Driver");
		try {
			String driverPath = System.getProperty("user.dir") + getLocalDriverPath("IEDriverServer");
			System.setProperty("webdriver.ie.driver", driverPath);
			driver = new InternetExplorerDriver();
			driver.manage().deleteAllCookies();
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().window().maximize();
			Log4jManager.info("Successfully Initiated IE Driver");
		} catch (Exception ex) {
			Log4jManager.error("failed to initiated IE Driver");
		}
		
		return driver;
	}

	private static String getLocalDriverPath(String driverinfo) {

		return "/src/test/resources/drivers/" + driverinfo + ".exe";

	}










































}
