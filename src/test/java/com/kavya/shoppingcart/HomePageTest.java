package com.kavya.shoppingcart;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kavya.utilities.Constants;

public class HomePageTest extends BasePage {

	@Test
	public void homePageTitleTest() {
		String actualTitle = homePage.getHomePageTitle();
		System.out.println("Page title is =" + actualTitle);
		Assert.assertEquals(actualTitle, Constants.HOME_PAGE_TITLE);
	}

	@Test
	public void homePageURLTest() {
		String actualURL = homePage.getHomePageUrl();
		Assert.assertEquals(actualURL, "https://naveenautomationlabs.com/opencart/");
	}

	@DataProvider
	public Object[][] productData() {
		return new Object[][] { { "Macbook" }, { "imac" }, { "Samsung" } };
	}

	@Test(dataProvider = "productData")
	public void searchProduct(String productName) {
		String actualHeader = homePage.doSearch(productName);
		Assert.assertEquals(actualHeader, "Search - " + productName);
	}

	@Test
	public void loginTest() {
		homePage.clickOnLogin();
	}

}
