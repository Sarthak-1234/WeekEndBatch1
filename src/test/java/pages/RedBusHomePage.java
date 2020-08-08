package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import managers.PropertyFileManager;
import tests.RedBushomePageTest;
import utils.CommonFunctions;

public class RedBusHomePage {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RedBusHomePage.class);

	
	WebDriver driver;

	
	@FindBy(css="i.icon.icon-close")
	public WebElement safetyPopup;
	
	@FindBy(xpath="(//div[text()='View Seats'])[1]")
	public WebElement viewSeat;
	
	
	@FindBy(xpath="//canvas[@data-type='lower']")
	public WebElement busCanvas;


	//Locators for xxxx Component
	
	@FindBy(css="input#src")
	public WebElement searchFromDropDown;
	
	@FindBy(css="ul.autoFill>li")
	public List<WebElement> dropDownList;
	
	@FindBy(css="input#dest")
	public WebElement searchToDropDown;
	
	@FindBy(css="td.current.day")
	public WebElement selectDate;
	
	@FindBy(css="button#search_btn")
	public WebElement searchButton;
	
	
	//Locators for xxxx Component
	
	@FindBy(css="div.error-view>h3")
	public WebElement errorOOPS_Message;
	
	@FindBy(xpath="//a[text()='redbus']")
	public WebElement logo;
	
	
	public RedBusHomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this); //jaise hi mere page ka object waise hi mere sare webelement search and load ho jaye
	}
	
	
	public void selectCityFromDropDown() throws IOException {
		searchFromDropDown.sendKeys("Kash");
		
		
		String fromValue= PropertyFileManager.getPropertyValue("redBusHomePage", "FromDropDownValue");
				
		
		for(WebElement e: dropDownList) {
			if(e.getText().contains(fromValue)) {
				e.click();
				break;
			}
		}
		
		LOGGER.info("Entering Kash in from dropdown");
	}
	
	public void selectCityToDropDown() throws IOException {
		searchToDropDown.sendKeys("Amr");
	
		String toValue= PropertyFileManager.getPropertyValue("redBusHomePage", "ToDropDownValue");
				
				
		
		for(WebElement ee: dropDownList) {
			if(ee.getText().equalsIgnoreCase(toValue)) {
				ee.click();
				break;    //for loop exit le lega
			}
		}
		
		LOGGER.info("Entering Amr in to dropdown");
	}
	
	public void dateSelect() {
		selectDate.click();
		LOGGER.info("Entering today's date");
	}
	
	public void searchButtonClick() {
		searchButton.click();
		LOGGER.info("Clicking on search button");
	}
	
	public String errorMessageOnNoBusFound() {
		return errorOOPS_Message.getText();
	}


	public String getTitle() {
		return driver.getTitle();
	}


	public boolean RedBusLogoDisplay() {
		return logo.isDisplayed();
	}
	
	public void safetypop_up() {
		safetyPopup.click();
	}
	
	public void clickViewSeat() {
		viewSeat.click();
		LOGGER.info("Clicking on view seat");
	}


	public void scrollDown() {
		CommonFunctions.scrollWindow();
		
	}


	public void clickBusSeat() {
		System.out.println("Clicking on bus seat");
		CommonFunctions.mouseHover_Click(busCanvas, 250, 35);
	}



}
