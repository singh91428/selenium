package com.amazontestrunner;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;





import com.amazon.utils.CreateDriver;
import com.amazon.utils.GetData;
/*
class AmazonTestrunnerPF {
	WebDriver driver;
	
	@BeforeTest
	public void setUp(){
		driver=CreateDriver.getDriver();
	}
	
	@Test
   public void tc_01(){
	  LoginPagePF page= PageFactory.initElements(driver, LoginPagePF.class);
	  page.mousehover();
	  String username= GetData.fromExcel("AmazonTestCase.xlsx","sheet1", 12,4);
	  String password= GetData.fromExcel("AmazonTestCase.xlsx","sheet1", 14,4);
	  page.loginapp(username, password);
	   
   }
	
	@AfterTest
	public void tearDown(){
		driver.close();
		driver.quit();
	}

}
*/