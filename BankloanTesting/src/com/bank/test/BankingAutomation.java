package com.bank.test;

import com.bank.comp.BrowserComponents;
import com.bank.func.BrowserFunctionality;

public class BankingAutomation {

	public static void main(String[] args) {
		BrowserFunctionality.setUpBrowser(BrowserComponents.ffd,BrowserComponents.ffurl);
		BrowserFunctionality.openFireFoxBrowser(BrowserComponents.banksite);
		try {
			BrowserFunctionality.loginSite();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}