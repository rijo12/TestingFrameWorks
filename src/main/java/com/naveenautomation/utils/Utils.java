package com.naveenautomation.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.compress.harmony.pack200.NewAttribute;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenautomation.base.TestBase;

public class Utils extends TestBase {
	
	public static final int impicit_wait=10;
	
	public static final int page_load_wait=30;

	public static void takeFailedTestScreenShots(String testCaseName) {

		// get the current date and time

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		// System.out.println(timeStamp);

		// Save the screenShot in a file

		File screenShotFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);

		// save the screenshot

		try {
			FileUtils.copyFile(screenShotFile,
					new File("./FailedScreenShot\\" + "_" + testCaseName + "_" + timeStamp + ".jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block

			System.out.println("unalbe to take the screen shot of failed test case" + testCaseName);
		}

	}

	public static String generateRandomEmail() {

		String email = RandomStringUtils.randomNumeric(3);

		String emailID = "rijo" + email + "@gmail.com";

		return emailID;

	}

	public static String generateRandomPassword() {

		String randomStringForPassword = RandomStringUtils.randomNumeric(3);

		String password = "Manager@" + randomStringForPassword;

		return password;

	}
	
	public static void sleep(int seconds) throws InterruptedException {
		
		Thread.sleep(seconds);
	}
	
	//Explicit Waits
	
	public static void click(WebElement element) {
		
		new WebDriverWait(webDriver, 10).until(ExpectedConditions.elementToBeClickable(element)).click();
		
	}
	
	public static boolean isElementDisplayed(WebElement element) {
		
		return new WebDriverWait(webDriver, 15).until(ExpectedConditions.visibilityOf(element)).isDisplayed();
		
	}
	
	public static String getText(WebElement element) {
		
		return new WebDriverWait(webDriver, 15).until(ExpectedConditions.visibilityOf(element)).getText(); 
	}
	
	public static void acceptAlert() {
		
		new WebDriverWait(webDriver, 10).until(ExpectedConditions.alertIsPresent()).accept();
		
	}
	
	public static void dismisstAlert() {
		
		new WebDriverWait(webDriver, 10).until(ExpectedConditions.alertIsPresent()).dismiss();
		
	}
	
	public static void selectFromDropDown(WebElement element,String value) {
		
		waitForelementToBeSelectable(element);
		
		Select sc =new Select(element);
		
		try {
			//try with value
			sc.selectByValue(value);
			
		} catch (Exception e) {
			
			//If value not available in exception
			//try by visible text
			
			sc.selectByVisibleText(value);
		}
	}
	
	public static void waitForelementToBeSelectable(WebElement element) {
		
		new WebDriverWait(webDriver, 15).until(ExpectedConditions.elementSelectionStateToBe(element, true));
		
	}
	
	public static void waitForElementtoBeDisplayed(WebElement element) {
		
		new WebDriverWait(webDriver, 15).until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public static void switchToNewtab(WebElement element) {
		
		String parentWindow=webDriver.getWindowHandle();
		
		Logger.info("parent Window Handle is: "+parentWindow);
		
		waitForelementToBeSelectable(element);
		
		Set<String> allWindowHandles= webDriver.getWindowHandles();
		
		for(String windowHandle: allWindowHandles) {
			
			if(!windowHandle.equals(parentWindow)) {
				
				webDriver.switchTo().window(windowHandle); 
			}
		}
		
	}
	
	public static void sendKeys(WebElement element, String keyInput) {
		
		new WebDriverWait(webDriver, 10).until(ExpectedConditions.visibilityOf(element)).sendKeys(keyInput);
	}
	
	public static void javascriptClick(WebElement element) {
		jse.executeScript("arguments[0].click();", element);
	}

	public static void scrollIntoViewUsingJavascript(WebElement element) {
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void sendKeysUsingJavascript(WebElement element, String emailInput) {
		jse.executeScript("arguments[0].setAttribute('value', '"+emailInput+"')", element);
	}

}
