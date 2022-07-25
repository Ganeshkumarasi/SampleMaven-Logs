package com.ibm.SampleMaven;

import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTest {
	WebDriver driver;
	Logger log;

	@BeforeTest
	public void launchApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// logging
		log = Logger.getLogger("IBM_Amazon_Module");
		PropertyConfigurator.configure(".\\ConfigProperties\\log4j.properties");
		log.info("=================================");
		log.info("chrome browser launched.");
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		log.info("Amazon app launched. - https://www.amazon.in/");
	}

	@AfterTest
	public void closeApp() throws Exception {
		Thread.sleep(4000);
		driver.close();
		log.info("browser closed successfully.");
	}

	@Test
	public void loginTest() throws Exception {
		// log.info("=====TestCase: LoginTest execution in progress");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		log.info("enter searchText: iphone");
		driver.findElement(By.xpath("//input[@value=\"Go\"]")).click();
		log.info("click on search button");
	}

	@BeforeMethod
	public void addComment() {
		log.info("=======Test Case execution in progress..Case=====");
	}

	@AfterMethod
	public void addComment2() {
		log.info("==========Test Case execution completed===========");
	}

	@Test
	public void logout() throws Exception {
		// log.info("=====TestCase: LoginTest execution in progress");
		// validation - getting application URL
		Thread.sleep(2000);
		log.info("validation of logout passed, current application URL: " + driver.getCurrentUrl());
	}
}
