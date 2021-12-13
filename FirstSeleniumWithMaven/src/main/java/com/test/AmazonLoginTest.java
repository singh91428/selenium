package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class AmazonLoginTest {
	private WebDriver wd;	
  @Test
  public void f() {
	  wd.get("https://www.amazon.in/");
	  wd.manage().window().maximize();
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver","D:\\selenium\\Files\\Data\\chromedriver.exe");
	  wd=new ChromeDriver();
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  Thread.sleep(3000);
	  wd.quit();
  }

}
