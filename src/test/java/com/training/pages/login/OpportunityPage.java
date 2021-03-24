package com.training.pages.login;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.training.base.TrainingBasePage;

public class OpportunityPage extends TrainingBasePage {

	WebDriver driver;

	public OpportunityPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// PAGE ELEMENTS

	@FindBy(xpath = "//a[contains(text(),'Opportunities')]")
	WebElement opportunityLink;

	@FindBy(xpath = "//select[@id='fcf']")
	WebElement opportunityViewDDLB;
	
	@FindBy(xpath = "//tryLexDialogX")
	WebElement closeOverlay;

	
	@FindBy(xpath = "//a[contains(text(),'Opportunity Pipeline')]")
	WebElement opportunityPipeLineLink;
	
	
	@FindBy(xpath = "//h1[contains(text(),'Opportunity Pipeline')]")
	WebElement opportunityPipeLinePageHeading;
	
	
	// PAGE FUNCTIONS
	public void opportunityDrpDown() throws InterruptedException {
		waitForVisibility(opportunityLink);
		clickOnButton(opportunityLink);
		waitForVisibility(opportunityViewDDLB);
		Select select = new Select(opportunityViewDDLB);
		List<WebElement> allOptions = select.getOptions();
		List<String> oppList = new ArrayList<>();
		for (WebElement l1 : allOptions) {
			oppList.add(l1.getText());

		}
		List<String> opportunityViewList = new ArrayList<>();
		opportunityViewList.add("All Opportunities");
		opportunityViewList.add("Closing Next Month");
		opportunityViewList.add("Closing This Month");
		opportunityViewList.add("My Opportunities");
		opportunityViewList.add("New Last Week");
		opportunityViewList.add("New This Week");
		opportunityViewList.add("Opportunity Pipeline");
		opportunityViewList.add("Private");
		opportunityViewList.add("Recently Viewed Opportunities");
		opportunityViewList.add("Won");
		boolean flag = oppList.equals(opportunityViewList);
		System.out.println(flag);
		Assert.assertEquals(flag, true);
	}
	
	public void pipeLineReports() {
		waitForVisibility(opportunityLink);
		clickOnButton(opportunityLink);
		waitForVisibility(opportunityPipeLineLink);
		clickOnButton(opportunityPipeLineLink);
		waitForVisibility(opportunityPipeLinePageHeading);
		String pageTitle=driver.getTitle();
		Assert.assertEquals(pageTitle, "Opportunity Pipeline ~ Salesforce - Developer Edition");
		}
	
	
}