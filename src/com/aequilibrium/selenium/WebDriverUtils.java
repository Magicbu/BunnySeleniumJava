package com.aequilibrium.selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class WebDriverUtils {
	
	public static WebDriver initiateWebDriver() {
		WebDriver driver=null;
		try {
			System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe"); 
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.saucedemo.com/");
			Reporter.log("Launching application");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
		
	}
	
	public static void takeScreenshotOnTestFailure(WebDriver driver, String testName) {
		try {
			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("./test-output/screenshots/"+testName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
