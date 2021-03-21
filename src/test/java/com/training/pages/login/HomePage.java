package com.training.pages.login;

import java.util.ArrayList;
import java.util.List;
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

public class HomePage extends TrainingBasePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Setup']")
	WebElement Setup;

	@FindBy(id = "userNavLabel")
	WebElement userDropDown;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logoutLink;

	@FindBy(xpath = "//div[@id='userNav-menuItems']//a")
	List<WebElement> userMenudropdown;

	@FindBy(xpath = "//a[contains(text(),'My Profile')]")
	WebElement myProfile;

	@FindBy(xpath = "//img[contains(@src,'/img/func_icons/util/pencil12.gif')]")
	WebElement editProfile;

	@FindBy(xpath = "//a[contains(text(),'About')]")
	WebElement aboutProfile;

	@FindBy(xpath = "//input[@id='lastName']")
	WebElement aboutProfileLastName;

	@FindBy(xpath = "//div[@class='net-buttons zen-mtl']//input[@value='Save All']")
	WebElement aboutProfileSaveAll;

	@FindBy(xpath = "//span[@id='tailBreadcrumbNode']")
	WebElement displayFullName;

	@FindBy(xpath = "//span[@class='publisherattachtext ' and contains(text(),'Post')]")
	WebElement post;

	@FindBy(xpath = "//textarea[@id='publishereditablearea']")
	WebElement postInput;

	@FindBy(xpath = "//body")
	WebElement framePostInput;

	@FindBy(xpath = "//input[@id='publishersharebutton']")
	WebElement sharebutton;

	// div[@id='0D55Y00007OIHp9']//div//span[@class='feeditemtext cxfeeditemtext']
	// div[contains(@id,'0D55Y0000')]//div//span[@class='feeditemtext
	// cxfeeditemtext']
	@FindBy(xpath = "//div[contains(@id,'0D55Y0000')]//div//span[@class='feeditemtext cxfeeditemtext']")
	List<WebElement> listOfPosts;

	public void clickSetup() {
		clickOnButton(Setup);
	}

	public void logOut() throws InterruptedException {
		waitForVisibility(userDropDown);
		clickOnButton(userDropDown);
		waitForVisibility(logoutLink);
		clickOnButton(logoutLink);
		Thread.sleep(2000);
		String title=driver.getTitle();
		Assert.assertEquals(title, "Login | Salesforce");
	}

	public void userMenuList(int expected) {

		UserMenulistItemCheck(userDropDown, userMenudropdown, expected);
	}

	// myprofile menu

	public void clickMyProfile() {
		waitForVisibility(userDropDown);
		clickOnButton(userDropDown);
		clickOnButton(myProfile);

	}

	// Click on About tab and enter <Lastname> and click on save all button
	public void clickAbout(String LastName) {
		clickMyProfile();
		waitForVisibility(editProfile);
		clickOnButton(editProfile);

		driver.switchTo().frame("contactInfoContentId");
		System.out.println("********We are switch to the iframe*******");
		clickOnButton(aboutProfile);
		System.out.println("aboutProfile");
		aboutProfileLastName.clear();
		aboutProfileLastName.sendKeys(LastName);
		aboutProfileSaveAll.click();
		String name = displayFullName.getText();
		boolean containsText = name.contains(LastName);
		Assert.assertEquals(containsText, true);

	}
	// Click on Post link, Enter the <text> to post in the post text area and click

	public void userPost(String postComment) throws InterruptedException {
		clickMyProfile();
		waitForVisibility(post);
		clickOnButton(postInput);
		WebElement iframePost = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		waitForVisibility(iframePost);
		driver.switchTo().frame(iframePost);
		framePostInput.sendKeys(postComment);
		driver.switchTo().parentFrame();
		waitForVisibility(sharebutton);
		sharebutton.click();
		boolean flag = false;
		for (WebElement list : listOfPosts) {
			if (list.getText().equals(postComment)) {
				flag = true;

				System.out.println(list.getText());
			}

			Assert.assertEquals(flag, true);

			Thread.sleep(5000);

		}
	}

}


// Click on the file link and click on "upload a file from computer" button

// Hover the mouse on my profile photo image and Add photo link appears.
