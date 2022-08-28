package com.naveenautomation.excelSignupPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

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
		
		fisrtNameField.sendKeys(firstName);
	}

	public void lastNameData(String lastName) {
		
		lastNameField.sendKeys(lastName);
	}
	public void eMailData(String eMail) {
		
		eMailField.sendKeys(eMail);
	}
	
	public void telephoneData(String number) {
		
		telephoneField.sendKeys(number);
	}
	
	public void passwordData(String password) {
		
		passwordField.sendKeys(password);
	}
	
	public void confirmPasswordData(String confirmPassword) {
		
		passwordConfirmField.sendKeys(confirmPassword);
	}
	
	public void privacyPolicySelect() {
		
		privacyPolicyCheck.click();
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
