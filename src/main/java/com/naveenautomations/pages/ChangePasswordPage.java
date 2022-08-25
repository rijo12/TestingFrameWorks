package com.naveenautomations.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class ChangePasswordPage extends TestBase {
	
	public ChangePasswordPage() {
		
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(css="#input-password")
	private WebElement passwordInputField;
	
	@FindBy(css="#input-confirm")
	private WebElement confirmPasswordInputField;
	
	
	@FindBy(css="div.buttons.clearfix>div:nth-of-type(2) input")
	private WebElement continueButton;
	
	
	public void passwordFieldClick(String password) {
		
		passwordInputField.sendKeys(password);
	}
	
	public void ConfirmPasswordFieldClick(String confirmPassword) {
		
		passwordInputField.sendKeys(confirmPassword);
	
	}
	
	public MyAccountPagePasswordConfirm continueButtonClick() {
		
		continueButton.submit();
		
		return new MyAccountPagePasswordConfirm();
		
	}
	
	public MyAccountPagePasswordConfirm changePassword(String password,String confirmPassword) {
		
		passwordFieldClick(password);
		
		ConfirmPasswordFieldClick(confirmPassword);
		
		return continueButtonClick();
		
	}
}
