package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetToolTipValue {
	public static String chromeDriver="webdriver.chrome.driver";
	public static String chromeUrl="D:\\selenium\\Files\\Data\\chromedriver.exe";
	public static String W3SchoolwebSite="https://www.w3schools.com/css/default.asp";
	public static void main(String[] args) {
		System.setProperty(chromeDriver, chromeUrl);
		WebDriver wd=new ChromeDriver();
		wd.get(W3SchoolwebSite);
		WebElement phpele=wd.findElement(By.xpath("//a[text()='PHP']"));
		String phptooltip=phpele.getAttribute("title");
		System.out.println("phptooltip ="+phptooltip);
	}

}
