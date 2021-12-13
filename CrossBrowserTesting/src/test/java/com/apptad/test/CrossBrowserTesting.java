package com.apptad.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class CrossBrowserTesting {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("https://www.facebook.com/");
	  driver.manage().window().maximize();
  }

	/*    For parallel execution
	 *    =======================
	 *    
	 * @Test public void f1() {
	 * driver.get("https://mail.google.com/mail/u/0/#inbox");
	 * driver.manage().window().maximize(); }
	 */
  
  
  @BeforeTest
  @Parameters("browser")
  public void beforeTest(String browser) {
	  if(browser.equalsIgnoreCase("chrome")) {
		  System.setProperty("webdriver.chrome.driver","D:\\selenium\\Files\\Data\\chromedriver.exe");
		  driver=new ChromeDriver();
	  }
	  else if(browser.equalsIgnoreCase("firefox")) {
		  System.setProperty("webdriver.gecko.driver","D:\\selenium\\Files\\Data\\geckodriver.exe");
		  driver=new FirefoxDriver();
	  }
	  else {
		  System.out.println(browser+" Not found");
	  }
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
