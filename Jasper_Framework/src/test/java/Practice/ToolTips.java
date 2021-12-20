package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.vtiger.GenericUtils.WebdriverUtilty;

public class ToolTips {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		WebdriverUtilty wLib = new WebdriverUtilty();
		wLib.waitUntilPageLoad(driver);
		driver.get("https://demoqa.com/tool-tips");
		WebElement btn = driver.findElement(By.id("toolTipButton")); 
		wLib.mouseOver(driver, btn);
		String text = driver.findElement(By.xpath("//div[@class = 'tooltip-inner']")).getText(); 
		System.out.println(text);
		Thread.sleep(4000);
		driver.findElement(By.id("toolTipTextField")).sendKeys(text);
		//driver.close();
	}
}
