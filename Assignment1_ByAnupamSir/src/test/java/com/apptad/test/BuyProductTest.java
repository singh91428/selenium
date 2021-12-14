package com.apptad.test;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.appted.driver.CreateDriver;
import com.appted.page.EcommercePage1;
import com.appted.screenshot.TakeScreenShotOnTest;
@Listeners(TakeScreenShotOnTest.class)
public class BuyProductTest {
	WebDriver driver;
	EcommercePage1  page;
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
	  page.verifyPrice(driver);
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver=CreateDriver.getChromeDriver();
	  driver.get("http://automationpractice.com/index.php");
	  driver.manage().window().maximize();
	  page=PageFactory.initElements(driver, EcommercePage1.class);
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.close();
  }

}
