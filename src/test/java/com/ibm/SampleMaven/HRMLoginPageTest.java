package com.ibm.SampleMaven;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMLoginPageTest {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	Logger log;
	
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
		log =  Logger.getLogger("IBMModule");
		PropertyConfigurator.configure(".\\ConfigProperties\\log4j.properties");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		log.info("=================================");

        log.info("chrome browser launched.");
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void hRMLoginPage() {
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("Opened the application");
		driver.findElement(By.id("txtUsername")).click();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).click();
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();

		{
			WebElement element = driver.findElement(By.xpath("//b[contains(text(),'Dashboard')]"));
			String dashboardActual = element.getText();
			Assert.assertEquals("Dashboard", dashboardActual);
			System.out.println("Dashboard page verified");
		}
		{
			List<WebElement> elements = driver.findElements(By.cssSelector("#menu_dashboard_index > b"));
			assert (elements.size() > 0);
		}

		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
		System.out.println("Logged out of the app");
	}
}
