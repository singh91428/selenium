package com.amazontestrunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.pagefactory.pm.LoginpagePF;
import com.amazon.utils.CreateDriver;
import com.amazon.utils.GetData;

public class LoginTestRunnerpagefact {
	WebDriver driver;

	@BeforeTest
	public void setup(){
		driver=CreateDriver.getDriver();
	}

	@Test
	public void AM_01(){
		LoginpagePF page=	PageFactory.initElements(driver,LoginpagePF.class);
		page.mousehover();
		String userName=GetData.fromExcel("AmazonTestCase.xlsx","sheet1", 12,4);
		String password=GetData.fromExcel("AmazonTestCase.xlsx","sheet1", 14,4);
		page.loginapp(userName, password);
		String actualtitle=driver.getTitle();
		System.out.println("actualtitle:::" + actualtitle);
		String expetedTitle=GetData.fromExcel("AmazonTestCase.xlsx","Data",5,0);
		System.out.println("expetedTitle::" + expetedTitle);
		Assert.assertEquals(actualtitle, expetedTitle);

	}
	
	@AfterTest
	public void tearDown(){
		driver.close();
		driver.quit();
	}


}
