package com.EBanking.Qa.Pages;

import static com.EBanking.Qa.Util.element_utility.Element_Click;
import static com.EBanking.Qa.Util.element_utility.gettextvalue;
import static com.EBanking.Qa.Util.element_utility.gettitile;
import static com.EBanking.Qa.Util.element_utility.simple_alert;
import static com.EBanking.Qa.Util.element_utility.welehighlight;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.EBanking.Qa.Base.Baseclass;

public class EB_HomePage extends Baseclass {
	// 1. Defining Page Factory --> OR Object Repository
	@FindBy(xpath = "//h2[contains(text(),'Guru99 Bank')]")
	WebElement header;

	@FindBy(xpath = "//a[contains(text(),'New Customer')]")
	WebElement newcustomer;

	@FindBy(xpath = "//div[@id = 'dismiss-button']")
	WebElement ncclosead;

	@FindBy(xpath = "//a[contains(text(),'Edit Customer')]")
	WebElement editcustomer;

	@FindBy(xpath = "//a[contains(@href,'DeleteCustomer')]")
	WebElement deletecustomer;

	@FindBy(xpath = "//a[contains(text(),'New Account')]")
	WebElement newaccount;

	@FindBy(xpath = "//a[contains(text(),'Edit Account')]")
	WebElement editaccount;

	@FindBy(xpath = "//a[contains(text(),'Log out')]")
	WebElement logout;

	// 2. Initializing Page Object
	public EB_HomePage() {
		PageFactory.initElements(driver, this);
	}

	// 3.Actions
	public String validateHomePageTitle() {

		String hptitle = gettitile();
		System.out.println("Title:" + hptitle);

		return hptitle;
	}

	public String validateHomePageHeader() {
		welehighlight(header);
		Element_Click(header, 60);

		String htext = gettextvalue(header);

		System.out.println("Header : " + htext);
		return htext;
	}

	public String validateNewCustomerPageTitle() {
		welehighlight(newcustomer);
		Element_Click(newcustomer, 60);

		String nctitle = gettitile();
		// element_utility.Element_Click(ncclosead, 30);

		System.out.println("Title:" + nctitle);
		return nctitle;
	}

	public String validateEditCustomerPageTitle() {
		welehighlight(editcustomer);
		Element_Click(editcustomer, 60);

		String ectitle = gettitile();
		System.out.println("Title:" + ectitle);
		return ectitle;
	}

	public String validatedeleteCustomerPageTitle() {
		welehighlight(deletecustomer);
		Element_Click(deletecustomer, 60);

		String dctitle = gettitile();
		System.out.println("Title:" + dctitle);
		return dctitle;
	}

	public String validateNewAccountPageTitle() {
		welehighlight(newaccount);
		Element_Click(newaccount, 60);

		String natitle = gettitile();
		System.out.println("Title:" + natitle);
		return natitle;
	}

	public String validateEditAccountPageTitle() {
		welehighlight(editaccount);
		Element_Click(editaccount, 60);

		String eatitle = gettitile();
		System.out.println("Title:" + eatitle);
		return eatitle;
	}

	public String validateLogOutTitle() {
		welehighlight(logout);
		// element_utility.Element_Click(logout, 60);
		String mess = simple_alert(logout);

		// String lotitle = driver.getTitle();
		// System.out.println( lotitle);
		return mess;
	}

}
