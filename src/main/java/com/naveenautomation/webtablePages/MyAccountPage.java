package com.naveenautomation.webtablePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class MyAccountPage extends TestBase {
	
	public MyAccountPage() {
		
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(css="#account-account>div>div>ul:nth-of-type(2) a")
	private WebElement viewYourOrderHistory;
	
	
	public  OrderHistoryPage viewYourOrderHistoryClick() {
		
		viewYourOrderHistory.click();
		
		return new OrderHistoryPage();
		
	}

}
