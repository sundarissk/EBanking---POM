package com.EBanking.Qa.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.EBanking.Qa.Base.Baseclass;
import com.EBanking.Qa.Pages.EB_HomePage;
import com.EBanking.Qa.Pages.EB_StartPage;

public class EB_StartPageTest extends Baseclass {
	EB_StartPage EBSPage;
	EB_HomePage EBHPage;

	// 1. TestBase constructor call - properties to be called first
	public EB_StartPageTest() {
		super();
	}

	// 2. Browser initialization from TestBase & create object of startpage

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		EBSPage = new EB_StartPage();

	}

	@Test
	public void LoginPageTest() {
		EBHPage = EBSPage.login();

	}

	@AfterMethod
	public void closing() {
		driver.close();
		driver.quit();
	}

}
