package com.amazontestrunner;

import org.apache.commons.math3.distribution.GeometricDistribution;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.amazon.pagefactory.pm.LoginPage;
import com.amazon.utils.CreateDriver;
import com.amazon.utils.GetData;
import com.amazon.utils.Handlers;

public class LoginFageFactory extends Handlers {
	//WebDriver driver;
	@BeforeClass
	public void setUp(){
		driver=CreateDriver.getDriver();
	}
	@Test
	public void M01(){
		LoginPage page=PageFactory.initElements(driver, LoginPage.class);
		String username= GetData.fromExcel("AmazonTestCase.xlsx","sheet1", 12,4);
		String password= GetData.fromExcel("AmazonTestCase.xlsx","sheet1", 14,4);
		page.loginPage(username, password);
		//Handlers.verifytitleOfpage("")
	}
	
	@AfterClass
	public void tearDown(){
		driver.close();
	}

}
