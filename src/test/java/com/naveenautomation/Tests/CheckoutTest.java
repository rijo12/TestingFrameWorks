package com.naveenautomation.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomations.pages.AccountLoginPage;
import com.naveenautomations.pages.CheckoutPage;
import com.naveenautomations.pages.MyAccountPage;
import com.naveenautomations.pages.PhonesAndPDAsPage;
import com.naveenautomations.pages.ShoppingCartPage;
import com.naveenautomations.pages.YourOrderPlacedPage;
import com.naveenautomations.pages.YourStorePage;

public class CheckoutTest extends TestBase {

	YourStorePage yp;

	AccountLoginPage accountlogin;

	MyAccountPage myAccount;

	PhonesAndPDAsPage phoPda;

	ShoppingCartPage scp;

	CheckoutPage check;
	
	YourOrderPlacedPage yop;

	@BeforeMethod
	public void startBrowserSession() {

		initialization();

		yp = new YourStorePage();

		yp.clickMyAccountButton();

		accountlogin = yp.clickLoginButton();

		myAccount = accountlogin.login("anoopvadakkan@gmail.com", "Anoop12#");

		phoPda = myAccount.clickPhonePurchase();

		phoPda.phoneClick();

		phoPda.cart();

		scp = phoPda.shoppingCartBtn();
		
		check=scp.checkoutClick();

	}

	@Test
	public void checkoutTest() {
		
		check.cointinueBtnClk();
		
		check.shippingAddressBtnClick();
		
		check.shippingMethodBtnClick();
		
		check.checkBoxSelectClick();
		
		check.paymentMethodBtnClick();
		
		YourOrderPlacedPage yop= check.confirmButtonClick();
		
		Assert.assertEquals(yop.orderMessage(), "Your order has been placed!");
		
		
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}
}
