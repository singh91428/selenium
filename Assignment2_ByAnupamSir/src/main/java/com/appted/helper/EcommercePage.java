package com.appted.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EcommercePage extends ActionsOnPage{
	WebDriver driver;
	public EcommercePage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[1]/a")
	WebElement womenTab;
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[1]/a")
	WebElement womenTab_t_srt;
	
	@FindBy(xpath = "//*[@id=\'center_column\']/ul/li/div/div[2]/h5/a")
	WebElement product;
	
	@FindBy(id="search_query_top")
	WebElement searchBox;
	
	@FindBy(xpath = "//*[@id=\'searchbox\']/button")
	WebElement searchBtn;
	
	@FindBy(id="search")
	WebElement itemResult;
	
	public void scenenario_02(WebDriver driver) {
		hoverOnElement(driver, womenTab);
		clickOnElement(womenTab_t_srt);
		String searchProduct=productName(product);
		searchItem(searchBox, searchBtn, searchProduct);
		validateItemAvailable(itemResult);
	}
}
