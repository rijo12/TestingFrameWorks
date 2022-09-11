package com.naveenautomation.excelSignupPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.utils.Utils;

public class YourAccountCreatedPage extends TestBase {
	
	public YourAccountCreatedPage() {
		
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(css="#common-success div div h1")
	private WebElement text;
	
	public String getText() {
		
		return Utils.getText(text);
	}

}
