package com.apptad.helper;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class CreateDriver {
	private static WebDriver driver=null;
	public void getDriver()
	{
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\Files\\Data\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	} 
	public void failed(String methodName) {
		TakesScreenshot tss=(TakesScreenshot)driver;
		File file=tss.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file,new File("D:\\SeleniumTestNG\\ScreenShotProgram\\screenshot\\"+methodName+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
