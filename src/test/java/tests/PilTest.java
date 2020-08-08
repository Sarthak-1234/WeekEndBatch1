	
	package tests;

	import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

	import initiateTests.initClass;
import pages.pilPages;
//@Listeners(reporting.ListenersImplementation.class)
	public class PilTest extends initClass{

		

		
		@Test
		public void bookTicketForPilgrimage() throws IOException, InterruptedException
		{
		
			pilpage.clickPiligrimageTab();
			pilpage.selectCityfromDropdown();
		    Thread.sleep(3000);
		    pilpage.selectCityToDropDown();
		    Thread.sleep(5000);
		    pilpage.selectDate();
		    Thread.sleep(5000);
		    pilpage.searchButtonClick();
		
			
		}
		
		
		
	}



