package managers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileManager {
	
	public static FileInputStream fis;
	public static Properties prop;
	
	//It will take key from the user and return the value from property file
	
	public static String getPropertyValue(String propertyFileName, String key) throws IOException {
		fis = new FileInputStream("src\\test\\resources\\propertyFiles\\"+propertyFileName+".properties");
		prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}
}
