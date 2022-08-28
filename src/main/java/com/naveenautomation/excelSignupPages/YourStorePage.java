package com.naveenautomation.excelSignupPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class YourStorePage extends TestBase {
	
	public YourStorePage() {
		
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(css="#top-links ul li:nth-of-type(2) span:first-of-type")
	private WebElement myAccount;
	
	@FindBy(css="#top-links ul li:nth-of-type(2) ul a")
	private WebElement registerbtn;
	
	
	public void myAccountClick() {
		
		myAccount.click();
	}
	
	public RegisterAccountPage registerBtnClick() {
		
		registerbtn.click();
		
		return new RegisterAccountPage();
	}

}
