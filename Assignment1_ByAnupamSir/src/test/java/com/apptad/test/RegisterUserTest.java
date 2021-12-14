package com.apptad.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.appted.driver.CreateDriver;
import com.appted.page.RegisterUser;
import com.appted.screenshot.TakeScreenShotOnTest;

@Listeners(TakeScreenShotOnTest.class)
public class RegisterUserTest {
	WebDriver driver;
	RegisterUser page;
  @Test()
  public void newUser_Test_01() {
	  page.newUserRegister();
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
	page=PageFactory.initElements(driver, RegisterUser.class);
  }

  @AfterMethod
  public void afterTest() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.close();
  }
  

}
