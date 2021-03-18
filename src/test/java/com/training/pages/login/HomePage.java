package com.training.pages.login;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.training.base.TrainingBasePage;



public class HomePage extends TrainingBasePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[normalize-space()='Setup']")
	WebElement Setup;
	
	@FindBy(id="userNavLabel")
	WebElement userDropDown;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logoutLink;
	
	
	public void validateText(String expected) {
		waitForVisibility(Setup);
		validateText(Setup,expected);
	}
	
	
	public void clickSetup() {
		clickOnButton(Setup);
	}
	
	public void logOut() {
		waitForVisibility(userDropDown);
		clickOnButton(userDropDown);
		waitForVisibility(logoutLink);
		clickOnButton(logoutLink);
	}
}
