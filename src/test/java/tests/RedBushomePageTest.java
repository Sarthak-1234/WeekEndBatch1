package tests;


import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import initiateTests.initClass;


//@Listeners(reporting.ListenersImplementation.class)
public class RedBushomePageTest extends initClass{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RedBushomePageTest.class);

	
	@Test 
	public void bookTicketForRedBus() throws IOException, InterruptedException  {
		
		LOGGER.info("Running testcase bookTicketForRedBus");
	
		homePage.selectCityFromDropDown();
		homePage.selectCityToDropDown();
		homePage.dateSelect();
		homePage.searchButtonClick();
		homePage.safetypop_up();
		Thread.sleep(3000);
		homePage.scrollDown();
		homePage.clickViewSeat();
		homePage.clickBusSeat();
		
	}
	
	@Test
	public void checkTitleOfRedBusHomePage() throws IOException {
		LOGGER.info("Running testcase checkTitle");
		
		Assert.assertEquals(homePage.getTitle(), "Boo Bus Travels, AC Volvo Bus, rPool & Bus Hire - redBus India");
		
	}
	
	@Test 
	public void checkLogoOfRedBusHomePage() throws IOException {
		throw new SkipException("It is skipped as implementation is going on");
		
	}
	
	

	
	
	
	
}
