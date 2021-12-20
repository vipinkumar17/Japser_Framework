package com.vtiger.comcast.pomrepositorylib;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebdriverUtilty;

public class CreateNewOrganization extends WebdriverUtilty
{
	WebDriver driver = null;
	public CreateNewOrganization(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement createimg;
	
	@FindBy(linkText = "TestYantra")
	private WebElement memberOfPopUp;
	
	@FindBy(name = "button")
	private WebElement saveBtn;

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getCreateimg() {
		return createimg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getMemberOfPopUp() {
		return memberOfPopUp;
	}

	public void createOrg(String orgName)
	{
		orgNameEdt.sendKeys(orgName);
		createimg.click();
		String pwh = driver.getWindowHandle();
		switchToWIndow(driver, "Accounts&action");
		memberOfPopUp.click();
		acceptAlert(driver);
		driver.switchTo().window(pwh);
		saveBtn.click();
	}
}