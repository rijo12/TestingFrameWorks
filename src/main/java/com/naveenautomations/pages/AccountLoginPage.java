package com.naveenautomations.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class AccountLoginPage extends TestBase {

	public AccountLoginPage() {

		PageFactory.initElements(webDriver, this);
	}

	@FindBy(id = "input-email")
	private WebElement inputEmailField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(css = "input[type='submit']")
	private WebElement loginButton;

	public void enterEmail(String email) {

		inputEmailField.sendKeys(email);
	}

	public void enterPassword(String password) {

		passwordField.sendKeys(password);
	}

	public MyAccountPage clickSubmit() {

		loginButton.submit();

		return new MyAccountPage();
	}

	public MyAccountPage login(String email, String password) {

		enterEmail(email);
		enterPassword(password);
		return clickSubmit();

	}

}
