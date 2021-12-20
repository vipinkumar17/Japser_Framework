package Demo;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadDataFromPropertyFile {
@Test
	public void readDataFromPropertyFile() throws Throwable
	{
		/* read the data from peoperties file*/
	// Step 1: get the java representation object of the physical file
	FileInputStream fis = new FileInputStream("./Data/CommonData.properties");
	//Step 2: create an object of properties class and load all the key:value pairs
	Properties p = new Properties();
	p.load(fis);
	//Step 3 : read the value using getProperty("key")
	String url = p.getProperty("url");
	String browser = p.getProperty("browser");
	String un = p.getProperty("username");
	String pwd = p.getProperty("password");
	System.out.println(url);
	System.out.println(browser);
	System.out.println(un);
	System.out.println(pwd);
	}

}
