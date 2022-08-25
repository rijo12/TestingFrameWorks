package com.naveenautomations.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class CheckoutPage extends TestBase {
	
	public CheckoutPage() {
		
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(id="button-payment-address")
	private WebElement continueBtn;
	
	@FindBy(id="button-shipping-address")
	private WebElement shippingAddressBtn;
	
	@FindBy(id="button-shipping-method")
	private WebElement shippingMethodBtn;
	
	@FindBy(css="#collapse-payment-method div:nth-of-type(2) input")
	private WebElement checkBoxSelect;
	
	@FindBy(id="button-payment-method")
	private WebElement paymentMethodBtn;
	
	@FindBy(id="button-confirm")
	private WebElement confirmBtn;
	
	public void cointinueBtnClk() {
		
		continueBtn.click();
	}
	public void shippingAddressBtnClick() {
		
		shippingAddressBtn.click();
	}
	public void shippingMethodBtnClick() {
		
		shippingMethodBtn.click();
	}
	
	public void checkBoxSelectClick() {
		
		checkBoxSelect.click();
	}
	
	public void paymentMethodBtnClick() {
		
		paymentMethodBtn.click();
	}
	
	public YourOrderPlacedPage  confirmButtonClick() {
		
		confirmBtn.click();
		
		return new YourOrderPlacedPage();
	}

}
