package apptad.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestChecking {
	@BeforeClass
	public void beforeClassTest() {
		System.out.println("@BeforeClass Annotation Method");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("@BeforeTest Annotation Method Case1");
	}
	@BeforeTest
	public void beforeTest1() {
		System.out.println("@BeforeTest Annotation Method Case2");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("after Test Case");
	}
	@Test
	public void firstTest() {
		System.out.println("First Test Case");
	}
	@BeforeMethod
	public void beforemethodTest() {
		System.out.println("Test Start");
	}
	@Test
	public void secondTest() {
		System.out.println("Second Test Case");
	}
}
