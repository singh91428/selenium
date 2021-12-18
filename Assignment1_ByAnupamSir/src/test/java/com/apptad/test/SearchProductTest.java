package com.apptad.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.appted.driver.CreateDriver;
import com.appted.page.SearchProduct;
import com.appted.screenshot.TakeScreenShotOnTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


//@Listeners(TakeScreenShotOnTest.class)
public class SearchProductTest {
	WebDriver wd;
	SearchProduct page;
	public ExtentReports extent;
	public ExtentTest logger;
	public static String getScreenShotFailed(WebDriver driver,String screenShotname) {
		String date=new  SimpleDateFormat("yyyy-mm-dd").format(new Date());
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
	public static String getScreenShotSuccess(WebDriver driver,String screenShotname) {
		String date=new  SimpleDateFormat("yyyy-mm-dd").format(new Date());
		TakesScreenshot screenShot=(TakesScreenshot)driver;
		File f=screenShot.getScreenshotAs(OutputType.FILE);
		String destination="D:\\SeleniumTest\\selenium\\Assignment1_ByAnupamSir\\passedcase\\"+screenShotname+date+".jpg";
		File FileDestination=new File(destination);
		try {
			FileUtils.copyFile(f,FileDestination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destination;
	}
	@BeforeTest
	public void setExtent() {
		extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/Senario_2_Report.html",true);
		extent.addSystemInfo("Host name","localhost");
		extent.addSystemInfo("User name","c p singh");
		
	}
	@AfterTest
		public  void endReport() {
			extent.flush();
			extent.close();
		}
  @Test
  public void searchProductTest() {
	  logger=extent.startTest("searchProductTest");
	  page.scenenario_02();
  }
  @BeforeMethod
  public void beforeMethod() {
	  wd=CreateDriver.getChromeDriver();
	  wd.get("http://automationpractice.com/index.php");
	  wd.manage().window().maximize();
	  page=PageFactory.initElements(wd, SearchProduct.class);
  }

  @AfterMethod
  public void afterMethod(ITestResult result) throws InterruptedException {
	  if(result.getStatus()==ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL,"TEST CASE FAILED IS "+result.getName());
			logger.log(LogStatus.FAIL,"TEST CASE FAILED IS "+result.getThrowable());
			String screenShot=SearchProductTest.getScreenShotFailed(wd, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenShot));
			
		}
	  else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS,"TEST CASE PASSED IS "+result.getName());
			//logger.log(LogStatus.FAIL,"TEST CASE FAILED IS "+result.getThrowable());
			String screenShot=SearchProductTest.getScreenShotSuccess(wd, result.getName());
			logger.log(LogStatus.PASS, logger.addScreenCapture(screenShot));
			
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "TEST CASE SKIPPED "+result.getName());
		}
	extent.endTest(logger);
	  Thread.sleep(3000);
	  wd.close();
  }

}
