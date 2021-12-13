package com.apptad.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class AmazonTest {
	private WebDriver wd;
	By signin=By.xpath("//*[@id=\'nav-link-accountList-nav-line-1\']");
	  @Test
	  public void f() {
		  wd.get("https://www.amazon.in/");
		  wd.manage().window().maximize();
		  WebElement s=wd.findElement(signin);
		  Actions act=new Actions(wd);
		  act.moveToElement(s).perform();
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
