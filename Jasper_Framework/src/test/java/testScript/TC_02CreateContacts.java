package testScript;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.experimental.theories.suppliers.TestedOn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC_02CreateContacts 
{
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
		@Test
		public static void crtOrg()
		{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt ='Create Contact...']")).click();
		WebElement fn = driver.findElement(By.name("salutationtype"));
		Select s = new Select(fn);
		s.selectByIndex(1);
		driver.findElement(By.name("firstname")).sendKeys("Arjun");
		driver.findElement(By.name("lastname")).sendKeys("Reddy");
		driver.findElement(By.id("phone")).sendKeys("9638521470");
		driver.findElement(By.xpath("(//img[@alt ='Select'])[1]")).click();
		String pwh = driver.getWindowHandle();
		Set<String> allWh = driver.getWindowHandles();
		for(String wh:allWh)
		{
			if(!wh.equals(pwh))
			{
				driver.switchTo().window(wh);
				driver.findElement(By.id("2")).click();
			}
		}
		driver.switchTo().window(pwh);
		
//		for(String wh:allWh)
//		{
//			driver.switchTo().window(wh);
//		}
//		driver.findElement(By.id("2")).click();
//			if(!title.contains("Administrator"))
//			{
			
//			driver.findElements(By.xpath("//a"));
//			driver.findElement(By.linkText("TestYantra")).click();
//			}
//			driver.findElement(By.xpath("//a[.='TestYantra']")).click();
		driver.findElement(By.id("mobile")).sendKeys("9874563210");
		WebElement leadSource = driver.findElement(By.name("leadsource"));
		Select s1 =new Select(leadSource);
		s1.selectByValue("Employee");
		driver.findElement(By.id("department")).sendKeys("Marketing");
		driver.findElement(By.id("fax")).sendKeys("7894256");
		driver.findElement(By.id("email")).sendKeys("arjun@gmail.com");
		driver.findElement(By.id("jscal_trigger_birthday")).click();
		driver.findElement(By.xpath("(//td[@colspan='1'])[21]")).click();
		}
}
