package com.training.pages.login;

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

public class AccountsPage extends TrainingBasePage {
	WebDriver driver;

	public AccountsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
        
        PageFactory.initElements(driver,this);
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
	
	//Page Functions
	
	//Create a new Account
	public void createAccount(String type, String priority) throws InterruptedException{
	 clickOnButton(accountsLinks);
	 Thread.sleep(4000);
	 waitForVisibility(newAccButton);
	 clickOnButton(newAccButton);
	 waitForVisibility(accountName);
	 enterIntoTextBox(accountName, "Testing123");
	 Select drpAccType= new Select(selectType);
	 drpAccType.selectByVisibleText(type);
	 
	 Select drpPriority= new Select(selectCustPriority);
	 drpPriority.selectByVisibleText(priority);
	}


	
	


}
