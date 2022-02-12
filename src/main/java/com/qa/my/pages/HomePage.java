package com.qa.my.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage
{
	private By header = By.xpath("//span[text()='Jimil Patel']");
	
	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
	
	public String getPageHeader()
	{
		return getElement(header).getText();
	}
	public String getHomePageHeader()
	{
		return getPageHeader(header);
	}
	public String getHomePageTitle()
	{
		return getPageTitle();
	}
	
	

}
