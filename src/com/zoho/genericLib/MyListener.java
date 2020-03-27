package com.zoho.genericLib;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class MyListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log(result.getName()+" Test Started",true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getName()+" Test Passed",true);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log(result.getName()+" Test Failed",true);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log(result.getName()+" Test Skipped",true);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log(context.getName()+" Excecution Started",true);
		
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log(context.getName()+" Excecution Finished",true);
		
	}

}
