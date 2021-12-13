 package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	
	@FindBy(id = "nav-link-accountList-nav-line-1")
	 WebElement helloSignin;
	
	@FindBy(xpath="//*[@id='nav-flyout-ya-signin']/a/span")
	WebElement signIn;
	
	@FindBy(id="ap_email")
	WebElement emailormobileNumField;
	
	@FindBy(id="continue")
	WebElement continueBtn;
	
	@FindBy(id="ap_password")
	WebElement passwordField;
	
	@FindBy(xpath="//*[@id='signInSubmit']")
	WebElement logInButn;
	
	@FindBy(xpath="//span[contains(text(),'Hello, c')]")
	WebElement hellousr;
	
	@FindBy(xpath = "//*[@id='nav-item-signout']/span")
	 WebElement signout;
	
	@FindBy(xpath = "//*[@id=\'auth-error-message-box\']/div/div/ul/li/span")
	WebElement emailerrMsg;
	
	@FindBy(xpath = "//*[@id=\'auth-error-message-box\']/div/div/ul/li/span")
	WebElement passerrMsg;
	
	public WebElement  helloSignIN(){
		WebElement element= helloSignin;
		System.out.println(element);
		return element;
	}
	
	
	public void clickOnSignIn(){
		
		try{
		signIn.click();
		}
		catch(Exception e){
			e.printStackTrace();
		}
}
	public void enterEmailOrMobileNum(String emailMobileNumber){
		try{
		emailormobileNumField.sendKeys(emailMobileNumber);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void clickOnContine(){
		try{
		 continueBtn.click();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void enterPassword(String password){
		
		try{
		passwordField.sendKeys(password);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	public void clickOnLogin(){
		try{
		logInButn.click();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public String welcomeMsg() {
		return hellousr.getText();
	}
	
	public void signOut() {
		signout.click();
	}
	
	public String errMsg() {
		return emailerrMsg.getText();
	}
	public String passerrMsg() {
		return passerrMsg.getText();
	}
}
