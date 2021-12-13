package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GetToolTipValueOnMouseHoverOnBtn {
	public static String chromeDriver="webdriver.chrome.driver";
	public static String chromeUrl="D:\\selenium\\Files\\Data\\chromedriver.exe";
	public static String guru99webSite="http://demo.guru99.com/test/tooltip.html";
	public static void main(String[] args) throws InterruptedException {
		System.setProperty(chromeDriver, chromeUrl);
		WebDriver wd=new ChromeDriver();
		wd.navigate().to(guru99webSite);
		WebElement downloadbtn=wd.findElement(By.xpath("//a[contains(text(),'Download now')]"));
		Actions act=new Actions(wd);
		act.moveToElement(downloadbtn).perform();
		Thread.sleep(2000);
		String actualResult=wd.findElement(By.xpath("//*[@id='demo_content']/div/div/div/a")).getText();
		String expectedResult="What's new in 3.2";
		if(actualResult.equalsIgnoreCase(expectedResult))
			System.out.println("Actual Result And Expedted Result are matched So test case passed");
		else
			System.out.println("Actual Result And Expedted Result are not matched so test case Failed");
		wd.close();
	}

}
