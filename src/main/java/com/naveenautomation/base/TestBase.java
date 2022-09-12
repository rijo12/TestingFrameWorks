package com.naveenautomation.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.naveenautomation.utils.Utils;
import com.naveenautomation.utils.WebDriverEvents;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {

	public static WebDriver webDriver;

	public Properties prop;
	
	public static Logger Logger;
	
	public static EventFiringWebDriver e_driver;
	  
	public static WebDriverEvents events;
	
	public static JavascriptExecutor jse;

	public TestBase() {

		prop = new Properties();

		FileInputStream file;

		try {
			file = new FileInputStream(
					"C:\\Java_Project\\testingframeworks\\src\\main\\java\\com\\naveenautomation\\config\\config.properties");
			try {
				prop.load(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@BeforeClass
	public void loggerSetup() {
		
		Logger= Logger.getLogger(TestBase.class);
		
		PropertyConfigurator.configure("log4j.properties");
		
		BasicConfigurator.configure(); 
		
		Logger.setLevel(Level.INFO);
	}

	public void initialization() {
		
		

		String browserName = prop.getProperty("browser");

		switch (browserName) {
		
		case "chrome":

			webDriver= WebDriverManager.chromedriver().create();

			break;
			
		case "edge":

			webDriver= WebDriverManager.edgedriver().create();

			break;
			
		case "firefox":

			webDriver= WebDriverManager.firefoxdriver().create();   

			break;

		default:
			
			System.out.println("Verify you have passed the correct browser name ");
			
			break;
		}
		
		e_driver=new EventFiringWebDriver(webDriver);
		
		events=new WebDriverEvents(); 
		
		e_driver.register(events);
		
		webDriver=e_driver;
		
		webDriver.manage().window().maximize();
		
		webDriver.get(prop.getProperty("base_url"));
		
		webDriver.manage().deleteAllCookies();
		
		webDriver.manage().timeouts().pageLoadTimeout(Utils.page_load_wait , TimeUnit.SECONDS);
		
	}
	
//	public void waitForDocumentCompleteState(int timeOutInSeconds) {
//		new WebDriverWait(webDriver, timeOutInSeconds).until((ExpectedCondition<Boolean>)v -> {
//			logger.info("Verifying page has loaded......");
//			jse = (JavascriptExecutor) webDriver;
//			String documentIsReady = jse.executeScript("return document.readyState").toString();
//			while (true) {
//				if (documentIsReady.equalsIgnoreCase("complete")) {
//					logger.info("Page has loaded completely......");
//					return true;
//				} else {
//					return false;
//				}
//			}
//		});
//	}

	public void quitBrowser() {

		webDriver.quit();

	}
}
