package com.appted.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.appted.actions.ActionsOnPageSerchItem;

public class SearchProduct extends ActionsOnPageSerchItem{
	WebDriver driver;
	public SearchProduct(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[1]/a")
	WebElement womenTab;
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[1]/a")
	WebElement womenTab_t_srt;
	
	@FindBy(xpath = "//a[@title='Faded Short Sleeve T-shirts']")
	WebElement product;
	
	@FindBy(id="search_query_top")
	WebElement searchBox;
	
	@FindBy(xpath = "//*[@id=\'searchbox\']/button")
	WebElement searchBtn;
	
	@FindBy(id="search")
	WebElement itemResult;
	
	public void scenenario_02() {
		hoverOnElement(driver, womenTab);
		clickOnElement(womenTab_t_srt);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//String searchProduct=productName(product);
		searchItem(searchBox, searchBtn,product.getText());
		validateItemAvailable(itemResult);
	}
}
