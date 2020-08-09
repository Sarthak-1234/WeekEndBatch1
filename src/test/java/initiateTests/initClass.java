package initiateTests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;

import managers.PropertyFileManager;
import pages.RedBusHomePage;
import pages.pilPages;
import reporting.ExtentManager;
import reporting.ReportingClass;

public class initClass {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(initClass.class);
	
	public static WebDriver driver;
	public static ExtentReports report; //this is skelton of html report
	
	protected static RedBusHomePage homePage;
	protected static pilPages pilpage;
	
	
	@BeforeClass
	public void launchDriver() throws IOException {
		
		//This is update done in SReporting branch
		//abc
		
		driver = WebdriverLaunch.getWindowDriver();
		createPageObjects();
		report = ExtentManager.setUp("Extent_Reports");
	}
	
	//Creating objects of Pages
	public static void createPageObjects() {
		LOGGER.info("Created Objects of Pages");
		homePage = new RedBusHomePage(driver);
		pilpage = new pilPages(driver);
	}
	
	@BeforeMethod
	public void launchURL() {
		
		driver.get(System.getenv("envURL"));
		
		
		if(System.getenv("envURL").contains("qa")) {
			
		} else if (System.getenv("envURL").contains("dev")) {
			
		} else {
			
		}
		LOGGER.info("Launching Redbus home page url");
	}
	
	@AfterClass
	public void closeDriver() {
		driver.close();
		ReportingClass.putReport();
	}

}
