package com.qa.my.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.qa.my.pages.AbstractPage;
import com.qa.my.pages.BasePage;

public class BaseTest
{
	WebDriver driver;
	public AbstractPage apage;
	
	@Parameters(value={"browser"}) //All the Parameters are defined in the Project's TestNG.xml file in the form of "Key:Value" pair
	@BeforeMethod
	public void openBrowser(String browser) throws InterruptedException
	{
//		if(browser.equals("Firefox")) 
//		{
//			//System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
//			WebDriverManager.firefoxdriver().setup(); // "WebDriverManager" dependency allows us to access and manage the Drivers easily. (Not need to define specific Path)
//			driver = new FirefoxDriver();
//		} 
//		else if (browser.equals("Chrome"))
//		{
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();	  
//		}
		
		if(browser.equals("Firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		} 
		else if (browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();	  
		}
		else
		{
			System.out.println("No Browser Defined in the TestNG.xml file.");
		}
		
		apage = new BasePage(driver);
		driver.get("https://ui.cogmento.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//We can not call the Abstract Class directly using its object. For that, we need to use to Object of Abstract class and initiate it through the Constructor of its Child class "BasePage()"
		
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		System.out.println("After Method Tested and is Working Fine.");
		driver.quit();
	}
}
