package com.appted.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ActionsOnPageSerchItem {
	
	public void hoverOnElement(WebDriver driver,WebElement ele) {
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	public void clickOnElement(WebElement ele) {
		ele.click();
	}
	
	public String productName(WebElement ele) {
		String product=ele.getText();
		return product;
	}
	
	public void searchItem(WebElement seachBox,WebElement searchBtn,String searchItem) {
		seachBox.sendKeys(searchItem);
		searchBtn.click();
	}
	
	public void validateItemAvailable(WebElement ele) {
		Assert.assertEquals(true,ele.isDisplayed());
		
	}
}
