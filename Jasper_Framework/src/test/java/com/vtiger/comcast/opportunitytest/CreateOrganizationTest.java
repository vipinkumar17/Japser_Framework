package com.vtiger.comcast.opportunitytest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebdriverUtilty;
import com.vtiger.comcast.pomrepositorylib.CreateNewOrganization;
import com.vtiger.comcast.pomrepositorylib.Home;
import com.vtiger.comcast.pomrepositorylib.Login;
import com.vtiger.comcast.pomrepositorylib.OrganizatioInfoPage;
import com.vtiger.comcast.pomrepositorylib.Organization;

public class CreateOrganizationTest {
	
	public static void main(String[] args) throws Throwable {
		
	/* Create Object */
	ExcelUtility eLib = new ExcelUtility();
	FileUtility fLib = new FileUtility();
	JavaUtility jLib = new JavaUtility();
	WebdriverUtilty wduLib = new WebdriverUtilty();
	WebDriver driver = null;
	
	/* Read Common Data*/
	String BROWSER = fLib.getPropertKeyValue("browser");
	String  URL = 	fLib.getPropertKeyValue("url");
	String  USERNAME = fLib.getPropertKeyValue("username");
	String  PASSWORD = fLib.getPropertKeyValue("password");
	System.out.println(USERNAME);
	System.out.println(PASSWORD);
	/* read test data from excel */
	
	String orgName = eLib.getExcelData("Sheet1", 1, 1) + "_" + JavaUtility.getRandomData();
	
	/* Step 1 :launch the browser */
	if(BROWSER.equals("firefox"))
	{
	 driver = new FirefoxDriver();
	}
	else if(BROWSER.equals("Chrome")) 
	{
	 driver = new ChromeDriver();	
	}
	else if(BROWSER.equals("IE")) 
	{
	 driver = new InternetExplorerDriver();	
	}
	else
	{
		 driver = new ChromeDriver();
		
	}
	/* Step 2 : login to app*/
		
		driver.get(URL);
		Login lp = new Login(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		/* Step 3 : navigate to Organizations*/
		Home h = new Home(driver);
		h.getOrganizationlink().click();

		/* Step 4 : navigate to Create Organization Page */
		Organization org = new Organization(driver);
		org.getCreateOrgImg().click();

		/* Step 5 : create Organization*/
		CreateNewOrganization cno = new CreateNewOrganization(driver);
		cno.createOrg(orgName);
		/*Step 6 : verify */
		
		 OrganizatioInfoPage oinfop = new OrganizatioInfoPage(driver);
		 wduLib.waitForElementVisibility(driver, oinfop.getSuccesfullMsg());
		 String actSuccMsg = oinfop.getSuccesfullMsg().getText();
		if(actSuccMsg.contains(orgName))
		{
			System.out.println("Org is created successfully");
		}
		else {
			System.out.println("Org is not created successfully");
		}
		/* logout */
		h.logout();
		/* close the browser */
		driver.close();
	}
}