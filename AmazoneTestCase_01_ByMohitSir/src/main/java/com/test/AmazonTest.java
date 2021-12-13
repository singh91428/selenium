package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonTest {
	public WebDriver webDriver;
	public LoginPage newloginPage;
	public Handlers handler;
  @Test(priority = 1)
  public void AM_01() {
	  String efile=WebElements.excelFileName;
	  String email=GetData.fromExcel(WebElements.excelFileName,"Data",0, 0);
	  String pass=GetData.fromExcel(WebElements.excelFileName,"Data",0, 1);
	  LoginPage page=PageFactory.initElements(webDriver, LoginPage.class);
		WebElement ele=page.helloSignIN();
		Handlers.ActionsmoveToElement(ele, webDriver);
	     page.clickOnSignIn();
	     page.enterEmailOrMobileNum(email);
	     page.clickOnContine();
	     page.enterPassword(pass);
	     page.clickOnLogin();
	     String actualResult = page.welcomeMsg();
		String expectedResult = "Hello, c";
		Assert.assertEquals(actualResult, expectedResult);
		Handlers.ActionsmoveToElement(ele, webDriver);
		page.signOut();
  }
  @Test(priority = 2)
  public void AM_02() {
	  LoginPage page=PageFactory.initElements(webDriver, LoginPage.class);
		WebElement ele=page.helloSignIN();
		Handlers.ActionsmoveToElement(ele, webDriver);
	     page.clickOnSignIn();
	     page.enterEmailOrMobileNum("gdghhgdhg");
	     page.clickOnContine();
	     String actualResult=page.errMsg();
	     String expectedResult="We cannot find an account with that email address";
	     Assert.assertEquals(actualResult, expectedResult);
  }
  @Test(priority = 3)
  public void AM_03() {
	  String efile=WebElements.excelFileName;
	  String email=GetData.fromExcel(WebElements.excelFileName,"Data",0, 0);
	  //String pass=GetData.fromExcel(WebElements.excelFileName,"Data",0, 1);
	  LoginPage page=PageFactory.initElements(webDriver, LoginPage.class);
		WebElement ele=page.helloSignIN();
		Handlers.ActionsmoveToElement(ele, webDriver);
	     page.clickOnSignIn();
	     page.enterEmailOrMobileNum(email);
	     page.clickOnContine();
	     page.enterPassword("fdsfsdfsfdf");
	     page.clickOnLogin();
	     String actualResult=page.passerrMsg();
	     String expectedResult="Your password is incorrect";
	     Assert.assertEquals(actualResult, expectedResult);
  }
  @BeforeMethod
  public void setUp(){
		webDriver=CreateDriver.getDriver();
		newloginPage=new LoginPage(webDriver);
	}

  @AfterMethod
  public void closeDriver() throws InterruptedException{
	  Thread.sleep(3000);
	  webDriver.quit();
  }

}
