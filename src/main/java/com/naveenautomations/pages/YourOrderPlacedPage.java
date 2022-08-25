package com.naveenautomations.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class YourOrderPlacedPage extends TestBase {
	
	YourOrderPlacedPage(){
		
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(css="#common-success>div div h1")
	private WebElement orderPlaced;
	
	
	@FindBy(css="ul.list-inline >li:nth-of-type(2) a span")
	private WebElement myAccountButton;
	
	@FindBy(css="ul.list-inline>li>ul li a")
	private WebElement myAccountSelect;
	
	
	public String orderMessage() {
		
		String orderMessage=orderPlaced.getText();
		
		return orderMessage;
		
	}
	
	public void myAccountClick() {
		
		myAccountButton.click();
		
	}
	
	public MyAccountPasswordPage myAccountSelectClick() {
		
		myAccountSelect.click();
		
		return new MyAccountPasswordPage();
		
	}
	
	
	

}
