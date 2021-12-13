package com.amazon.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.amazon.utils.Handlers;

public class LoginpageNew extends Handlers{
	//WebDriver driver;
	By helloSignIn=By.xpath("//span[contains(text(),'Hello, Sign in')]");
	By signInBtn=By.xpath("//div[@id='nav-flyout-ya-signin']/a/span");
	By emailormobiletextbox=By.id("ap_email");
	By continuebtn=By.id("continue");
	By password=By.id("ap_password");
	By signinbtnpasss=By.id("signInSubmit");
	
	public LoginpageNew(WebDriver driver){
		this.driver=driver;
	}
	
	public void mouseHoverSignIn(){
		WebElement ele=driver.findElement(helloSignIn);
		Handlers.mouseHoverEle(ele);
	}
	
	public void clickOnSignInBtn(){
		driver.findElement(signInBtn).click();
	}
	
	public void enterusername(String userName){
		driver.findElement(emailormobiletextbox).sendKeys(userName);
	}
	
	public void clickOnContinueBtn(){
		driver.findElement(continuebtn).click();
	}
	
	public void enterpassword(String Password){
		driver.findElement(password).sendKeys(Password);
	}
	
	public void clickOnSignBtnPass(){
		driver.findElement(signinbtnpasss).click();
	}
	
	
	

}
