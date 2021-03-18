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

import com.training.base.TrainingBaseTest;
import com.training.pages.login.HomePage;
import com.training.pages.login.LoginPage;
import com.training.utilities.CommonUtilities;

public class UserDropDownTest extends TrainingBaseTest {
	
	WebDriver driver;
	CommonUtilities common = new CommonUtilities();
	 
	LoginPage login;
	HomePage homePage;
	
	  @BeforeMethod
		@Parameters({"BrowserName"})
		public void beforeTest(String BrowserName) throws IOException {
				driver = getDriver(BrowserName);
		    	String url = common.getApplicationproperty("url");
		    	driver.get(url);
		    	login = new LoginPage(driver);
		    	homePage = new HomePage(driver);
		}

	@Test(priority=1)
	public void loginintosalesandsetup() throws InterruptedException {
		login.enterIntoUsername("nsdg1@abc.com");
		login.enterIntoPassword("Test@1234");
		login.clickonLogin();
		homePage.validateText("Setup");
		homePage.clickSetup();
		
	}
	
	@Test(priority=1)
	public void loginintosalesandvalidatePageTitle() throws InterruptedException {
		login.enterIntoUsername("nsdg1@abc.com");
		login.enterIntoPassword("Test@1234");
		login.clickonLogin();
		homePage.verifyTitle("Home Page ~ Salesforce - Developer Edition");
	}
	
	
	
}
