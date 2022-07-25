package com.ibm.SampleMaven;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	public WebDriver driver;
	public Map<String, Object> vars;
	JavascriptExecutor js;

	@BeforeTest
	@Parameters("browserType")
	public void setUp(String browser) {
//		System.setProperty("webdriver.chrome.driver","C:\\SeleniumIDE recordings\\Selenium exports\\chromedriver_win32\\chromedriver.exe");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Executing in Chrome browser");
		}
		if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Executing in edge browser");
		}

		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
