package com.appted.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ActionsOnPageOrderItem {
	
	public void sendDataToInput(WebElement ele,String data) {
		ele.sendKeys(data);
	}
	
	public void hoverOnElement(WebDriver driver,WebElement ele) {
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	public void stop(int milliSecond) {
		try {
			Thread.sleep(milliSecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
	
	public void scrollDown(WebDriver driver,int scrollPixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+scrollPixel+")", "");
	}
	
	public void selectFromDropDown(WebElement ele,String val) {
		Select sel=new Select(ele);
		sel.selectByValue(val);
	}
	
	public WebElement getLoadedElement(WebDriver driver,WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void wishListValidate(WebDriver driver, WebElement ele,String expectedResult) {
		Assert.assertEquals(new ActionsOnPageOrderItem().getLoadedElement(driver, ele).getText(),expectedResult);
		
	}
}
