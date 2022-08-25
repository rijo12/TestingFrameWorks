package com.naveenautomations.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class MyAccountPagePasswordConfirm extends TestBase {
	
	MyAccountPagePasswordConfirm(){
		
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(css="div.alert.alert-success.alert-dismissible")
	private WebElement passwordChangeMessage;

}
