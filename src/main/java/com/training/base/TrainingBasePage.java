package com.training.base;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TrainingBasePage {
	
	private static final int TIMEOUT = 5;
    private static final int POLLING = 100;

    public WebDriver driver;
    public WebDriverWait wait;

    public TrainingBasePage(WebDriver driver) {
    	this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(driver,this);
    }
	
	
    public void waitForVisibility(WebElement element) throws Error{
        new WebDriverWait(driver, 5)
             .until(ExpectedConditions.visibilityOf(element));
   }
    
    public void enterIntoTextBox(WebElement element, String value) {
    	waitForVisibility(element);
    	element.sendKeys(value);
		
	}
    
    public void validateText(WebElement element, String expected) {
		String actual = element.getText();
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		
	}
    
    public void validateUserInput(WebElement element, String expected) {
		String actual = element.getAttribute("value");
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		
	}
    
    public void clickOnButton(WebElement element) {
    	element.click();
		
	}
    
    public void clickOnCheckBox(WebElement element) {
    	element.click();
		
	}
    
    public void clickOnLinkText(WebElement element) {
    	element.click();
		
	}
    
    public void verifyTitle(String expected) {
		String actual = driver.getTitle();
		System.out.println(actual);
		System.out.println(expected);
		Assert.assertEquals(actual, expected);
		
	}
    
    public void UserMenulistItemCheck(WebElement element, List<WebElement> userMenu, int expected) {
    	element.click();
    	for(WebElement list: userMenu) {
    		System.out.println(list.getText());
    		
    	}
    	int count=userMenu.size();
    	Assert.assertEquals(count, expected);
    }
    
}
