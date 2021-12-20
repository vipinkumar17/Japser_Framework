package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OrganizatioInfoPage {
	WebDriver driver = null;
	public OrganizatioInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		@FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement succesfullMsg;
		public WebElement getSuccesfullMsg() 
		{
		return succesfullMsg;
		}
}
