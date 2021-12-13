package com.amazontestrunner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.amazon.pom.LoginpageNew;
import com.amazon.utils.CreateDriver;
import com.amazon.utils.GetData;
import com.amazon.utils.Handlers;

public class LoginpageTestRunnernew {
    WebDriver driver;
    LoginpageNew page;
    
    @BeforeClass
    public void setUp(){
    	driver=CreateDriver.getDriver();
    	page=new LoginpageNew(driver);
    }
    
    @Test
    public void AM_01(){
    	page.mouseHoverSignIn();
    	page.clickOnSignInBtn();
    	
    	String userName=GetData.fromExcel("AmazonTestCase.xlsx","sheet1", 12,4);
		System.out.println("userName::" +  userName);
    	page.enterusername(userName);
    	page.clickOnContinueBtn();
    	
    	String password=GetData.fromExcel("AmazonTestCase.xlsx","sheet1", 14,4);
		System.out.println("password::" +  password);
		page.enterpassword(password);
		page.clickOnSignBtnPass();
		String expectedTitle=GetData.fromExcel("AmazonTestCase.xlsx","Data", 0,0);
		Handlers.verifytitleOfpage(expectedTitle);
    	
    	
    }
    
    @AfterClass
    public void tearDown(){
    	driver.close();
    }


}
