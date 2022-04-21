package com.EBanking.Qa.Pages;

import static com.EBanking.Qa.Util.element_utility.Element_Text;
import static com.EBanking.Qa.Util.element_utility.simple_alert;
import static com.EBanking.Qa.Util.element_utility.welehighlight;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.EBanking.Qa.Base.Baseclass;
import com.EBanking.Qa.Util.element_utility;


public class EB_NewCustomerPage extends Baseclass {
	// 1. Defining Page Factory --> OR Object Repository

	@FindBy(xpath = "//input[@name='name']")
	WebElement uname_txt;

	@FindBy(xpath = "//input[@type='radio' and @value='f']")
	WebElement female_radio;

	@FindBy(xpath = "//input[@type='radio' and @value='m']")
	WebElement male_radio;

	@FindBy(xpath = "//input[@id='dob']")
	WebElement dob_ct;

	@FindBy(xpath = "//textarea[@name='addr']")
	WebElement address_txt;

	@FindBy(xpath = "//input[@name='city']")
	WebElement city_txt;

	@FindBy(xpath = "//input[@name='state']")
	WebElement state_txt;

	@FindBy(xpath = "//input[@name='pinno']")
	WebElement pinno_txt;

	@FindBy(xpath = "//input[@name='telephoneno']")
	WebElement telepn_txt;

	@FindBy(xpath = "//input[@name='emailid']")
	WebElement email_txt;

	@FindBy(xpath = "//input[@name='password']")
	WebElement pword_txt;

	@FindBy(xpath = "//input[@name='sub']")
	WebElement submit_but;

	// 2. Initializing Page Object
	public EB_NewCustomerPage() {
		PageFactory.initElements(driver, this);
	}

	// 3.Actions

	public void Entering_ncdetails(String uname, String gender, String mon, String date, String year, String add,
			String city, String state, String pin, String tele, String email, String pword,String SSname) throws IOException {

		welehighlight(uname_txt);
		Element_Text(uname_txt, 30, uname);

		switch (gender) {
		case "Male":
			welehighlight(male_radio);
			male_radio.click();
		case "Female":
			welehighlight(female_radio);
			female_radio.click();
			break;
		}

		welehighlight(dob_ct);
		Element_Text(dob_ct, 30, mon);

		welehighlight(dob_ct);
		Element_Text(dob_ct, 30, date);

		welehighlight(dob_ct);
		Element_Text(dob_ct, 30, year);

		welehighlight(address_txt);
		Element_Text(address_txt, 30, add);

		welehighlight(city_txt);
		Element_Text(city_txt, 30, city);

		welehighlight(state_txt);
		Element_Text(state_txt, 30, state);

		welehighlight(pinno_txt);
		Element_Text(pinno_txt, 30, pin);

		welehighlight(telepn_txt);
		Element_Text(telepn_txt, 30, tele);

		welehighlight(email_txt);
		Element_Text(email_txt, 30, email);

		welehighlight(pword_txt);
		Element_Text(pword_txt, 30, pword);
		
		element_utility.takesshot(SSname);

		welehighlight(submit_but);
		simple_alert(submit_but);
		// submit_but.click();

	}

}
