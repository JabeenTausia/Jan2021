package com.training.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtilities {
	WebDriver driver;

	public WebDriver getdriver(String browserName) {

		if (browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-notifications");
			driver = new ChromeDriver(chromeOptions);
		} else if (browserName.equals("firefox")) {
			System.out.println("Firefox driver implementation");
		}
		return driver;
	}

}
