package com.naveenautomation.webtablePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;


public class YourStorePage extends TestBase {
	
	
	public YourStorePage(){
		
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(css = "#top-links ul li:nth-of-type(2) span:first-of-type")
	private WebElement myAccountBtn;

	@FindBy(css = "#top-links ul.dropdown-menu li:last-of-type")
	private WebElement loginBtn;

	public void clickMyAccountBtn() {

		myAccountBtn.click();
	}

	public AccountLoginPage clickLoginBtn() {

		loginBtn.click();

		return new AccountLoginPage();
	}

}
