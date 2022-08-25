package com.naveenautomations.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class MyAccountPage extends TestBase{
	
	public MyAccountPage() {
		PageFactory.initElements(webDriver, this);
	}

	@FindBy(css = "#content h2")
	private WebElement myaccountText;
	
	
	@FindBy(css="ul.nav.navbar-nav>li:nth-of-type(6) a")
	private WebElement phonePurchase;

	public String getTextFromMyAccount() {
		return myaccountText.getText();
	}
	
	public PhonesAndPDAsPage clickPhonePurchase() {
		
		phonePurchase.click();
		
		return new PhonesAndPDAsPage();
	}
	
	

}
