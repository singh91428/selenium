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
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.appted.data.Xls_Reader;
import com.appted.driver.CreateDriver;
import com.appted.page.RegisterUser;
import com.appted.screenshot.TakeScreenShotOnTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//@Listeners(TakeScreenShotOnTest.class)
public class RegisterUserTest {
	WebDriver driver;
	RegisterUser page;
	public ExtentReports extent;
	public ExtentTest logger;
	Xls_Reader obj;
	String test1;
	String test2;
	String test3;
	String test4;
	int row;
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
		String path="D:\\Autimation_Suite2.xlsx";
		obj=new Xls_Reader(path);
		test1=obj.getCellData("Scenario",2,2);
		test2=obj.getCellData("Scenario",2,3);
		test3=obj.getCellData("Scenario",2,4);
		test4=obj.getCellData("Scenario",2,5);
//		System.out.println(test1);
//		System.out.println(test2);
//		System.out.println(test3);
//		System.out.println(test4);
		extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/Senario_1_Report.html",true);
		extent.addSystemInfo("Host name","localhost");
		extent.addSystemInfo("User name","c p singh");

	}
	@AfterTest
	public  void endReport() {
		extent.flush();
		extent.close();
	}
	@Test()
	public void newUser_Test_01() {
		logger=extent.startTest("newUser_Test_01");
		if(test1.equalsIgnoreCase("yes")) {
			driver.get("http://automationpractice.com/index.php");
			driver.manage().window().maximize();
			try {
				page.newUserRegister();
				row=2;		
			}
			catch(Exception e) {
				row=2;
				e.printStackTrace();
			}
		}
		else {
			row=2;
			Assert.assertEquals(false, true);
		}
	}

	@Test()
	public void newUserEmail_Test_02() {
		logger=extent.startTest("newUserEmail_Test_02");
		if(test2.equalsIgnoreCase("yes")) {
			driver.get("http://automationpractice.com/index.php");
			driver.manage().window().maximize();
			try {
				page.validateEmail();
				row=3;		
			}
			catch(Exception e) {
				row=3;
				e.printStackTrace();
			}
		}
		else {
			row=3;
			Assert.assertEquals(false, true);
		}
	}

	@Test()
	public void validateManFields_Test_03() {
		logger=extent.startTest("validateManFields_Test_03");
		if(test3.equalsIgnoreCase("yes")) {
			driver.get("http://automationpractice.com/index.php");
			driver.manage().window().maximize();
			try {
				page.validateMandatoryFields();
				row=4;		
			}
			catch(Exception e) {
				row=4;
				e.printStackTrace();
			}
		}
		else {
			row=4;
			Assert.assertEquals(false, true);
		}
	}

	@Test()
	public void validateFormat_Test_04() {
		logger=extent.startTest("validateFormat_Test_04");
		if(test4.equalsIgnoreCase("yes")) {
			driver.get("http://automationpractice.com/index.php");
			driver.manage().window().maximize();
			try {
				page.validateFieldsFormat();
				row=5;		
			}
			catch(Exception e) {
				row=5;
				e.printStackTrace();
			}
		}
		else {
			row=5;
			Assert.assertEquals(false, true);
		}
	}

	@BeforeMethod
	public void beforeTest() {
		driver=CreateDriver.getChromeDriver();
		
		page=PageFactory.initElements(driver, RegisterUser.class);

	}

	@AfterMethod
	public void afterTest(ITestResult result) throws InterruptedException {
		if(result.getStatus()==ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL,"TEST CASE FAILED IS "+result.getName());
			logger.log(LogStatus.FAIL,"TEST CASE FAILED IS "+result.getThrowable());
			String screenShot=RegisterUserTest.getScreenShotFailed(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenShot));
			obj.setCellData("Scenario","Status",row,"Failed");
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS,"TEST CASE PASSED IS "+result.getName());
			//logger.log(LogStatus.FAIL,"TEST CASE FAILED IS "+result.getThrowable());
			String screenShot=RegisterUserTest.getScreenShotSuccess(driver, result.getName());
			logger.log(LogStatus.PASS, logger.addScreenCapture(screenShot));
			obj.setCellData("Scenario","Status",row,"Passed");
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			obj.setCellData("Scenario","Status",row,"skip");
			logger.log(LogStatus.SKIP, "TEST CASE SKIPPED "+result.getName());
		}
		extent.endTest(logger);
		Thread.sleep(2000);
		driver.close();
	}


}
