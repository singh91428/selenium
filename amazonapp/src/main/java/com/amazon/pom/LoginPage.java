package com.amazon.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {
	WebDriver driver;
	By hellosignin=By.xpath("//span[contains(text(),'Hello, Sign in')]");
	By signbtn=By.xpath("//div[@id='nav-flyout-ya-signin']//span[1]");
	By emailormoble=By.id("ap_email");
	By continue_btn=By.id("continue");
	By password=By.id("ap_password");
	By loginbtn=By.id("signInSubmit");
	By invalidemailorphoneerrormsg=By.xpath("//h4[contains(text(),'There was a problem')]//following::span[1]");
	By invalidpasswordError=By.xpath("//h4[contains(text(),'Important Message!')]");
	
	
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	public void mousehoverhellosignin(){
		WebElement ele=driver.findElement(hellosignin);
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	public void clickOnSinginBt(){
		driver.findElement(signbtn).click();
	}
	
	public void enteremailormoble(String username){
		driver.findElement(emailormoble).sendKeys(username);
	}
	
	public void clickOnContinue(){
		driver.findElement(continue_btn).click();
	}
	
	public void enterpassword(String pass){
		driver.findElement(password).sendKeys(pass);
	}
	
	public void clickOnLoginbtn(){
		driver.findElement(loginbtn).click();
	}
	
	public String getinvalidemailorphoneerrormsg(){
		String errormsg=driver.findElement(invalidemailorphoneerrormsg).getText();
		return errormsg;
	}
	public String invalidPasserrMsg(){
		String errormsg=driver.findElement(invalidpasswordError).getText();
		return errormsg;
	}
	
	

}
