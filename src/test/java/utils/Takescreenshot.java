package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import initiateTests.initClass;

public class Takescreenshot {
	
	public static void takescreen(String filename) throws IOException {
		File src = ((TakesScreenshot)initClass.driver).getScreenshotAs(OutputType.FILE);//make driver static in initClass
		File dest = new File("target\\"+filename+".jpg");
		FileUtils.copyFile(src, dest);
	}

}
