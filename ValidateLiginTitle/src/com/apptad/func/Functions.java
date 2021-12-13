package com.apptad.func;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Functions {
	private WebDriver wd;
	
	//this constructor is used to initialise specific driver
	public Functions(WebDriver wd) {
		this.wd=wd;
	}
	
	//this method is used to setup driver
	public void setUpDriver(String chromedriver,String chromeurl){
		System.setProperty(chromedriver, chromeurl);
		wd=new ChromeDriver();
	}
	
	//this method is used to open site
	public void openSite(String webPage){
		wd.get(webPage);
		wd.manage().window().maximize();
	}
	
	//this method id used to perform login
	public void loginUser(String userid,String pass,String userBoxXpath,String passBoxxPath,String loginbtnXpath){
		wd.findElement(By.xpath(userBoxXpath)).sendKeys(userid);
		wd.findElement(By.xpath(passBoxxPath)).sendKeys(pass);
		wd.findElement(By.xpath(loginbtnXpath)).click();
		String actualResult=wd.getTitle();
		String expectedResult="Guru99 Bank Manager HomePage";
		System.out.println(actualResult);
		if(actualResult.equalsIgnoreCase(expectedResult))
			System.out.println("Actual Result and Expected Result are Same So test case passed");
		else
			System.out.println("Actual Result and Expected Result are not Same So test case failed");
	}
	
	//this method is used to close page
	public void closeDriver(){
		wd.close();
	}
	
}
