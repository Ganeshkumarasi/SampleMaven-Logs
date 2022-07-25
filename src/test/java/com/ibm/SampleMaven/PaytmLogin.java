package com.ibm.SampleMaven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class PaytmLogin extends AppTest {

	@Test
	public void Login() throws InterruptedException {
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\SeleniumIDE recordings\\Selenium exports\\chromedriver_win32\\chromedriver.exe");
		driver.get("http://only-testing-blog.blogspot.com/2013/11/new-test.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//input[@type='button'])[3]")).click();
		Alert alt = driver.switchTo().alert();
		System.out.println("Alert message displayed " + alt.getText());
		alt.accept();
	}

}
