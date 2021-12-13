package com.apptad.test;

import org.testng.annotations.Test;

import com.appted.helper.CreateDriver;
import com.appted.helper.EcommercePage;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
public class BuyProductTest {
	WebDriver driver;
	EcommercePage  page;
  @Test
  public void buyPrductTest() {
	  page.buyProduct(driver);
  }
  @Test
  public void wishListTest() {
	  page.wishList(driver);
  }
  @Test
  public void veryfyPriceTest() {
	  page.verifyPrice();
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver=CreateDriver.getChromeDriver();
	  driver.get("http://automationpractice.com/index.php");
	  driver.manage().window().maximize();
	  page=PageFactory.initElements(driver, EcommercePage.class);
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.close();
  }

}
