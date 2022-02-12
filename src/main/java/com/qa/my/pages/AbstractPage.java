package com.qa.my.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage 
{
	WebDriver driver;
	WebDriverWait wait;
	
	//Constructor:
	public AbstractPage(WebDriver driver) 
	{
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver,15);
	}
	
	//Abstract Methods for the Page Classes:
	public abstract String getPageTitle();
	public abstract String getPageHeader(By locator);
	public abstract WebElement getElement(By locator);
	public abstract void waitForElementPresent(By locator);
	public abstract void waitForPageTitle(String title);
	
	//Abstract Method for the constructor of Base Page class:
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) 
	{
		try 
		{
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	
}
