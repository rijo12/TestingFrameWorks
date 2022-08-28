package com.naveenautomation.excelSignupTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.excelSignupPages.YourStorePage;

public class YourStoreTest extends TestBase {
	
	YourStorePage ysp;
	
	@BeforeMethod
	public void startBrowserSession() {
		
		initialization();
		
		ysp=new YourStorePage();
	}
	
	@Test
	public void test() {
		
		ysp.myAccountClick();
		
		ysp.registerBtnClick();
	}
	
	@AfterMethod
	public void quitBrowserSession() {
		
		quitBrowser();
	}

}
