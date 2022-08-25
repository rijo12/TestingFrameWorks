package com.naveenautomation.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.naveenautomation.base.TestBase;

public class CustomListener extends TestBase implements ITestListener{
	
	@Override 
	public void onTestStart(ITestResult result) {
		
		Logger.info("-----Test Exexcution has started-----"+result.getMethod().getMethodName());
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		
		Logger.info("-----Test Exexcution has passed Successfully-----"+result.getMethod().getMethodName());
	}
	@Override
	public void onTestFailure(ITestResult result) {
		
		Logger.info("-----Test Exexcution has failed and taking ScreenShot-----"+result.getMethod().getMethodName());
		
		Utils.takeFailedTestScreenShots(result.getMethod().getMethodName());
		
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		
		Logger.info("-----Test Exexcution has Skipped-----"+result.getMethod().getMethodName());
		
	}

}
