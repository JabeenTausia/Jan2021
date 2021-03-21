package com.salesforce.testcases;

import org.testng.annotations.Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
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

public class HomePageUserMenuTest extends TrainingBaseTest {
	public HomePageUserMenuTest() {
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

	// Select user menu for <username> drop down
	@Test(priority = 1, enabled = false)
	public void tc05_validateUserMenuList() {
		loginToApp("jab@tek.com", "Testing@1");
		homePage.userMenuList(5);

	}

	// Select "My Profile" option from user menu for <username> drop down
	@Test(priority = 1, enabled = false)
	public void tc06_validateMyProfile() {
		loginToApp("jab@tek.com", "Testing@1");
		homePage.clickAbout("test1");

	}

	// Select "My Profile" and validate Post
	@Test(priority = 1, enabled = false)
	public void tc06_validateMyProfilePost() throws InterruptedException {
		loginToApp("jab@tek.com", "Testing@1");
		homePage.userPost("hello world 1");

	}
	
	// Select "Logout" option from user menu
		@Test(priority = 1, enabled = false)
		public void tc09_validateLogOut() throws InterruptedException {
			loginToApp("jab@tek.com", "Testing@1");
			homePage.logOut();
			

		}
}
