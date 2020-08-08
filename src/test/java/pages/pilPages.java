	
	package pages;

	import java.io.IOException;
	import java.util.List;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import managers.PropertyFileManager;

	public class pilPages {

		WebDriver driver;
		
		@FindBy(css="input#source_city")
		public WebElement searchFromDropDown;
		
		
	    
		@FindBy(css="ul.show.suggestions-wrapper.fade-in >li")
		public List<WebElement> dropDownList;
		
	    @FindBy(css="a#pilgrimages")
		public WebElement pilgrimagetabClick;
		
		@FindBy(css="input#dest_city")
		public WebElement searchToDropDown;
		 
		
	    @FindBy(css="ul.show.suggestions-wrapper.fade-in >li")
		public List<WebElement> dropDownList1;
		
		@FindBy(css="input#doj")
		public WebElement dateSelect;
		
		@FindBy(css="button#search_packages")
		public WebElement buttonSearchClicked;
		
		public pilPages(WebDriver driver)
		{
			
			this.driver=driver;
			PageFactory.initElements(driver,this);
			
		}
		
		public void clickPiligrimageTab()
		{
			
			pilgrimagetabClick.click();
			
			
		}
		public void selectCityfromDropdown() throws IOException, InterruptedException
		{
			
			searchFromDropDown.sendKeys("New");
			
			String fromCity= PropertyFileManager.getPropertyValue("Pilgrimage", "FromDropDownValue");
			//System.out.println(fromCity);
			Thread.sleep(2000);
			
			for(WebElement e: dropDownList)
			{
				if(e.getText().equalsIgnoreCase(fromCity))
				{
					System.out.println(e.getText());
					
					e.click();
				    break;
				
				}
				
				
			}
			
		}
		
		public void selectCityToDropDown() throws IOException, InterruptedException
		{
			searchToDropDown.sendKeys("Kat");
			String toCity= PropertyFileManager.getPropertyValue("Pilgrimage", "ToDropDownValue");
			System.out.println(toCity);
			Thread.sleep(2000);
			
			for(WebElement ee: dropDownList1)
			{
				if(ee.getText().equalsIgnoreCase(toCity))
				{
					//System.out.println(ee.getText());
					ee.click();
				    break;
				
				}
				
				
			}
			
		}
		
		public void selectDate()
		{
			
			dateSelect.click();
			
		}
		
		public void searchButtonClick()
		{
			buttonSearchClicked.click();
			
		}
		
		
	}



