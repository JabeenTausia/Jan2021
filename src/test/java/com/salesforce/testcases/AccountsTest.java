package com.salesforce.testcases;

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
import com.training.pages.login.AccountsPage;
import com.training.pages.login.HomePage;
import com.training.pages.login.LoginPage;
import com.training.utilities.CommonUtilities;

public class AccountsTest extends TrainingBaseTest {
	
	public AccountsTest(){
		super();
	}

	WebDriver driver;
	CommonUtilities common = new CommonUtilities();

	LoginPage login;
	HomePage homePage;
	TrainingBasePage basePage;
	AccountsPage accountPage;

	@BeforeMethod
	@Parameters({ "BrowserName" })
	public void beforeTest(String BrowserName) throws IOException {
		driver = getDriver(BrowserName);
		String url = common.getApplicationproperty("url");
		driver.get(url);
		login = new LoginPage(driver);
		homePage = new HomePage(driver);
		accountPage= new AccountsPage(driver);
	}

	

	// Create an Account
	@Test(enabled = true)
	public void tc10_validateCreateAccount() throws InterruptedException {
		loginToApp("jab@tek.com", "Testing@1");
		accountPage.createAccount("Technology Partner","High");

	}



	
	

}
