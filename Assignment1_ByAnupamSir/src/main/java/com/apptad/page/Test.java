package com.apptad.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {
	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\Files\\Data\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\'header\']/div[2]/div/div/nav/div[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\'email_create\']")).sendKeys("gfhf65567ghjg");
		driver.findElement(By.xpath("//*[@id=\'SubmitCreate\']")).click();
		By error=By.xpath("//div[@id='create_account_error']/ol/li");
		WebDriverWait wair=new WebDriverWait(driver, 30);
		WebElement error1=wair.until(ExpectedConditions.elementToBeClickable(error));
		boolean txt=error1.isDisplayed();
		boolean txt1=error1.isEnabled();
		boolean txt2=error1.isSelected();

		System.out.println(txt);
		System.out.println(txt1);
		System.out.println(txt2);

	}

}
