package com.naveenautomation.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomations.pages.AccountLoginPage;
import com.naveenautomations.pages.MyAccountPage;
import com.naveenautomations.pages.PhonesAndPDAsPage;
import com.naveenautomations.pages.YourStorePage;

public class PhonesAndPDAsTest extends TestBase {

	YourStorePage yp;

	AccountLoginPage accountlogin;

	MyAccountPage myAccount;

	PhonesAndPDAsPage phoPda;

	@BeforeMethod
	public void startBrowserSession() {

		initialization();

		yp = new YourStorePage();

		yp.clickMyAccountButton();
		
		accountlogin = yp.clickLoginButton();

		myAccount = accountlogin.login("anoopvadakkan@gmail.com", "Anoop12#");

		phoPda = myAccount.clickPhonePurchase();

	}

	@Test
	public void phoneSelect() {

		phoPda.phoneClick();

		phoPda.cart();

		phoPda.shoppingCartBtn();

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}
}
