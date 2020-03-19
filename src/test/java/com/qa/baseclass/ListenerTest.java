package com.qa.baseclass;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenerTest implements ITestListener {
	private static ExtentTest test;

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult testResult) {
		test.log(Status.FAIL, "Test failed: " + testResult.getName());
		test.log(Status.FAIL, "Test failed with exception: " + testResult.getThrowable());
	}

	public void onTestSkipped(ITestResult testResult) {
		test.log(Status.SKIP, "Test passed: " + testResult.getName());
	}

	public void onTestStart(ITestResult testResult) {
		test = BaseTest.getReport().createTest("Verify "+testResult.getName());
	}

	public void onTestSuccess(ITestResult testResult) {
		test.log(Status.PASS, "Test passed: " + testResult.getName());
	}
}
