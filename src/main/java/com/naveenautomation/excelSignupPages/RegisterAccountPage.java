package com.naveenautomation.excelSignupPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.utils.Utils;

public class RegisterAccountPage extends TestBase {
	
	
	public RegisterAccountPage(){
		
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(id="input-firstname")
	private WebElement fisrtNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement eMailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmField;
	
	@FindBy(css="div.buttons input")
	private WebElement privacyPolicyCheck;
	
	@FindBy(css="div.buttons input.btn")
	private WebElement continueBtn;
	
	public void firstNameData(String firstName) {
		
		Utils.sendKeys(fisrtNameField, firstName);
	}

	public void lastNameData(String lastName) {
		
		Utils.sendKeys(lastNameField, lastName);
	}
	public void eMailData(String eMail) {
		
		Utils.sendKeys(eMailField, eMail);
	}
	
	public void telephoneData(String number) {
		
		Utils.sendKeys(telephoneField, number);
	}
	
	public void passwordData(String password) {
		
		Utils.sendKeys(passwordField, password);
	}
	
	public void confirmPasswordData(String confirmPassword) {
		
		Utils.sendKeys(passwordConfirmField, confirmPassword);
	}
	
	public void privacyPolicySelect() {
		
		Utils.click(privacyPolicyCheck);
	}
	
	public YourAccountCreatedPage continueBtnClick() {
		
		continueBtn.submit();
		
		return new YourAccountCreatedPage();
	}
	
	public YourAccountCreatedPage dataInput(String firstName,String lastName,String email,String number,String password,String confirmPassword) {
		
		firstNameData(firstName);
		
		lastNameData(lastName);
		
		eMailData(email);
		
		telephoneData(number);
		
		passwordData(password);
		
		confirmPasswordData(confirmPassword);
		
		return continueBtnClick();
	}
}
