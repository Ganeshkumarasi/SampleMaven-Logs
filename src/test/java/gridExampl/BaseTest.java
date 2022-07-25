package gridExampl;

import java.net.MalformedURLException;

import java.net.URL;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	DesiredCapabilities cap;

	@Parameters("OS")
	@BeforeTest
	public void launchApp(String OSInfo) throws Exception {
		System.out.println("Execution of test on Platform: " + OSInfo);
		String node_win = "http://192.168.1.5:5588/wd/hub"; // edge
		String node_mac = "http://192.168.1.5:5566/wd/hub"; // chrome
		if (OSInfo.equalsIgnoreCase("win")) {
			cap = DesiredCapabilities.edge();
			cap.setBrowserName("MicrosoftEdge");
			cap.setPlatform(Platform.WINDOWS);
			WebDriverManager.edgedriver().setup();
			driver = new RemoteWebDriver(new URL(node_win), cap);
		}

		else if (OSInfo.equalsIgnoreCase("mac")) {
			// chrome
			cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			WebDriverManager.chromedriver().setup();
			driver = new RemoteWebDriver(new URL(node_mac), cap);
		} else {
			System.out.println("=========================");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@AfterTest
	public void closeApp() throws Exception {
		Thread.sleep(4000);
		driver.close();
	}

}
