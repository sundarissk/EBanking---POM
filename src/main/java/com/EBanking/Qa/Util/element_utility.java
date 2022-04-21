package com.EBanking.Qa.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.EBanking.Qa.Base.Baseclass;

public class element_utility extends Baseclass {
	// public static long EXPLICITWAIT = 30;

	public static Workbook book;
	public static Sheet sheet;

	public static void welehighlight(WebElement ele) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", ele);

	}

	public static void explicit_wait(WebElement element, int value) {
		new WebDriverWait(driver, Duration.ofSeconds(value)).until(ExpectedConditions.elementToBeClickable(element));

	}

	public static void Element_Text(WebElement element, long timeout, String value) {
		WebElement E1 = new WebDriverWait(driver, Duration.ofMinutes(timeout))
				.until(ExpectedConditions.elementToBeClickable(element));
		E1.sendKeys(value);
	}

	public static void Element_Click(WebElement element, long timeout) {
		WebElement E1 = new WebDriverWait(driver, Duration.ofMinutes(timeout))
				.until(ExpectedConditions.elementToBeClickable(element));
		E1.click();
	}

	public static String gettextvalue(WebElement element) {

		return element.getText();

	}

	public static String gettitile() {

		return driver.getTitle();

	}

	public static Object[][] ExcelgetTestData(String sheetName) throws InvalidFormatException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(
					"C:\\Users\\skuma\\eclipse-workspace\\EBanking_POM\\src\\main\\java\\com\\EBanking\\Qa\\TestData\\Ebanking_testdata.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);

		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			System.out.println(i + "-->Row value passed to test");
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
				
			}
		}
		return data;
	}

	public static String simple_alert(WebElement element) {

		// Click the link to activate the alert
		element.click();

		// Wait for the alert to be displayed and store it in a variable
		Alert alert = driver.switchTo().alert();

		// Store the alert text in a variable
		String text = alert.getText();

		System.out.println(text);
		// Press the OK button
		alert.accept();
		return text;
	}

	public static void takesshot(String filename) throws IOException {

		// 1.take screenshot and store it as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// 2. Open the current date and time
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());

		// 3. Location to save screenshot
		File tar = new File(
				"C:\\Users\\skuma\\eclipse-workspace\\EBanking_POM\\src\\test\\resources\\Screenshots\\NewCustomerSS"
						+ filename + " " + timestamp + ".jpeg");
		// 4. now copy the screenshot to desired location using copyfile method
		FileUtils.copyFile(src, tar);

	}

}
