package com.naveenautomation.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomations.pages.YourStorePage;

public class YourStoreTest extends TestBase {
	
	YourStorePage yp ;
	
	@BeforeMethod
	public void startBrowserSession() {
		
		initialization();
		
		yp=new YourStorePage();
	}
	
	@Test
	public void test() {
		
		yp.clickMyAccountButton();
		
		yp.clickLoginButton();
	}
	
	@AfterMethod
	public void quitBrowserSession() {
		
		quitBrowser();
	}

}
