package com.naveenautomation.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.utils.ExcelUtils;
import com.naveenautomations.pages.AccountLoginPage;
import com.naveenautomations.pages.MyAccountPage;
import com.naveenautomations.pages.YourStorePage;

public class AccountLoginTest extends TestBase {

	YourStorePage yp;

	AccountLoginPage accountlogin;

	@BeforeMethod
	public void startBrowserSession() {

		initialization();

		yp = new YourStorePage();

		yp.clickMyAccountButton();

		accountlogin = yp.clickLoginButton();
	}

	@Test(dataProvider = "LogIndata")
	public void verifyCustomerLogin(String username,String password) {

		MyAccountPage pageText = accountlogin.login(username, password);

		Assert.assertEquals(pageText.getTextFromMyAccount(), "My Account");

	}

	@DataProvider(name="LogIndata")
	public String[][] dataProviderTologin() throws IOException {

		String filePath = "C:\\Users\\venit\\OneDrive\\Desktop\\TestCaseExcel.xlsx";

		int row = ExcelUtils.getRowCount(filePath, "Sheet1");

		int column = ExcelUtils.getColumnCount(filePath, "Sheet1", row);

		String[][] loginData = new String[row][column];

		for (int i = 1; i <= row; i++) {

			for (int j = 0; j < column; j++) {
				
				//creating a virtual array= read data from the excel sheet

				loginData[i-1][j]=ExcelUtils.getCellData(filePath, "Sheet1", i, j); 
			}
		}
		
		return loginData;
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
