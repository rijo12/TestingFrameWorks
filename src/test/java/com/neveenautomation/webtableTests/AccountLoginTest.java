package com.neveenautomation.webtableTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.webtablePages.AccountLoginPage;
import com.naveenautomation.webtablePages.YourStorePage;

public class AccountLoginTest extends TestBase {
	
	YourStorePage ysp;
	
	AccountLoginPage alt;
	
	@BeforeMethod
	public void startBrowserSession() {
		
		initialization();
		
		ysp=new YourStorePage();
		
		ysp.clickMyAccountBtn();
		
		alt=ysp.clickLoginBtn();
	}
	
	@Test
	public void testLogin() {
		
		alt.loginCredentials(prop.getProperty("email_address"),prop.getProperty("password"));
		
		
	}
	
	@AfterMethod
	public void quitBrowserSession() {

		quitBrowser();
	}

}
