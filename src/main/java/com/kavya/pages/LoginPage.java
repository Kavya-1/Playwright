package com.kavya.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	private String usernameText = "input[name='email']";
	private String passwordText = "input[name='password']";
	private String loginButton = "input[value='Login']";
	private Page page;

	public LoginPage(Page page) {
		this.page = page;
	}

	public String getLoginPageTitle() {
		return page.title();
	}

	public void login(String username, String password) {
		page.fill(usernameText, username);
		page.fill(passwordText, password);
		page.click(loginButton);
		System.out.println("User logged in");
	}

}
