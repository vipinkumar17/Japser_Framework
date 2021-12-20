package testScript;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebdriverUtilty;

public class TC_01CreateOrganisation 
{
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
	@Test
	public static void crtOrg() throws Throwable
	{
		FileUtility fu = new FileUtility();
		String un = fu.getPropertKeyValue("username");
		String pwd = fu.getPropertKeyValue("password");
		String url = fu.getPropertKeyValue("url");
		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt = 'Create Organization...']")).click();
		
		ExcelUtility eu = new ExcelUtility();
		String orgName = eu.getExcelData("Sheet1", 1, 1);
		driver.findElement(By.name("accountname")).sendKeys(orgName + JavaUtility.getRandomData() );
		driver.findElement(By.name("website")).sendKeys("www.testyantra.com");
		String phno = eu.getExcelData("Sheet1", 1, 3);
		driver.findElement(By.id("phone")).sendKeys(phno);
		driver.findElement(By.id("fax")).sendKeys("7456984");
		driver.findElement(By.id("employees")).sendKeys("40");
		WebElement industry = driver.findElement(By.name("industry"));
		Select s = new Select(industry);
		s.selectByValue("Insurance");
		WebElement type = driver.findElement(By.name("accounttype"));
		WebdriverUtilty wdu = new WebdriverUtilty();
		wdu.SelectOption(type, 3);
		driver.findElement(By.id("email1")).sendKeys("emp@tyss.com");
		driver.findElement(By.name("description")).sendKeys("first Registerd Organisation");
		driver.findElement(By.name("button")).click();
	
//		WebElement logout = driver.findElement(By.xpath("(//td[@valign=\"bottom\"])[2]"));
		Thread.sleep(2000);
		WebElement logout = driver.findElement(By.xpath("(//td[@valign='bottom'])[2]"));
		wdu.mouseOver(driver, logout);
//		Actions a = new Actions(driver);
//		a.moveToElement(logout).perform();	
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();
	}
}