package com.naveenautomation.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomations.pages.AccountLoginPage;
import com.naveenautomations.pages.CheckoutPage;
import com.naveenautomations.pages.MyAccountPage;
import com.naveenautomations.pages.MyAccountPasswordPage;
import com.naveenautomations.pages.PhonesAndPDAsPage;
import com.naveenautomations.pages.ShoppingCartPage;
import com.naveenautomations.pages.YourOrderPlacedPage;
import com.naveenautomations.pages.YourStorePage;

public class MyAccountPasswordTest extends TestBase {
	
	YourStorePage yp;

	AccountLoginPage accountlogin;

	MyAccountPage myAccount;

	PhonesAndPDAsPage phoPda;

	ShoppingCartPage scp;

	CheckoutPage check;

	YourOrderPlacedPage yop;
	
	MyAccountPasswordPage mpasspage;


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

	check = scp.checkoutClick();

	check.cointinueBtnClk();

	check.shippingAddressBtnClick();

	check.shippingMethodBtnClick();

	check.checkBoxSelectClick();

	check.paymentMethodBtnClick();
	
	yop=check.confirmButtonClick();
	
	yop.myAccountClick();
	
	mpasspage= yop.myAccountSelectClick();

}

@Test
public void OrderPlacedTest() {
	
	mpasspage.passwordButtonClick();

}

	@AfterMethod
	
	public void quitBrowserSession() {
		
	quitBrowser();
}


}
