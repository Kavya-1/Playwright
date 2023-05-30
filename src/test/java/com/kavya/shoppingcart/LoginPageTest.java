package com.kavya.shoppingcart;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kavya.utilities.Constants;

public class LoginPageTest extends BasePage {

	@Test(priority = 1)
	public void verifyPageTitle() {
		loginPage = homePage.clickOnLogin();
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, Constants.LOGIN_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void testLogin() {
		loginPage.login("naveenanimation20@gmail.com", "Selenium@12345");
	}
}
