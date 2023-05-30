package com.kavya.shoppingcart;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.kavya.factory.PlaywrightFactory;
import com.kavya.pages.HomePage;
import com.kavya.pages.LoginPage;
import com.microsoft.playwright.Page;

public class BasePage {

	PlaywrightFactory playWrightFactory;
	Page page;
	HomePage homePage;
	LoginPage loginPage;

	@BeforeTest
	public void setUp() {
		try {
			playWrightFactory = new PlaywrightFactory();
			playWrightFactory.initProp();
			page = playWrightFactory.initBrowser();
			homePage = new HomePage(page);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}
