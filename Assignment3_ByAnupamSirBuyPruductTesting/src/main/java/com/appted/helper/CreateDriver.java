package com.appted.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateDriver {
	static WebDriver driver;
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
