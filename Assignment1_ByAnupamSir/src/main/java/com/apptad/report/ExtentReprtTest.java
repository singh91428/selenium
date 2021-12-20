package com.apptad.report;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.appted.driver.CreateDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReprtTest extends CreateDriver implements ITestListener{
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static void setExtent() {
		extent=new ExtentReports(System.getProperty("user.dir")+"test-output/Report.html",true);
		extent.addSystemInfo("Host name","localhost");
		extent.addSystemInfo("User name","c p singh");
		
	}
	public static void endReport() {
		extent.flush();
		extent.close();
	}
	public static String getScreenShotFailed(WebDriver driver,String screenShotname) {
		String date=new  SimpleDateFormat("yyyymmddss").format(new Date());
		TakesScreenshot screenShot=(TakesScreenshot)driver;
		File f=screenShot.getScreenshotAs(OutputType.FILE);
		String destination="D:\\SeleniumTest\\selenium\\Assignment1_ByAnupamSir\\failedcase\\"+screenShotname+date+".jpg";
		File FileDestination=new File(destination);
		try {
			FileUtils.copyFile(f,FileDestination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destination;
	}
	public static String getScreenShotPass(WebDriver driver,String screenShotname) {
		String date=new  SimpleDateFormat("yyyymmddss").format(new Date());
		TakesScreenshot screenShot=(TakesScreenshot)driver;
		File f=screenShot.getScreenshotAs(OutputType.FILE);
		String destination="D:\\SeleniumTest\\selenium\\Assignment1_ByAnupamSir\\passcese\\"+screenShotname+date+".jpg";
		File FileDestination=new File(destination);
		try {
			FileUtils.copyFile(f,FileDestination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destination;
	}
	public static void tearDown(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL,"TEST CASE FAILED IS "+result.getName());
			logger.log(LogStatus.FAIL,"TEST CASE FAILED IS "+result.getThrowable());
			String screenShot=ExtentReprtTest.getScreenShotFailed(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreencast(screenShot));
			
		}
		if(result.getStatus()==ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS,"TEST CASE PASS IS "+result.getName());
			//logger.log(LogStatus.FAIL,"TEST CASE FAILED IS "+result.getThrowable());
			String screenShot=ExtentReprtTest.getScreenShotPass(driver, result.getName());
			logger.log(LogStatus.PASS, logger.addScreencast(screenShot));
			
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "TEST CASE SKIP "+result.getName());
		}
		extent.endTest(logger);
	}
}
