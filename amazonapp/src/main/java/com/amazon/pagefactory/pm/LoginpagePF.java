package com.amazon.pagefactory.pm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginpagePF {
	WebDriver driver;
	@FindBy(xpath="//span[contains(text(),'Hello, Sign in')]")
	WebElement helloSignIn;
	
	@FindBy(xpath="//div[@id='nav-flyout-ya-signin']//span[1]")
	WebElement siginbtn;
	
	@FindBy(id="ap_email")
	WebElement emailorphone;
	
	@FindBy(id="continue")
	WebElement continuebtn;
	
	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement loginbt;
	
	
	
	
	public LoginpagePF(WebDriver driver){
		this.driver=driver;
	}
	
	public void mousehover(){
		Actions act=new Actions(driver);
		act.moveToElement(helloSignIn).perform();
		siginbtn.click();
		
	}
	
	public void loginapp(String user,String pass){
		emailorphone.sendKeys(user);
		continuebtn.click();
		password.sendKeys(pass);
		loginbt.click();
		
		
	}

}
