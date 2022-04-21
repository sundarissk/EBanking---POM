package com.EBanking.Qa.Pages;

import static com.EBanking.Qa.Util.element_utility.Element_Click;
import static com.EBanking.Qa.Util.element_utility.Element_Text;
import static com.EBanking.Qa.Util.element_utility.welehighlight;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.EBanking.Qa.Base.Baseclass;

public class EB_StartPage extends Baseclass {
	// 1. Defining Page Factory --> OR Object Repository

	@FindBy(xpath = "//input[contains(@name,'uid')]")
	WebElement useridtxt;

	@FindBy(xpath = "//input[contains(@name,'password')]")
	WebElement pwordtxt;

	@FindBy(xpath = "//input[contains(@name,'btnReset')]")
	WebElement restbtn;

	@FindBy(xpath = "//input[contains(@name,'btnLogin')]")
	WebElement loginbtn;

	// 2. Initializing Page Object
	public EB_StartPage() {
		PageFactory.initElements(driver, this);
	}

	// 3.Actions
	public EB_HomePage login() {
		// logger.info("Enter Valid Vredential to log in");
		welehighlight(useridtxt);
		Element_Text(useridtxt, 30, "mngr396018");

		welehighlight(pwordtxt);
		Element_Text(pwordtxt, 30, "jAhuvus");

		welehighlight(loginbtn);
		Element_Click(loginbtn, 30);
		// logger.info("Sucessfully Enter HomePage");
		return new EB_HomePage();

	}

	public void reset() {
		welehighlight(restbtn);
		Element_Click(restbtn, 30);
	}
}
