package com.naveenautomation.excelSignupTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.excelSignupPages.RegisterAccountPage;
import com.naveenautomation.excelSignupPages.YourAccountCreatedPage;
import com.naveenautomation.excelSignupPages.YourStorePage;
import com.naveenautomation.utils.ExcelUtils;
import com.naveenautomation.utils.Utils;

import bsh.util.Util;

public class RegisterAccountTest extends TestBase {
	
	YourStorePage ysp;
	
	RegisterAccountPage rap;
	
	@BeforeMethod
	public void startBrowserSession() {
		
		initialization();
		
		ysp=new YourStorePage();
		
		ysp.myAccountClick();
		
		rap=ysp.registerBtnClick();
	}
	
	@Test(dataProvider = "SignUpData")
	public void signUptest(String firstName,String lastName,String email,String number,String password,String confirmPassword) {
		
		rap.privacyPolicySelect();
		
		YourAccountCreatedPage account=rap.dataInput(firstName, lastName, email, number, password, confirmPassword);
		
		Assert.assertEquals(account.getText(), "Your Account Has Been Created!");
	}
	
	
	@DataProvider(name="SignUpData")
	public String[][] dataProviderTologin() throws IOException {

		String filePath = "C:\\Users\\venit\\OneDrive\\Desktop\\TestCaseExcel.xlsx";

		int row = ExcelUtils.getRowCount(filePath, "Sheet2");

		int column = ExcelUtils.getColumnCount(filePath, "Sheet2", row);

		String[][] loginData = new String[row][column];

		for (int i = 1; i <= row; i++) {

			for (int j = 0; j < column; j++) {
				
				//creating a virtual array= read data from the excel sheet

				loginData[i-1][j]=ExcelUtils.getCellData(filePath, "Sheet2", i, j); 
			}
		}
		
		return loginData;
	}
	
	@AfterMethod
	public void quitBrowserSession() {
		
		quitBrowser();
	}

}
