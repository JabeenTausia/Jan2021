package com.training.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteThis {

	public static void main(String[] args) {
		

		 WebDriverManager.chromedriver().setup();
		 WebDriver driver= new ChromeDriver();
		 
		 driver.get("https://login.salesforce.com/");
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 
		 WebElement name=driver.findElement(By.id("username"));
		 name.sendKeys("jab@tek.com");
		 
		 
		 
		 System.out.println(name.getAttribute("value"));
		 System.out.println(name.getSize());
		 
		 driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testing@1");
		 
		 driver.findElement(By.xpath("//input[@id='Login']"));
		 
		 
		 
		 
	}

}
