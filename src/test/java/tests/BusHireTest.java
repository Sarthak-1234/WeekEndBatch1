package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import initiateTests.initClass;
import managers.ExcelFileManager;
import utils.Xls_Reader;


public class BusHireTest extends initClass{
	
	@Test
	public void checkTitle() throws IOException {
	
		String a = ExcelFileManager.getData("Data", "Sheet1", "Name", 3);
		System.out.println(a);
	}
}
