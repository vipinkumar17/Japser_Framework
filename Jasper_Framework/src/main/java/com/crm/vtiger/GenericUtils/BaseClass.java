package com.crm.vtiger.GenericUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.vtiger.comcast.pomrepositorylib.Home;
import com.vtiger.comcast.pomrepositorylib.Login;

public class BaseClass 
{
	
	public WebdriverUtilty wlib=new WebdriverUtilty();
	public JavaUtility jlib=new JavaUtility();
	public ExcelUtility elib=new ExcelUtility();
	public FileUtility flib=new FileUtility();
	public WebDriver driver;
	public static WebDriver staticDriver; //null
	@BeforeSuite(groups = {"regression"})
	public void connectDB()
	{
		System.out.println("============= DB connected successfully ===============");
	}
	@Parameters(value = {"browser"}) // chrome/IE
	@BeforeClass(groups = {"regression"})
	public void launchBrowser(@Optional("chrome") String browserValue) throws Throwable {
	//read data from property file
	//String BROWSER = flib.getPropertKeyValue("browser");
	String URL = flib.getPropertKeyValue("url");

	if(browserValue.equalsIgnoreCase("chrome"))
	{
	driver=new ChromeDriver();
	}
	else if  (browserValue.equalsIgnoreCase("firefox")){
	driver=new FirefoxDriver();
	}
	else if(browserValue.equalsIgnoreCase("IE"))
	{
		driver = new EdgeDriver();
	}
	else {
	System.out.println("invalid browser name");
	}
	staticDriver = driver; // assigning driver referrence
	System.out.println("===========browser launch successfully=================");

	wlib.maximizeWindow(driver);
	wlib.waitUntilPageLoad(driver);
	driver.get(URL);
	}
	@BeforeMethod(groups = {"regression"})
	public void logInToApp() throws Throwable {
	//read data from property file
	String USERNAME = flib.getPropertKeyValue("username");
	String PASSWORD = flib.getPropertKeyValue("password");
	//login to app
	Login lp=new Login(driver);
	lp.loginToApp(USERNAME, PASSWORD);
	System.out.println("==========login successfully===========");
	}
	@AfterMethod(groups = {"regression"})
	public void logOutOfApp() throws Throwable
	{
	//signout of home page
	Home hp=new Home(driver);
	hp.logout();
	System.out.println("========logout successful====");
	}
	@AfterClass(groups = {"regression"})
	public void closeBrowser() {
	driver.close();
	System.out.println("======browser closed sucessfully=======");
	}
	@AfterSuite(groups = {"regression"})
	public void closeDB() {

	System.out.println("=====DB connection closed=====");
	}
	}

