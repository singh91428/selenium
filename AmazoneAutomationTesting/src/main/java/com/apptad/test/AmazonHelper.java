package com.apptad.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonHelper {
	@FindBy(xpath = "//*[@id=\'nav-link-accountList-nav-line-1\']")
	public static WebElement helloSignIntext;
}
