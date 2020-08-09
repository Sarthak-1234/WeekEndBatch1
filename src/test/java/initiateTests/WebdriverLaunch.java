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

import managers.PropertyFileManager;

public class WebdriverLaunch {
	
	static WebDriver driver;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WebdriverLaunch.class);
	
	public static WebDriver getWindowDriver() throws IOException {
		
		//String browserVariable= PropertyFileManager.getPropertyValue("config", "browser");
		
		
		//added through devSarthak Branch
		
		String browserVariable=System.getenv("browserName");
		
		if(browserVariable.equalsIgnoreCase("chrome")) {
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver_windows.exe");
			driver = new ChromeDriver(opt);
			LOGGER.info("Launching ChromeBrowser");
		} else if(browserVariable.equalsIgnoreCase("firefox")) {
			FirefoxOptions opt = new FirefoxOptions();
			opt.addPreference("dom.webnotifications.enabled", false);
			System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver(opt);
			LOGGER.info("Launching FirefoxBrowser");
 		} else {
 			System.out.println("Browser is not mentioned");
 		}

		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
		
		return driver;
	}
	
	
	public static void getAndroidDriver() throws IOException {
		
	}

}
