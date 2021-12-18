package com.appted.screenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.appted.driver.CreateDriver;

public class TakeScreenShotOnTest extends CreateDriver implements ITestListener {
	String date=new  SimpleDateFormat("yyyymmddss").format(new Date());
	public void onTestFailure(ITestResult result) {
		TakesScreenshot screenShot=(TakesScreenshot)driver;
		File f=screenShot.getScreenshotAs(OutputType.FILE);
		File destination= new File("D:\\SeleniumTest\\selenium\\Assignment1_ByAnupamSir\\failedcase\\"+result.getMethod().getMethodName()+date+".jpg");
		try {
			FileUtils.copyFile(f,destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void onTestSuccess(ITestResult result) {
		TakesScreenshot screenShot=(TakesScreenshot)driver;
		File f=screenShot.getScreenshotAs(OutputType.FILE);
		File destination=new File("D:\\SeleniumTest\\selenium\\Assignment1_ByAnupamSir\\passcese\\"+result.getMethod().getMethodName()+date+".jpg");
		try {
			FileUtils.copyFile(f,destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
