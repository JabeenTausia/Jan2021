package com.training.pages.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.training.base.TrainingBasePage;

public class LoginPage extends TrainingBasePage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement loginUsername;

	@FindBy(xpath = "//input[@id='password']")
	WebElement loginPassword;

	@FindBy(xpath = "//input[@id='Login']")
	WebElement btnLogin;

	@FindBy(xpath = "//input[@id='rememberUn']")
	WebElement rememberMe;

	@FindBy(xpath = "//div[@id='error']")
	WebElement errorMessage;
	
	
	
	/*
	 * @FindBy(id = "username") WebElement userInput;
	 */
	
	@FindBy(css = "#username")
	WebElement userInput;
	
	public void enterIntoUsername(String userName) throws InterruptedException {
		enterIntoTextBox(loginUsername, userName);
	}

	public void enterIntoPassword(String password) throws InterruptedException {
		enterIntoTextBox(loginPassword, password);
	}

	public void clickonLogin() throws InterruptedException {
		clickOnButton(btnLogin);
	}

	public void validateErrorMessage(String expected) throws InterruptedException {

		loginPassword.clear();
		btnLogin.click();
		waitForVisibility(errorMessage);
		validateText(errorMessage, expected);
	}

	public void CheckRememberMe() {
		clickOnButton(rememberMe);

	}
	
	public void validateUserName(String expected) throws InterruptedException {
		validateUserInput(loginUsername, expected);
	}

	public void wrongPassErrorMessage(String expected) throws InterruptedException {

		loginPassword.sendKeys("123");
		btnLogin.click();
		waitForVisibility(errorMessage);
		validateText(errorMessage, expected);
	}
	
	


}
