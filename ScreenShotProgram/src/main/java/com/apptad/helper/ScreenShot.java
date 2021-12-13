package com.apptad.helper;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenShot extends CreateDriver implements ITestListener{
	public void onTestFailure(ITestResult result) {
		failed(result.getMethod().getMethodName());
	}
}
