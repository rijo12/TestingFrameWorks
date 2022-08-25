package com.naveenautomation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naveenautomation.base.TestBase;

public class WebDriverEvents extends TestBase implements org.openqa.selenium.support.events.WebDriverEventListener {

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		
		Logger.info("about to accept alert "+driver.getCurrentUrl());
		
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		
		Logger.info("Accepted alert on  "+driver.getCurrentUrl());
		
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		
		Logger.info("Navigating to url: "+driver.getCurrentUrl());
		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		
		
		Logger.info("Navigated to url: "+driver.getCurrentUrl());
		
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		
		Logger.info("Refreshing "+driver.getCurrentUrl());
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		
		Logger.info("Refreshed "+driver.getCurrentUrl());
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		
		Logger.info("Finding WebElement "+element);
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		
		Logger.info("WebElement found "+element);
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		
		Logger.info("Clicking WebElement"+element);
		
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		
		Logger.info("Clicked WebElement"+element);
		
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		
		
		Logger.info("Switching to Window: "+windowName);
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		
		Logger.info("Switched to Window: "+windowName);
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		
		Logger.info("Exception encountered "+throwable.getMessage());
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		
		Logger.info("Getting Text from "+element);
		
	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {

		Logger.info("Got Text from "+element+" : "+text);
		
	}
	
	
	  
	
	
	

}
