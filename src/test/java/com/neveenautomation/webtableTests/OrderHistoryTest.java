package com.neveenautomation.webtableTests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.webtablePages.AccountLoginPage;
import com.naveenautomation.webtablePages.MyAccountPage;
import com.naveenautomation.webtablePages.OrderHistoryPage;
import com.naveenautomation.webtablePages.OrderHistoryPage.OrderHistoryTable;
import com.naveenautomation.webtablePages.YourStorePage;


public class OrderHistoryTest extends TestBase {
	
	YourStorePage ysp;

	AccountLoginPage alt;

	MyAccountPage map;
	
	OrderHistoryPage order;
	
	@BeforeMethod
	public void startBrowserSession() {

		initialization();

		ysp = new YourStorePage();

		ysp.clickMyAccountBtn();

		alt = ysp.clickLoginBtn();

		map = alt.loginCredentials(prop.getProperty("email_address"),prop.getProperty("password"));
		
		order=map.viewYourOrderHistoryClick();
	}
	
	@Test
	public void orderTest() {

		WebElement element = order.getCellFromCustomerTable("#1467", OrderHistoryTable.DATEADDED);
		
		System.out.println(element.getText());

	}

	@AfterMethod
	public void quitBrowserSession() {

		quitBrowser();
	}

}
