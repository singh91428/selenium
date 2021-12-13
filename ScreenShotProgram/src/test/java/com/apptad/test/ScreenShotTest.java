package com.apptad.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.apptad.helper.CreateDriver;
import com.apptad.helper.ScreenShot;
@Listeners(ScreenShot.class)
public class ScreenShotTest extends CreateDriver{
	WebDriver wd;
	
	@BeforeClass
	public void test() {
		getDriver();
	}
	@Test
	public void firstTest() {
		Assert.assertEquals(false, true);
	}
	@Test
	public void ss_01() {
		Assert.assertEquals(true, false);
	}
}
