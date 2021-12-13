package com.amazon.pagefactory.pm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.amazon.utils.Handlers;

public class LoginPage extends Handlers {
	@FindBy(xpath="//span[contains(text(),'Hello, Sign in')]")
	WebElement hellosignIn;

	@FindBy(xpath="//div[@id='nav-flyout-ya-signin']/a/span")
	WebElement signInBtn;

	@FindBy(id="ap_email")
	WebElement emailorPhoneNumtextbox;

	@FindBy(id="continue")
	WebElement continuebtn;

	@FindBy(id="ap_password")
	WebElement password;

	@FindBy(id="signInSubmit")
	WebElement signInBtnpass;

	public void mouseHover(){
		Handlers.mouseHoverEle(hellosignIn);
	}

	public void loginPage(String userName,String Password){
		mouseHover();
		signInBtn.click();
		emailorPhoneNumtextbox.sendKeys(userName);
		continuebtn.click();
		password.sendKeys(Password);
		signInBtnpass.click();

	}




}
