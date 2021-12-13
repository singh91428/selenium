package com.apptad.test;

import org.testng.annotations.Test;

import com.appted.helper.CreateDriver;
import com.appted.helper.EcommercePage;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class EcommerceTest {
	WebDriver wd;
	EcommercePage page;
  @Test
  public void User_Scenario_2() {
	  page.scenenario_02(wd);
  }
  @BeforeMethod
  public void beforeMethod() {
	  wd=CreateDriver.getChromeDriver();
	  wd.get("http://automationpractice.com/index.php");
	  wd.manage().window().maximize();
	  page=PageFactory.initElements(wd, EcommercePage.class);
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(3000);
	  wd.close();
  }

}
