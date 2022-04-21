package com.EBanking.Qa.Testcases;

import static com.EBanking.Qa.Util.element_utility.ExcelgetTestData;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.EBanking.Qa.Base.Baseclass;
import com.EBanking.Qa.Pages.EB_HomePage;
import com.EBanking.Qa.Pages.EB_NewCustomerPage;
import com.EBanking.Qa.Pages.EB_StartPage;

public class EB_NewCustomerPageTest extends Baseclass {

	EB_StartPage EBSPage;
	EB_HomePage EBHPage;
	EB_NewCustomerPage EBncPage;

	// 1. TestBase constructor call - properties to be called first
	public EB_NewCustomerPageTest() {
		super();
	}

	// 2. Browser initialization from TestBase & create object of startpage

	@BeforeMethod
	public void setup() {
		initialization();
		EBSPage = new EB_StartPage();
		EBSPage.login();
		EBHPage = new EB_HomePage();
		EBHPage.validateNewCustomerPageTitle();
		EBncPage = new EB_NewCustomerPage();
	}

	@Test(dataProvider = "getEB_NewC_TestData")
	public void Entering_ncdetailsTest(String uname, String gender, String mon, String date, String year, String add,
			String city, String state, String pin, String tele, String email, String pword, String ssname) throws IOException {
		EBncPage.Entering_ncdetails(uname, gender, mon, date, year, add, city, state, pin, tele, email, pword, ssname);

	}

	@DataProvider
	public Object[][] getEB_NewC_TestData() throws InvalidFormatException {
		Object data[][] = ExcelgetTestData("New Customer");// (sheetName);
		return data;
	}

	@AfterMethod
	public void closingdown() {
		driver.close();
		driver.quit();
	}

}
