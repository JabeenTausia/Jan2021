package com.training.pages.login;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
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

public class AccountsPage extends TrainingBasePage {
	WebDriver driver;

	public AccountsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Accounts')]")
	WebElement accountsLinks;

	@FindBy(xpath = "//tbody/tr[1]/td[2]/input[@name='new']")
	WebElement newAccButton;

	@FindBy(xpath = "//input[@id='acc2']")
	WebElement accountName;

	@FindBy(xpath = "//select[@id='acc6']")
	WebElement selectType;

	@FindBy(xpath = "//select[@id='00N5Y00000KYXdb']")
	WebElement selectCustPriority;

	@FindBy(xpath = "//input[@name='save']")
	WebElement savebtn;

	@FindBy(xpath = "//h2[@class='topName']")
	WebElement accountNameTitle;

	@FindBy(xpath = "//div[@id='acc6_ileinner']")
	WebElement accountType;

	@FindBy(xpath = "//div[@id='00N5Y00000KYXdb_ileinner']")
	WebElement custPriority;

	@FindBy(xpath = "//a[contains(text(),'Create New View')]")
	WebElement createViewBtn;

	@FindBy(xpath = "//input[@id='fname']")
	WebElement viewName;

	@FindBy(xpath = "//input[@id='devname']")
	WebElement viewUniqueName;

	@FindBy(xpath = "//input[@class='btn primary' and @name='save']")
	WebElement viewSaveBtn;

	@FindBy(xpath = "//select[contains(@id,'00B5Y00000')]")
	WebElement newviewdrp;
	
	@FindBy(xpath = "//a[contains(text(),'Merge Accounts')]")
	WebElement mergeAccLink;
	
	@FindBy(xpath = "//input[@id='srch']")
	WebElement srchAcc;
	
	@FindBy(xpath = "//input[@value='Find Accounts' and @class='btn']")
	WebElement findAccBtn;
	
	@FindBy(xpath = "//div[@class='pbBody']//table//tr//input[contains(@id,'cid')]")
	List<WebElement> srchAccList;
	
	
	@FindBy(xpath = "//input[@value=' Next ' and @name='goNext']")
	WebElement nxtBtn;
	
	
	@FindBy(xpath = "//input[@value=' Merge ']")
	WebElement mergeBtn;
	
	// Page Functions

	// Create a new Account
	public void createAccount(String name, String type, String priority) throws InterruptedException {
		clickOnButton(accountsLinks);
		Thread.sleep(4000);
		waitForVisibility(newAccButton);
		clickOnButton(newAccButton);
		waitForVisibility(accountName);
		enterIntoTextBox(accountName, name);
		Select drpAccType = new Select(selectType);
		drpAccType.selectByVisibleText(type);
		Select drpPriority = new Select(selectCustPriority);
		drpPriority.selectByVisibleText(priority);
		clickOnButton(savebtn);
	}

	public void verifyAccountCreation(String name, String type, String priority) {
		waitForVisibility(accountNameTitle);
		String titleText = accountNameTitle.getText();
		Assert.assertEquals(titleText, name);
		String typeText = accountType.getText();
		Assert.assertEquals(typeText, type);
		String custPrior = custPriority.getText();
		Assert.assertEquals(custPrior, priority);

	}

	public void createView(String Name) throws InterruptedException {
		clickOnButton(accountsLinks);
		Thread.sleep(5000);
		waitForVisibility(createViewBtn);
		createViewBtn.click();
		viewName.sendKeys(Name);
		viewUniqueName.click();
		viewSaveBtn.click();
	}

	public void verifyNewViewCreated(String Name) {
		waitForVisibility(newviewdrp);
		Boolean found = false;
		String textVal = "";
		Select select = new Select(newviewdrp);
		List<WebElement> allOptions = select.getOptions();
		for (WebElement opt : allOptions) {
			if (opt.equals(Name)) {
				textVal = opt.getText();
				found = true;
				break;
			}
		}
		if (found) {
			Assert.assertEquals(textVal, Name);
		}
	}
	
	public void searchAccount(String accNameSrch) throws InterruptedException {
		clickOnButton(accountsLinks);
		Thread.sleep(5000);
		waitForVisibility(mergeAccLink);
		clickOnButton(mergeAccLink);
		waitForVisibility(srchAcc);
		srchAcc.sendKeys(accNameSrch);
		findAccBtn.click();
		}
	
	public void mergeAcc() throws InterruptedException {
		for(WebElement chkBox: srchAccList) {
			if(chkBox.isSelected()) {
				chkBox.click();
			}
		}
		Thread.sleep(4000);
		for(int i=0;i<=1;i++) {
			srchAccList.get(i).click();
		}
		nxtBtn.click();
		waitForVisibility(mergeBtn);
		mergeBtn.click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
		String pageTitle=driver.getTitle();
		Assert.assertEquals(pageTitle, "Accounts: Home ~ Salesforce - Developer Edition");
	}

}
