package com.appted.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		System.out.println(product);
		return product;
	}
	
	public void searchItem(WebElement seachBox,WebElement searchBtn,String searchItem) {
		seachBox.sendKeys(searchItem);
		searchBtn.click();
	}
	
	public void validateItemAvailable(WebElement ele) {
		Assert.assertEquals(true,ele.isDisplayed());
		
	}
	public WebElement waitElement(WebDriver driver,WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement eleReturn=wait.until(ExpectedConditions.elementToBeClickable(ele));
		return eleReturn;
	}
	public void stop(int milliSecond) {
		try {
			Thread.sleep(milliSecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
