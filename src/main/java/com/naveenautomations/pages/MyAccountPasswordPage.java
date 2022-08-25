package com.naveenautomations.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class MyAccountPasswordPage extends TestBase {
	
	
	public MyAccountPasswordPage() {
		
		PageFactory.initElements(webDriver, this);
		
	}
	
	@FindBy(css="#column-right div>a:nth-of-type(3)")
	private WebElement passwordButton;
	
	
	public ChangePasswordPage passwordButtonClick() {
		
		passwordButton.click();
		
		return new ChangePasswordPage();
		
	}

}
