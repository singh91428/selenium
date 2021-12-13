package com.apptad.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateDriver {
	static WebDriver driver;
	public static WebDriver getChromeDriver() {
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\Files\\Data\\chromedriver.exe");
		driver=new ChromeDriver();
		return driver;
	}
}
