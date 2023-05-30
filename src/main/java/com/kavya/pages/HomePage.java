package com.kavya.pages;

import com.microsoft.playwright.Page;

public class HomePage {

	private Page page;

	private String searchIcon = "button i[class*='search']";
	private String searchText = "input[name=\"search\"]";
	private String headerSearch = "div#content h1";
	private String myAccount = "a[title*='Account']";
	private String login = "a[href*='login']";

	public HomePage(Page page) {
		this.page = page;
	}

	public String getHomePageTitle() {
		return page.title();
	}

	public String getHomePageUrl() {
		return page.url();
	}

	public String doSearch(String productName) {
		page.fill(searchText, productName);
		page.click(searchIcon);
		String header = page.textContent(headerSearch);
		return header;
	}

	public LoginPage clickOnLogin() {
		page.click(myAccount);
		page.click(login);
		return new LoginPage(page);
	}
}
