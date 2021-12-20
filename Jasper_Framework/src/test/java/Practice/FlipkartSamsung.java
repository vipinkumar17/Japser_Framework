package Practice;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartSamsung {
static {
	System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
}
public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("7415284116");
	driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys("honeygawande");
	driver.findElement(By.xpath("//button[@class = '_2KpZ6l _2HKlqd _3AWRsL']")).click();
	Thread.sleep(3000);
	driver.findElement(By.name("q")).sendKeys("Samsung Mobile" + Keys.ENTER);
	Thread.sleep(3000);
	List<WebElement> allLinks = driver.findElements(By.xpath("//div[contains(text(),'SAMSUNG Galaxy ')]"));
	int count = allLinks.size();
	for(int i =0;i<count;i++)
	{
		String text = allLinks.get(i).getText();
		System.out.println(text);
	}
	allLinks.get(0).click();
	String ptab = driver.getWindowHandle();
	Set<String> allTab = driver.getWindowHandles();
	for(String tab :allTab)
	{
		//driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']/../../../../../div[2]/div[1]/ul/li[1]/button")).click();
		driver.switchTo().window(tab);
		if(!tab.equals(ptab))
		{
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		}
	}
}
}
