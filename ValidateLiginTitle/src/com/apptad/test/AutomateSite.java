package com.apptad.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.apptad.comp.WebElements;
import com.apptad.func.Functions;

public class AutomateSite {
	private static WebDriver wd;
	public static void main(String[] args) {
		Functions test=new Functions(wd);
		test.setUpDriver(WebElements.chromeDriver,WebElements.chromeUrl);
		test.openSite(WebElements.webSite);
		test.loginUser("mngr371415","EnUbabA",WebElements.userIdXpathbox,WebElements.passXpathbox,WebElements
				.loginXpathbtn);
		test.closeDriver();
	}
}
