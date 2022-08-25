package com.naveenautomations.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class PhonesAndPDAsPage extends TestBase {
	
	public PhonesAndPDAsPage() {
		
		PageFactory.initElements(webDriver, this);
	}
	@FindBy(css="div.product-thumb>div:nth-of-type(2)>div:nth-of-type(2) button")
	private WebElement htcPhoneAddToCart;
	
	@FindBy(css="div.col-sm-3 button")
	private WebElement cartView;
	
	
	@FindBy(css="ul.list-inline>li:nth-of-type(4) a span")
	private WebElement shoppingCart;
	
	
	public void phoneClick() {
		
		htcPhoneAddToCart.click();
	}
	
	public void cart() {
		
		cartView.click();
	}
	
	public ShoppingCartPage shoppingCartBtn() {
		
		shoppingCart.click();
		
		return new ShoppingCartPage();
	}
	
}
