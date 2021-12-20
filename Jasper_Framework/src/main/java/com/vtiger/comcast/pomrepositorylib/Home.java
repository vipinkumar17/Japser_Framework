package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebdriverUtilty;

public class Home {
	WebDriver driver = null; //global driver variable
	public Home(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Organizations")
	private WebElement organizationink;

	@FindBy(linkText = "Products")
	private WebElement produclink;

	//@FindBy(xpath = "(//td[@valign = 'bottom'])[2]")
	@FindBy(xpath = "//img[@src = 'themes/softed/images/user.PNG']")
	private WebElement administratorImg;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink ;

	public WebElement getOrganizationlink() 
	{
		return organizationink;
	}

	public WebElement getProduclink() 
	{
		return produclink;
	}

	public WebElement getAdainstratorImg() 
	{
		return administratorImg;
	}

	public WebElement getsignOutLink()
	{
		return signOutLink;
	}

	public void logout() throws Throwable 
	{
		WebdriverUtilty wdu = new WebdriverUtilty();
		Thread.sleep(4000);
		wdu.mouseOver(driver, administratorImg);
		signOutLink.click();
	}
}
