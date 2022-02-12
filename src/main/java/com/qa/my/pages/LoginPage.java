package com.qa.my.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage
{
	//Define Page Locators:
	private By emailID = By.xpath("//input[@name='email']");
	private By password = By.xpath("//input[@name='password']");
	private By loginButton = By.xpath("//div[text()='Login']");
	
	//Constructor:
	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}

	//Getters (Get the WebElements/ Define Actions to be performed):
	/**
	 * @return the emailID WebElement
	 */
	public WebElement getEmailID() 
	{
		return getElement(emailID);
	}

	/**
	 * @return the password WebElement
	 */
	public WebElement getPassword() 
	{
		return getElement(password);
	}

	/**
	 * @return the loginButton WebElement
	 */
	public WebElement getLoginButton() 
	{
		return getElement(loginButton);
	}

	/**
	 * @return the header WebElement
	 *
	public WebElement getHeader() 
	{
		return getElement(header);
	}
	*
	*/
	
	public String getLoginPageTitle()
	{
		String title = getPageTitle();
		return title;
	}
	
	//Method to Perform Login Functionality
	public HomePage performLogIn(String username, String psswd)
	{
		getEmailID().sendKeys(username);
		getPassword().sendKeys(psswd);
		getLoginButton().click();
		
		return getInstance(HomePage.class);
	}
	
	//Method Overriding to perform Null entry test
	public void performLogIn()
	{
		getEmailID().sendKeys("");
		getPassword().sendKeys("");
		getLoginButton().click();
	}
	
	//Method Overriding to perform test with either one of the entries as Null
	public void performLogIn(String userCred)
	{
		if (userCred.contains("Username"))
		{
			getEmailID().sendKeys(userCred.split(":")[1].trim()); 
			/*
			 * If the UserCred says "Username: abc@gmail.com" then "userCred.split(":")[1].trim()" will first Split the String statement into two half 
			 *considering ":" as the splitter point and "[1]" is the ArrayIndex that will bring out the value "abc@gmail.com" 
			 *and lastly "trim()" will trim the String to the value selected.
			 *
			 */
		}
		else if (userCred.contains("Password"))
		{
			getPassword().sendKeys(userCred.split(":")[1].trim());
		}
		getLoginButton().click();
	}

}
