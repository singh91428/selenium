package com.bank.func;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//setup firefox driver 
public class BrowserFunctionality {
	public static WebDriver driver;
	public static void setUpBrowser(String ffdriver,String driverurl){
		System.setProperty(ffdriver,driverurl);
		driver = new FirefoxDriver();
	}
	
	//Open FireFox Browser
	public static void openFireFoxBrowser(String site){
		driver.get(site);
	}
	
	//Login Respected Website Using it's Link
	public static void loginSite() throws InterruptedException{
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys("chandu");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("chandu");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]")).click();
		String actualResult=driver.switchTo().alert().getText();
		String expectedResult="User is not valid";
		if(actualResult.equalsIgnoreCase(expectedResult))
			System.out.println("actualValue & expectedValue are matched & Test Case Passed");
	else
		System.out.println("actualValue & expectedValue are not matched & Test Case Failed");
		
		//Pause alert message for a second to see their message
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
	}
	
	//This message is used to close driver
	public static void closeBrowser(){
		driver.close();
	}
}
