package com.neveenautomation.webtableTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.webtablePages.YourStorePage;

public class YourStoreTest extends TestBase {
	
	YourStorePage ysp;
	
	@BeforeMethod
	public void startBrowserSession() {
		
		initialization();
		
		ysp=new YourStorePage();
	}
	
	@Test
	public void testPage() {
		
		ysp.clickMyAccountBtn();
		
		ysp.clickLoginBtn();
	}
	
	@AfterMethod
	public void quitBrowserSession() {
		
		quitBrowser();
	}

	
	

}
