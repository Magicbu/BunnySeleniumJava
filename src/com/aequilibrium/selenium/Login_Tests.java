package com.aequilibrium.selenium;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Login_Tests {
	WebDriver driver=null;
	WebDriverWait wait=null;
	
	
	@BeforeMethod
	public void launchApplication() {
		driver = WebDriverUtils.initiateWebDriver();
		wait=new WebDriverWait(driver, 25);
	}
	
	@Test (priority=0)
	public void validateSuccessfullLogin() {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='user-name']")));
			
			WebElement userName_txtBox= driver.findElement(By.xpath("//input[@id='user-name']"));
			WebElement password_txtBox= driver.findElement(By.xpath("//input[@id='password']"));
			WebElement loginButton= driver.findElement(By.xpath("//input[@id='login-button']"));
			
			userName_txtBox.sendKeys("standard_user");
			password_txtBox.sendKeys("secret_sauce");
			loginButton.click();
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='header_container']/div/span[text()='Products']")));
			Reporter.log("validateSuccessfullLogin - Passed");
		} catch (Exception e) {
			e.printStackTrace();
			WebDriverUtils.takeScreenshotOnTestFailure(driver, "validateSuccessfullLogin");
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@Test (priority=1)
	public void validateLogin_WithWrongPassword() {
				
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='user-name']")));
			
			WebElement userName_txtBox= driver.findElement(By.xpath("//input[@id='user-name']"));
			WebElement password_txtBox= driver.findElement(By.xpath("//input[@id='password']"));
			WebElement loginButton= driver.findElement(By.xpath("//input[@id='login-button']"));
			
			userName_txtBox.sendKeys("standard_user");
			password_txtBox.sendKeys("secret_sauce123");
			loginButton.click();
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='error-message-container error']/h3[contains(text(),'Username and password do not match any user in this service')]")));
			WebElement errorText= driver.findElement(By.xpath("//div[@class='error-message-container error']/h3[contains(text(),'Username and password do not match any user in this service')]"));
			if(errorText.getText().contains("Username and password do not match any user in this service")) {
				Reporter.log("Wrong Password validation - PASSED");
			}else {
				Reporter.log("Wrong Password validation - FAILED");
			}
		} catch (Exception e) {
			e.printStackTrace();
			WebDriverUtils.takeScreenshotOnTestFailure(driver, "validateLogin_WithWrongPassword");
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@Test (priority=2)
	public void validateLogin_ForLockedOutUser() {
				
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='user-name']")));
			
			WebElement userName_txtBox= driver.findElement(By.xpath("//input[@id='user-name']"));
			WebElement password_txtBox= driver.findElement(By.xpath("//input[@id='password']"));
			WebElement loginButton= driver.findElement(By.xpath("//input[@id='login-button']"));
			
			userName_txtBox.sendKeys("locked_out_user");
			password_txtBox.sendKeys("secret_sauce");
			loginButton.click();
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='error-message-container error']/h3[contains(text(),'Sorry, this user has been locked out')]")));
			WebElement errorText= driver.findElement(By.xpath("//div[@class='error-message-container error']/h3[contains(text(),'Sorry, this user has been locked out')]"));
			if(errorText.getText().contains("Sorry, this user has been locked out")) {
				Reporter.log("Lockedout user validation - PASSED");
			}else {
				Reporter.log("Lockedout user validation - FAILED");
			}
		} catch (Exception e) {
			e.printStackTrace();
			WebDriverUtils.takeScreenshotOnTestFailure(driver, "validateLogin_WithWrongPassword");
			throw new RuntimeException(e.getMessage());
		}
	}
	@Test (priority=3)
	public void validateLogin_UserNameAsBlank() {
		
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='user-name']")));
			
			WebElement userName_txtBox= driver.findElement(By.xpath("//input[@id='user-name']"));
			WebElement password_txtBox= driver.findElement(By.xpath("//input[@id='password']"));
			WebElement loginButton= driver.findElement(By.xpath("//input[@id='login-button']"));
			
			userName_txtBox.sendKeys("");
			password_txtBox.sendKeys("secret_sauce");
			loginButton.click();
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='error-message-container error']/h3[contains(text(),'Username is required')]")));
			WebElement errorText= driver.findElement(By.xpath("//div[@class='error-message-container error']/h3[contains(text(),'Username is required')]"));
			if(errorText.getText().contains("Username is required")) {
				Reporter.log("Username blank validation - PASSED");
			}else {
				Reporter.log("Username blank validation - FAILED");
			}
		} catch (Exception e) {
			e.printStackTrace();
			WebDriverUtils.takeScreenshotOnTestFailure(driver, "validateLogin_UserNameAsBlank");
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@Test (priority=4)
	public void validateLogin_PasswordAsBlank() {
				
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='user-name']")));
			
			WebElement userName_txtBox= driver.findElement(By.xpath("//input[@id='user-name']"));
			WebElement password_txtBox= driver.findElement(By.xpath("//input[@id='password']"));
			WebElement loginButton= driver.findElement(By.xpath("//input[@id='login-button']"));
			
			userName_txtBox.sendKeys("standard_user");
			password_txtBox.sendKeys("");
			loginButton.click();
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='error-message-container error']/h3[contains(text(),'Username is required')]")));
			WebElement errorText= driver.findElement(By.xpath("//div[@class='error-message-container error']/h3[contains(text(),'Username is required')]"));
			if(errorText.getText().contains("Password is required")) {
				Reporter.log("Password blank validation - PASSED");
			}else {
				Reporter.log("Password blank validation - FAILED");
			}
		} catch (Exception e) {
			e.printStackTrace();
			WebDriverUtils.takeScreenshotOnTestFailure(driver, "validateLogin_PasswordAsBlank");
			throw new RuntimeException(e.getMessage());

		}
	}
	
	
	@AfterMethod
	public void closeDriver() {
		if(driver!=null)
			driver.quit();
	}
	
	

}
