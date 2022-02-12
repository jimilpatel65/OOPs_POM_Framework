package com.qa.my.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.my.pages.HomePage;
import com.qa.my.pages.LoginPage;

public class LoginPageTest extends BaseTest
{
	@Test (priority = 1)
	public void verifyLoginPageTitleTest()
	{
		String actTitle = apage.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println(actTitle);
		String expTitle = "Cogmento CRM";
		Assert.assertEquals(actTitle, expTitle);
	}
	
	@Test (priority = 2)
	public void performLoginActionTest()
	{
		HomePage homePage = apage.getInstance(LoginPage.class).performLogIn("jimilpatel68@gmail.com", "Test@123");
		String homeHeader = homePage.getHomePageHeader();
		System.out.println(homeHeader);
		Assert.assertEquals(homeHeader, "Jimil Patel");
	}
}
