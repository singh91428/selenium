package com.appted.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.appted.actions.ActionsOnPageOrderItem;

public class EcommercePage1 extends ActionsOnPageOrderItem{
	WebDriver driver;
	public EcommercePage1(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath = "//*[@id=\'header\']/div[2]/div/div/nav/div[1]/a")
	WebElement signInBtn;
	
	@FindBy(id = "email")
	WebElement emailInputLogin;
	
	@FindBy(id = "passwd")
	WebElement passInputLogin;
	
	@FindBy(id = "SubmitLogin")
	WebElement signInBtnLogin;
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[1]/a")
	WebElement womenTab;
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[1]/a")
	WebElement womenTab_t_srt;
	
	@FindBy(xpath = "//*[@id=\'center_column\']/ul/li/div/div[2]/h5/a")
	WebElement product;
	
	@FindBy(xpath = "//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[2]")
	WebElement moreBtn;
	
	@FindBy(xpath = "//*[@id='quantity_wanted_p']/a[2]")
	WebElement qtyBtn;
	
	@FindBy(id="group_1")
	WebElement itemSizeDd;
	
	@FindBy(id = "color_14")
	WebElement blueColorBtn;
	
	@FindBy(xpath = "//*[@id='add_to_cart']/button")
	WebElement addtoCartBtn;
	
	@FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a")
	WebElement proceeddBtn;
	
	@FindBy(xpath = "//*[@id='center_column']/p[2]/a[1]")
	WebElement proceedBtnSummary;
	
	@FindBy(id = "addressesAreEquals")
	WebElement addressbillAndDeliveryChk;
	
	@FindBy(xpath = "//button[@name='processAddress']//span")
	WebElement proceedBtnAddress;
	//*[@id="center_column"]/form/p/button/span
	@FindBy(id="cgv")
	WebElement agreeShipping;
	
	@FindBy(xpath = "//*[@id='form']/p/button")
	WebElement proceedBtnShipping;
	
	@FindBy(xpath = "//*[@id='HOOK_PAYMENT']/div[1]/div/p/a")
	WebElement paymentPayByBank;
	
	@FindBy(xpath = "//*[@id='cart_navigation']/button")
	WebElement conformOrder;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[3]/div[1]/a")
	WebElement wishList;
	
	@FindBy(xpath = "//*[@id=\"category\"]/div[2]/div/div/div/div/p")
	WebElement wishListError;
	
	@FindBy(xpath = "//a[@title='Add']")
	WebElement addItem;
	
	public void buyProduct(WebDriver driver) {
//		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		clickOnElement(signInBtn);
		sendDataToInput(getLoadedElement(driver,emailInputLogin), "singh9145455@gmail.com");
		sendDataToInput(getLoadedElement(driver,passInputLogin), "chandrakr");
		stop(300);
		clickOnElement(signInBtnLogin);
		hoverOnElement(driver, womenTab);
		stop(1000);
		clickOnElement(womenTab_t_srt);
		scrollDown(driver,750);
		hoverOnElement(driver, product);
		stop(1000);
		clickOnElement(moreBtn);
		scrollDown(driver, 350);
		stop(200);
		clickOnElement(qtyBtn);
		stop(200);
		selectFromDropDown(itemSizeDd, "3");
		stop(200);
		clickOnElement(blueColorBtn);
		stop(200);
		clickOnElement(addtoCartBtn);
		scrollDown(driver, 650);
		clickOnElement(getLoadedElement(driver,proceeddBtn));
		scrollDown(driver, 750);
		stop(200);
		clickOnElement(getLoadedElement(driver,proceedBtnSummary));
		scrollDown(driver, 750);
		stop(200);
		clickOnElement(getLoadedElement(driver,addressbillAndDeliveryChk));
		scrollDown(driver, 850);
		stop(200);
		//clickOnElement(proceedBtnAddress); ====
		//proceedBtnAddress.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		clickOnElement(getLoadedElement(driver, proceedBtnAddress));
		scrollDown(driver, 750);
		stop(200);
		clickOnElement(getLoadedElement(driver,agreeShipping));
		scrollDown(driver, 750);
		stop(200);
		clickOnElement(getLoadedElement(driver,proceedBtnShipping));
		scrollDown(driver, 750);
		stop(200);
		clickOnElement(getLoadedElement(driver,paymentPayByBank));
		scrollDown(driver, 750);
		stop(200);
		clickOnElement(getLoadedElement(driver,conformOrder));
	}
	public void wishList(WebDriver driver) {
		hoverOnElement(driver, womenTab);
		stop(1000);
		clickOnElement(womenTab_t_srt);
		scrollDown(driver,750);
		hoverOnElement(driver, product);
		stop(1000);
		clickOnElement(wishList);
		wishListValidate(driver,wishListError, "You must be logged in to manage your wishlist.");
	}
	public void verifyPrice(WebDriver driver) {
		clickOnElement(signInBtn);
		sendDataToInput(getLoadedElement(driver,emailInputLogin), "singh9145455@gmail.com");
		sendDataToInput(getLoadedElement(driver,passInputLogin), "chandrakr");
		clickOnElement(signInBtnLogin);
		hoverOnElement(driver, womenTab);
		clickOnElement(womenTab_t_srt);
		hoverOnElement(driver, product);
		clickOnElement(moreBtn);
		//clickOnElement(qtyBtn);
		selectFromDropDown(itemSizeDd, "2");
		clickOnElement(blueColorBtn);
		clickOnElement(addtoCartBtn);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		clickOnElement(getLoadedElement(driver,proceeddBtn));
		scrollDown(driver, 550);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		addItem.click();
		stop(2000);
	}
}
