package apptad.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAndAfterMethodTesting {
	@BeforeMethod
	public static void beforeMethodTest() {
		System.out.println("@BeforeMethod Logic-----");
	}
	@AfterMethod
	public static void afterMethodTest() {
		System.out.println("@AfterMethod Logic-----");
	}
	@Test(description = "this is test case 1")
	public static void testCase1() {
		System.out.println("Test case 1");
	}
	@Test(priority =-1)
	public static void testCase2() {
		System.out.println("Test case 2");
	}
}
