package com.apptad.test;

import org.testng.annotations.Test;

import com.apptad.page.CreateDriver;
import com.apptad.page.SigninUser;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class SignInUserTest {
	WebDriver driver;
	SigninUser page;
  @Test()
  public void signinUser_Test_01() {
	  page.newUserSignIn();
  }
  
  @Test()
  public void newUserEmail_Test_02() {
	  page.validateEmail();
  }
	
	@Test()
	public void validateManFields_Test_03() {
		page.validateMandatoryFields();
	}
	
	@Test()
	public void validateFormat_Test_04() {
		page.validateFieldsFormat();
	}
  
  @BeforeMethod
  public void beforeTest() {
	driver=CreateDriver.getChromeDriver();
	driver.get("http://automationpractice.com/index.php");
	driver.manage().window().maximize();
	page=PageFactory.initElements(driver, SigninUser.class);
  }

  @AfterMethod
  public void afterTest() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.close();
  }
  

}
