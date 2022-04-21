package com.EBanking.Qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.EBanking.Qa.Base.Baseclass;
import com.EBanking.Qa.Pages.EB_HomePage;
import com.EBanking.Qa.Pages.EB_StartPage;

public class EB_HomePageTest extends Baseclass {
	EB_StartPage EBSPage;
	EB_HomePage EBHPage;

	// 1. TestBase constructor call - properties to be called first
	public EB_HomePageTest() {
		super();
	}

	// 2. Browser initialization from TestBase & create object of startpage

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		EBSPage = new EB_StartPage();
		EBSPage.login();
		EBHPage = new EB_HomePage();
	}

	@Test(priority = 1)
	public void validateHomePageTitleTest() {
		String tilte = EBHPage.validateHomePageTitle();
		Assert.assertEquals(tilte, "Guru99 Bank Manager HomePage");
		System.out.println("HomePageTitle :" + tilte);
	}

	@Test(priority = 2)
	public void validateHomePageHeaderTest() {
		String header = EBHPage.validateHomePageHeader();
		Assert.assertEquals(header, "Guru99 Bank");
		System.out.println("HomePage Header:" + header);
	}

	@Test(priority = 3)
	public void validateNewCustomerPageTitleTest() {
		String nctitile = EBHPage.validateNewCustomerPageTitle();
		Assert.assertEquals(nctitile, "Guru99 Bank New Customer Entry Page");
		System.out.println("New Customer Ptitle :" + nctitile);
	}

	@Test(priority = 4)
	public void validateEditCustomerPageTitleTest() {
		String ectitle = EBHPage.validateEditCustomerPageTitle();
		Assert.assertEquals(ectitle, "Guru99 Bank Edit Customer Page");
		System.out.println("Edit customer Ptitle :" + ectitle);
	}

	@Test(priority = 5)
	public void validatedeleteCustomerPageTitleTest() {
		String dctitle = EBHPage.validatedeleteCustomerPageTitle();
		Assert.assertEquals(dctitle, "Guru99 Bank Delete Customer Page");
		System.out.println("Delete customer Ptitle :" + dctitle);
	}

	@Test(priority = 6)
	public void validateNewAccountPageTitleTest() {
		String natitle = EBHPage.validateNewAccountPageTitle();
		Assert.assertEquals(natitle, "Guru99 bank add new account");
		System.out.println("NewAccount Ptitle:" + natitle);
	}

	@Test(priority = 7)
	public void validateEditAccountPageTitleTest() {
		String eatitle = EBHPage.validateEditAccountPageTitle();
		Assert.assertEquals(eatitle, "Guru99 Edit Account Page");
		System.out.println("EditAccount Ptitle:" + eatitle);
	}

	@Test(priority = 8)
	public void validateLogOutTitleTest() {
		String mes = EBHPage.validateLogOutTitle();
		Assert.assertEquals(mes, "You Have Succesfully Logged Out!!");
	}

	@AfterMethod
	public void closingdown() {
		driver.close();
		driver.quit();
	}
}
