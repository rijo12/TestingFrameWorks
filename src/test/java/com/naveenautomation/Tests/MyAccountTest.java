package com.naveenautomation.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomations.pages.AccountLoginPage;
import com.naveenautomations.pages.MyAccountPage;
import com.naveenautomations.pages.YourStorePage;

public class MyAccountTest extends TestBase{
	
	YourStorePage yp;

	AccountLoginPage accountlogin;
	
	MyAccountPage myAccount;

	@BeforeMethod
	public void startBrowserSession() {

		initialization();

		yp = new YourStorePage();

		yp.clickMyAccountButton();
		
		accountlogin = yp.clickLoginButton();

		myAccount= accountlogin.login("anoopvadakkan@gmail.com", "Anoop12#");
		
	}
	
	@Test
	public void testphonePurchase() {
		
		myAccount.clickPhonePurchase();
		
	}
	
	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
