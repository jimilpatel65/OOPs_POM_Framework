package com.qa.my.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends AbstractPage
{

	public BasePage(WebDriver driver) 
	{
		super(driver);
	}
	
	//Implementation of the Methods defined in the Abstract Class:
	@Override
	public String getPageTitle() 
	{
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) 
	{
		return getElement(locator).getText();
	}
	
	@Override
	public WebElement getElement(By locator) 
	{
		WebElement element;
	//This type of Code structure is called "Wrapper Function":
		try
		{
			waitForElementPresent(locator);
			element = driver.findElement(locator);
			return element;
		}
		catch (Exception e)
		{
			System.out.println("Some Error Occured While Creating Element By: " + locator.toString());
			e.printStackTrace();
			return element = null; //This will return "null" value in the output if the code in the try block fails.
		}
		 
	}

	@Override
	public void waitForElementPresent(By locator) 
	{
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		catch (Exception e)
		{
			System.out.println("Some Error Occured While Waiting For the Element: " + locator.toString());
			e.printStackTrace();
		}
	}

	@Override
	public void waitForPageTitle(String title) 
	{
		try
		{
			wait.until(ExpectedConditions.titleContains(title));
		}
		catch (Exception e)
		{
			System.out.println("Some Error Occured While Waiting For the Element: " + title);
			e.printStackTrace();
		}
	}
	
}
