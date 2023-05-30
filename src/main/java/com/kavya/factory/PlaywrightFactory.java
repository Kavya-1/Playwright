package com.kavya.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {

	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;
	private Properties prop;
	ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<Playwright>();
	ThreadLocal<Browser> tlBrowser = new ThreadLocal<Browser>();
	ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<BrowserContext>();
	ThreadLocal<Page> tlPage = new ThreadLocal<Page>();

	private Playwright getTlPlaywright() {
		return tlPlaywright.get();
	}

	private Browser getTlBrowser() {
		return tlBrowser.get();
	}

	private BrowserContext getTlBrowserContext() {
		return tlBrowserContext.get();
	}

	private Page getTlPage() {
		return tlPage.get();
	}

	public Page initBrowser() {
		String browserName = prop.getProperty("browser");
		System.out.println("Browser name is ->" + browserName);
		playwright = Playwright.create();
		tlPlaywright.set(playwright);

		switch (browserName.toLowerCase()) {
		case "chromium":
			browser = getTlPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			tlBrowser.set(browser);
			break;
		case "firefox":
			browser = getTlPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			tlBrowser.set(browser);
			break;
		case "chrome":
			browser = getTlPlaywright().chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			tlBrowser.set(browser);
			break;
		default:
			System.out.println("Invalid browser name");

		}

		browserContext = getTlBrowser().newContext();
		tlBrowserContext.set(browserContext);
		page = getTlBrowserContext().newPage();
		tlPage.set(page);
		getTlPage().navigate(prop.getProperty("url"));
		return getTlPage();

	}

	// read config.properties
	public void initProp() throws IOException {
		FileInputStream stream = new FileInputStream(new File("./src/test/resources/config/config.properties"));
		prop = new Properties();
		prop.load(stream);

	}

}
