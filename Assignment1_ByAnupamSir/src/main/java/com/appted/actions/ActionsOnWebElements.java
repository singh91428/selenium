package com.appted.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ActionsOnWebElements {
	public void click(WebElement ele) {
		ele.click();
	}
	public void sendDataToInput(WebElement ele,String data) {
		ele.sendKeys(data);
	}
	public void clickOnRadioBtn(WebDriver driver,WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement selectGender = wait.until(ExpectedConditions.elementToBeClickable(ele));
		selectGender.click();
	}
	
	public void selectFromDropdown(WebElement ele,String text) {
		Select select=new Select(ele);
		select.selectByValue(text);
	}
	
	public void validate(WebElement ele,String expectedResult) {
		String actualResult=ele.getText();
		//Assert.assertEquals(actualResult,expectedResult);
		System.out.println(actualResult);
	}
	public void validateEmail(WebDriver driver,WebElement ele,String expectedResult) {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement error1=wait.until(ExpectedConditions.elementToBeClickable(ele));
		String actualResult=error1.getText();
		Assert.assertEquals(actualResult,expectedResult);
	}
	public void validateMandatoryFields(WebDriver driver,WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement error1=wait.until(ExpectedConditions.elementToBeClickable(ele));
		Assert.assertEquals(error1.isDisplayed(),true);
	}
	
	
	public WebElement waitElement(WebDriver driver,WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement eleReturn=wait.until(ExpectedConditions.elementToBeClickable(ele));
		return eleReturn;
	}
}
