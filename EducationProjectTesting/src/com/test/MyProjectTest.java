package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyProjectTest {
public WebDriver wd;
	
	@BeforeTest(description = "setup Web Driver")
	public void setDriver() {
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\Files\\Data\\chromedriver.exe");
		wd=new ChromeDriver();
	}
	
	@Test(description = "This method first lounching the browse",priority = 1)
	public void lounchBrowser() {
		wd.get("http://localhost:8080/finalEducation/");
		wd.manage().window().maximize();
	}
	
	@Test(dependsOnMethods = "lounchBrowser",priority = 2)
	public void openAdminPart() {
		wd.findElement(By.xpath("//span[text()='Admin']")).click();
	}
	
	@Test(priority = 3)
	public void loginAdmin() {
		By email=By.name("email");
		By pass=By.name("password");
		By login=By.xpath("/html/body/center/div/form/input[3]");
		wd.findElement(email).sendKeys("nitish@gmail.com");
		wd.findElement(pass).sendKeys("nittish");
		wd.findElement(login).click();
	}
}
