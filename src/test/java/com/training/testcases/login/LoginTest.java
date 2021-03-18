package com.training.testcases.login;

import org.testng.annotations.Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.training.base.TrainingBasePage;
import com.training.base.TrainingBaseTest;
import com.training.pages.login.HomePage;
import com.training.pages.login.LoginPage;
import com.training.utilities.CommonUtilities;

public class LoginTest extends TrainingBaseTest {
	
	public LoginTest(){
		super();
	}

	WebDriver driver;
	CommonUtilities common = new CommonUtilities();

	LoginPage login;
	HomePage homePage;
	TrainingBasePage basePage;

	@BeforeMethod
	@Parameters({ "BrowserName" })
	public void beforeTest(String BrowserName) throws IOException {
		driver = getDriver(BrowserName);
		String url = common.getApplicationproperty("url");
		driver.get(url);
		login = new LoginPage(driver);
		homePage = new HomePage(driver);
	}

	@Test(priority = 1, enabled = false)
	public void loginintosalesandsetup() throws InterruptedException {
		login.enterIntoUsername("jab@tek.com");
		login.enterIntoPassword("Testing@1");
		login.clickonLogin();
		homePage.validateText("Setup");
		homePage.clickSetup();

	}

	// Login To SalesForce -2
	@Test(priority = 1, enabled = false)
	public void tc02_loginintosalesandvalidatePageTitle() throws InterruptedException {
		login.enterIntoUsername("jab@tek.com");
		login.enterIntoPassword("Testing@1");
		login.clickonLogin();
		homePage.verifyTitle("Home Page ~ Salesforce - Developer Edition");
	}

	// Login Error Message - 1
	@Test(enabled = false)
	public void tc01_validateErrorLoginScreen() throws InterruptedException {
		login.enterIntoUsername("jab@tek.com");
		login.validateErrorMessage("Please enter your password.");

	}

	// Check RemeberMe - 3
	@Test(priority = 1, enabled = false)
	public void tc03_validateRememberMe() throws InterruptedException {
		login.enterIntoUsername("jab@tek.com");
		login.enterIntoPassword("Testing@1");
		login.CheckRememberMe();
		login.clickonLogin();
		homePage.verifyTitle("Home Page ~ Salesforce - Developer Edition");
		homePage.logOut();
		login.validateUserName("jab@tek.com");

	}

	// Forgot Password-wrong password- 4 B
	@Test(priority = 1, enabled = true)
	public void tc04_forgotPassError() throws InterruptedException {
		login.enterIntoUsername("he234@tek.com");
		login.wrongPassErrorMessage(
				"Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
	}

}
