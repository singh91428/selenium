package com.apptad.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.apptad.comp.WebElements;

public class LoginTestingAndValidateTitle {
	public WebDriver wd;
	
	@BeforeTest(description = "setup Web Driver")
	public void setDriver() {
		System.setProperty(WebElements.chromeDriver,WebElements.chromeUrl);
		wd=new ChromeDriver();
	}
	
	@Test(description = "This method first lounching the browse")
	public void lounchBrowser() {
		wd.get(WebElements.webSite);
		wd.manage().window().maximize();
	}
	
	@Test(description = "This method is used to do login and validate title",dependsOnMethods = "lounchBrowser")
	public void validateTitle() {
		wd.findElement(By.xpath(WebElements.userIdXpathbox)).sendKeys("mngr371415");
		wd.findElement(By.xpath(WebElements.passXpathbox)).sendKeys("EnUbabA");
		wd.findElement(By.xpath(WebElements.loginXpathbtn)).click();
		String actualResult=wd.getTitle();
		String expectedResult="Guru99 Bank Manager HomePage";
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@AfterTest(description = "closing the browser")
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		wd.close();
	}
}
