package com.training.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TrainingBaseTest {

	protected WebDriver driver;

	public WebDriver getDriver(String browsername) {
		if (browsername.equals("chrome")) {
			ChromeDriverManager.chromedriver();
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-notifications");
			driver = new ChromeDriver(chromeOptions);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		} else if (browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("permissions.default.desktop-notification", 1);
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability(FirefoxDriver.PROFILE, profile);
			driver = new FirefoxDriver(capabilities);
		}
		return driver;
	}

	public void loginToApp(String user, String pass) {

		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.id("username")).sendKeys("jab@tek.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testing@1");

		driver.findElement(By.xpath("//input[@id='Login']")).click();

	}

	@AfterMethod
	public void afterSuite() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}
}
