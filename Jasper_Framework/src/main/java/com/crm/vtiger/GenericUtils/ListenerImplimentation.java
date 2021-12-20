package com.crm.vtiger.GenericUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class ListenerImplimentation extends JavaUtility implements ITestListener  {

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) 
	{
		String testName = result.getMethod().getMethodName();
		Date d = new Date();
		String currentDate = d.toString().replace(" ", "_").replace(":", "_");
		System.out.println(testName + "---------Execute & I am Listening");
		
		EventFiringWebDriver takescreenshot=new EventFiringWebDriver(BaseClass.staticDriver);
		File source=takescreenshot.getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")+".//screenshot//"+"_"+result.getMethod().getMethodName()+"_"+JavaUtility.getSystemDate()+".PNG";
		File dest = new File(screenshotPath);
//		File dest=new File(".//screenshot/"+testName+currentDate+".png");

		try {
			Files.copy(source, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}


}
