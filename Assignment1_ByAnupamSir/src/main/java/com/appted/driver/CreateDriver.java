package com.appted.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateDriver {
	public static WebDriver driver;
	public static WebDriver getChromeDriver() {
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\Files\\Data\\chromedriver.exe");
		driver=new ChromeDriver();
		return driver;
	}
	public static WebDriver getFireFoxDriver() {
		System.setProperty("webdriver.gecko.driver","D:\\selenium\\Files\\Data\\geckodriver.exe");
		driver=new FirefoxDriver();
		return driver;
	}
}
