package com.naveenautomations.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class ShoppingCartPage extends TestBase {

	public ShoppingCartPage() {

		PageFactory.initElements(webDriver, this);

	}

	@FindBy(css = "div.buttons.clearfix>div:nth-of-type(2) a")
	private WebElement checkOutBtn;
	
	public CheckoutPage checkoutClick() {
		
		checkOutBtn.click();
		
		return new CheckoutPage();
		
		
	}

}
