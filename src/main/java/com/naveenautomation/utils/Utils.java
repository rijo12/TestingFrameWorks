package com.naveenautomation.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.compress.harmony.pack200.NewAttribute;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

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

}
