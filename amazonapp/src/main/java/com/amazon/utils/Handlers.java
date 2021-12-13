package com.amazon.utils;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Handlers {
	public static WebDriver driver;
	/*
	public static void acceptAlert(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}
	public static void dismissAlert(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}
	public static String getAlertText(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		String text = alt.getText();
		return text;
	}
	public static void enterTextToAlert(WebDriver driver, String data)
	{
		Alert alt = driver.switchTo().alert();
		alt.sendKeys(data);
	}
	public static void selectDDLByIndex(WebElement element, int index)
	{
		Select sct = new Select(element);
		sct.selectByIndex(index);
	}
	public static void selectDDLByText(WebElement element, String text)
	{
		Select sct = new Select(element);
		sct.selectByVisibleText(text);
	}
	public static void selectDDLByValue(WebElement element, String value)
	{
		Select sct = new Select(element);
		sct.selectByValue(value);
	}
	public static boolean isDDLMultiple(WebElement element) 
	{
		Select sct = new Select(element);
		boolean status = sct.isMultiple();
		return status;
	}

	public static void ActionsmoveToElement(WebElement ele,WebDriver driver){
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();

	}

	public static void wait(int i){
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	/**
	 * This Method is used to max browser
	 * 
	 */
	public static void maxmizeBrowser(){
		try {
		driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * This Method is used to close borwser
	 * 
	 */
	public static void closeBrowser(){
		driver.close();
	}

	/**
	 * This Method is used to compare String
	 * @param actual is String Type
	 * @param Expected is String Type
	 */
	public static void compareString(String actual,String expected){
		if(actual.equals(expected)){
			System.out.println("************ Test Cased is passed ***********");
		}

		else{
			System.out.println("************ Test Cased is Failed ***********");
		}

	}

	/**
	 * This Method is used to Select RadioButton & Checkbox
	 * @param WebElemet is ele para
	 *
	 * 
	 */

	public static WebElement veifySelected(WebElement ele){
		ele.click();
		boolean status=ele.isSelected();
		if(status){
			//System.out.println("Radio button is selected");
			System.out.println("Check box is selected");
		}

		else{
			//System.out.println("Radio button is not selected");
			System.out.println("Check box is selected");
		}
		return ele;
	}

	/**
	 * This Method is used to wait certain amount of time
	 * @param integer type
	 *
	 * 
	 */
	public static void implicitWait(int a){
		driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);

	}
	/**
	 * This Method is used to wait specific Element 
	 * @param integer type
	 *
	 * 
	 */
	public static WebElement explicityWait(WebDriver driver,int a,String str){
		WebDriverWait wait=new WebDriverWait(driver, a);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(str)));

	}
	/**
	 * This Method is used to Fluent Wait 
	 * @param integer type
	 *
	 * 
	 */

	public static WebElement fluentWait(WebDriver driver,int a,int b,String xpath ){
		Wait<WebDriver> wait =new FluentWait(driver)
				.withTimeout(a,TimeUnit.SECONDS)
				.pollingEvery(b,TimeUnit.SECONDS)
				.ignoring(NoSuchFieldException.class);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

	}
	/**
	 * This Method is used to Select First options
	 * @param  WebElement type
	 *
	 * 
	 */
	public static void selectFirstOption(WebElement ele){
		try {
			Select sel=new Select(ele);
			WebElement ele1=sel.getFirstSelectedOption();
			String strgetption=ele1.getText();
			System.out.println("strgetption...." + strgetption);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * This Method is used to Select list of dropdonw
	 * @param  WebElement type
	 *
	 * 
	 */


	public static void listOfDroDown(WebElement ele){
		Select sel=new Select(ele);
		List<WebElement> listofEle=sel.getOptions();
		for(int i=0;i<listofEle.size();i++){
			String str=listofEle.get(i).getText();
			System.out.println("str.." + str);
		}
	}

	/**
	 * This Method is used to Select as index 
	 * @param  WebElement type and integer type
	 *
	 * 
	 */
	public static void selectByIndexEle(WebElement ele,int index){
		Select sel=new Select(ele);
		sel.selectByIndex(index);
	}


	/**
	 * This Method is used to Select as value 
	 * @param  WebElement type and String type
	 *
	 * 
	 */
	public static void selectByValueEle(WebElement ele,String str){
		Select sel=new Select(ele);
		sel.selectByValue(str);
	}

	/**
	 * This Method is used to Select as text 
	 * @param  WebElement type and String type
	 *
	 * 
	 */
	public static void selectByTextEle(WebElement ele,String str){
		Select sel=new Select(ele);
		sel.selectByVisibleText(str);
	}

	/**
	 * This Method is used to mousehover
	 * @param  WebElement type 
	 *
	 * 
	 */

	public static void mouseHoverEle(WebElement ele){
		try {
			Actions act=new Actions(driver);
			act.moveToElement(ele).perform();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This Method is used to click using mousehover
	 * @param  WebElement type and WebDriver
	 *
	 * 
	 */
	public static void mouseOverClick(WebDriver driver,WebElement ele){
		Actions act=new Actions(driver);
		act.moveToElement(ele).click().perform();


	}


	/**
	 * This Method is used to perform darag and drop operation
	 * @param  WebElement type and WebDriver
	 *
	 * 
	 */
	public static void dragandDrop(WebDriver driver,WebElement ele1,WebElement ele2){
		Actions act=new Actions(driver);
		act.dragAndDrop(ele1, ele2).build().perform();

	}

	/**
	 * This Method is used to perform offSet for x & Y coordinate
	 * @param  WebElement type is ele , WebDriver  & integer type
	 *
	 * 
	 */

	public static void mouseHoverOffSet(WebDriver driver,WebElement ele,int x,int y){

		Actions act=new Actions(driver);
		act.moveToElement(ele, x, y);

	}

	/**
	 * This Method is used to Get String text on Alert Pop'up
	 * @param WebDriver  
	 *
	 * 
	 */
	public static String getTextAlert(WebDriver driver){
		Alert alt=driver.switchTo().alert();
		String str=alt.getText();
		System.out.println(str);
		return str;
	}
	/**
	 * This Method is used to Click on alert Pop'up
	 * @param WebDriver  
	 *
	 * 
	 */

	public static void acceptAlert(WebDriver driver){
		Alert alt=driver.switchTo().alert();
		alt.accept();
	}

	/**
	 * This Method is used to click on cancel button 
	 * @param WebDriver  
	 *
	 * 
	 */

	public static void dismissAlert(WebDriver driver){
		Alert alt=driver.switchTo().alert();
		alt.dismiss();
	}
	/**
	 * This Method is used to get parent window id
	 * @param WebDriver  
	 *
	 * 
	 */

	public static String getParentWindowId(WebDriver driver){
		return driver.getWindowHandle();
	}
	/**
	 * This Method is used to get Child window id
	 * @param WebDriver  
	 *
	 * 
	 */

	public static void getchiedWindow(WebDriver driver){

		String parentwindowId=getParentWindowId(driver);
		Set<String> set=driver.getWindowHandles();
		Iterator<String> itr= set.iterator();
		while(itr.hasNext()){
			String childWindow=itr.next();
			if(!parentwindowId.equals(childWindow)){
				driver.switchTo().window(childWindow);
			}


		}

	}
	/**
	 * This Method is used to switch on window
	 * @param String type
	 *
	 * 
	 */


	public static void switchtoWindow(String str ){
		driver.switchTo().window(str);
	}
	/**
	 * This Method is used to scroll the window
	 * @param String type
	 *
	 * 
	 */

	public static void windowScroll(WebDriver driver,String str){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(str);
	}

	/**
	 * This Method is used to find the no of frame
	 * @param String type
	 *
	 * 
	 */


	public static int noOfFrame(WebDriver driver){
		int size=driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		return size;

	} 

	/**
	 * This Method is used to find switch window using id and name
	 * @param String type
	 *
	 * 
	 */

	public static void switchFramByid(WebDriver driver,String str){
		driver.switchTo().frame(str);
	}

	/**
	 * This Method is used to switch in default window 
	 * @param String type
	 *
	 * 
	 */

	public static void switchDefaultWindow(WebDriver driver){
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This Method is used to select Date 
	 * @param WebDriver,String type
	 *
	 * 
	 */
	
	public static void selectDate(WebDriver driver,String value,String xpathValue){
		List<WebElement> listOfValue=driver.findElements(By.xpath(xpathValue));
		for(int i=0;i<listOfValue.size();i++){
			String strist=listOfValue.get(i).getText();
			System.out.println("strist.."+ strist);
			if(strist.equals(value)){
				listOfValue.get(i).click();
				break;
				
			}

   
			
			
		}
		
	}
	public static String verifytitleOfpage(String  expectedTitle){
		String actualTitleOfPage=driver.getTitle();
		System.out.println("gettitle::" + actualTitleOfPage);
		if(actualTitleOfPage.equals(expectedTitle)){
			Assert.assertEquals(actualTitleOfPage, expectedTitle);
			System.out.println("Tilte is Matched & TesCase is Passed");
		}
		else{
			System.out.println("Tilte is Not Matched & TesCase is Failed");
			Assert.assertTrue(false,"Title is Not matching");
		}
		return actualTitleOfPage;
	}




}
