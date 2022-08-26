package com.neveenautomation.webtableTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.webtablePages.AccountLoginPage;
import com.naveenautomation.webtablePages.MyAccountPage;
import com.naveenautomation.webtablePages.YourStorePage;

public class MyAccountPageTest extends TestBase {

	YourStorePage ysp;

	AccountLoginPage alt;

	MyAccountPage map;

	@BeforeMethod
	public void startBrowserSession() {

		initialization();

		ysp = new YourStorePage();

		ysp.clickMyAccountBtn();

		alt = ysp.clickLoginBtn();

		map = alt.loginCredentials("anoopvadakkan@gmail.com", "Anoop12#");
	}

	@Test
	public void testLogin() {

		map.viewYourOrderHistoryClick();

	}

	@AfterMethod
	public void quitBrowserSession() {

		quitBrowser();
	}

}
