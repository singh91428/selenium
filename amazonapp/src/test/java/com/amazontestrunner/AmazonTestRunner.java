package com.amazontestrunner;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.pom.LoginPage;
import com.amazon.utils.CreateDriver;
import com.amazon.utils.GetData;

public class AmazonTestRunner {
	WebDriver driver;
	LoginPage page;
	//Homepage page;
	
	//@BeforeTest
	@BeforeClass
	public void setUp(){
		driver=CreateDriver.getDriver();
		page=new LoginPage(driver);
	}
	
	@Test(enabled=false)
	public void AM_01(){
		page.mousehoverhellosignin();
		page.clickOnSinginBt();
		String userName=GetData.fromExcel("AmazonTestCase.xlsx","sheet1", 12,4);
		System.out.println("userName::" +  userName);
		page.enteremailormoble(userName);
		page.clickOnContinue();
		String password=GetData.fromExcel("AmazonTestCase.xlsx","sheet1",14,4);
		page.enterpassword(password);
		page.clickOnLoginbtn();
		String actualTitle=driver.getTitle();
		System.out.println("actualTitle::" + actualTitle);
		String expectedTitle="Amazon Sign In";
		System.out.println("expectedTitle::" + expectedTitle);
		Assert.assertEquals(actualTitle,expectedTitle);
	}
	
	@Test(enabled=false)
	public void AM_02(){
		page.mousehoverhellosignin();
		page.clickOnSinginBt();
		String userName=GetData.fromExcel("AmazonTestCase.xlsx","sheet1",19,4);
		page.enteremailormoble(userName);
		page.clickOnContinue();
		String actualstr=page.getinvalidemailorphoneerrormsg();
		System.out.println("actualstr::" + actualstr);
		String expectedStr=  GetData.fromExcel("AmazonTestCase.xlsx","Data",6,0);
		System.out.println("expectedStr::" + expectedStr);
		Assert.assertEquals(actualstr, expectedStr);
		
	}
	
	@Test()
	public void AM_03(){
		page.mousehoverhellosignin();
		page.clickOnSinginBt();
		String userName=GetData.fromExcel("AmazonTestCase.xlsx","sheet1",23,4);
		page.enteremailormoble(userName);
		page.clickOnContinue();
		String password=GetData.fromExcel("AmazonTestCase.xlsx","sheet1",14,4);
		page.enterpassword(password);
		page.clickOnLoginbtn();				
		String actualstr=page.invalidPasserrMsg();
		System.out.println("actualstr::" + actualstr);
		String expectedStr=  GetData.fromExcel("AmazonTestCase.xlsx","Data",0,0);
		System.out.println("expectedStr::" + expectedStr);
		Assert.assertEquals(actualstr, expectedStr);
		
		
	}

	
	//@AfterTest
	@AfterClass
	public void tearDown(){
		driver.close();
		driver.quit();
	}


}
