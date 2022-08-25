package com.naveenautomation.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomations.pages.AccountLoginPage;
import com.naveenautomations.pages.MyAccountPage;
import com.naveenautomations.pages.YourStorePage;

public class AccountLoginTest extends TestBase {
	
	YourStorePage yp;

	AccountLoginPage accountlogin;

	@BeforeMethod
	public void startBrowserSession() {

		initialization();

		yp = new YourStorePage();

		yp.clickMyAccountButton();

		accountlogin = yp.clickLoginButton();
	}

	@Test
	public void verifyCustomerLogin() {

		MyAccountPage pageText= accountlogin.login("anoopvadakkan@gmail.com", "Anoop12#");
		
		Assert.assertEquals(pageText.getTextFromMyAccount(), "My Account");

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}
	
}
