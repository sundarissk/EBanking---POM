package com.EBanking.Qa.Base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver;
	public static Properties prop;

	// username and password valid for only 20 days of creation , it created on
	// 3/29/2022

	public Baseclass() {

		try {
			prop = new Properties();

			FileInputStream ip = new FileInputStream(
					"C:\\Users\\skuma\\eclipse-workspace\\EBanking_POM\\src\\main\\java\\com\\EBanking\\Qa\\Config\\config.properties");
			prop.load(ip);

			System.out.println(prop.getProperty("browser"));
			// browsername = prop.getProperty("browser");
			// url = prop.getProperty("url");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();

		}

	}

	public static void initialization() {
		String browsername = prop.getProperty("browser");
		if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browsername.equalsIgnoreCase("FF")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("No Browser value is given");

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		driver.get(prop.getProperty("url"));

	}
}
