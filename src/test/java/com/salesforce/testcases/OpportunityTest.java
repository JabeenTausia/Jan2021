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
import com.training.pages.login.HomePage;
import com.training.pages.login.LoginPage;
import com.training.pages.login.OpportunityPage;
import com.training.utilities.CommonUtilities;

public class OpportunityTest extends TrainingBaseTest {
	
	public OpportunityTest(){
		super();
	}

	WebDriver driver;
	CommonUtilities common = new CommonUtilities();

	LoginPage login;
	HomePage homePage;
	TrainingBasePage basePage;
	OpportunityPage oppPage;

	@BeforeMethod
	@Parameters({ "BrowserName" })
	public void beforeTest(String BrowserName) throws IOException {
		driver = getDriver(BrowserName);
		String url = common.getApplicationproperty("url");
		driver.get(url);
		login = new LoginPage(driver);
		homePage = new HomePage(driver);
		oppPage= new OpportunityPage(driver);
	}

	
	// opportunities drop down
	@Test(enabled = false)
	public void tc15_validateOpportunitiesDrpDown() throws InterruptedException {
		loginToApp("jab@tek.com", "Testing@1");
		oppPage.opportunityDrpDown();

	}
	
	// Test Opportunity Pipeline Report
		@Test(enabled = true)
		public void tc17_validateOpportunitiesPipelinePage() throws InterruptedException {
			loginToApp("jab@tek.com", "Testing@1");
			oppPage.pipeLineReports();

		}
	

}
