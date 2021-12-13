package com.amazon.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class CreateDriver {
	public static WebDriver getDriver()
	{
		WebDriver driver = null;
		String browserName = GetData.fromProperties("config","browser");
		String url = GetData.fromProperties("config", "url");
		if(browserName.equalsIgnoreCase("ff"))
		{
			System.setProperty("webdriver.gecko.driver",
					"D:\\study meterial\\AutomationData_new_NEW\\FrameWork\\OSCW-10\\sonar-cubes\\browser_server\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("gc"))
		{
			System.setProperty("webdriver.chrome.driver","F:\\drivernew123\\chromedriver.exe\\");
			driver=new ChromeDriver();
			
		}
		else
		{
			System.out.println("Invalid Browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
}
