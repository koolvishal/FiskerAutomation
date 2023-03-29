package com.qa.DPS.Factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {

	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	static Page page;
	Properties prop;
	
	public Page init(Properties prop)
	{
		String strBrowser = prop.getProperty("browser").trim();
		playwright = Playwright.create();
		 switch (strBrowser) 
		 {
		 case "chrome":
			 LaunchOptions lp = new LaunchOptions();
			 lp.setChannel("chrome");
			 lp.setHeadless(false);
			 browser = playwright.chromium().launch(lp);
			 break;
			 //browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			 
			 
		 case "firefox":
			 LaunchOptions lp1 = new LaunchOptions();
			 lp1.setChannel("firefox");
			 lp1.setHeadless(false);
			 browser = playwright.firefox().launch(lp1);
			 break;
		 }
		 
		 browserContext = browser.newContext(new Browser.NewContextOptions().setHttpCredentials(prop.getProperty("username").trim(), prop.getProperty("password").trim()));
		 //browserContext = browser.newContext();
		 page = browserContext.newPage();
		 String strURL = prop.getProperty("url");
		 page.navigate(strURL);
		 
		 return page;
		 
		 
	}
	
	public Properties init_prop()
	{
		try {
			FileInputStream fi = new FileInputStream("./src/test/resources/Config/config.properties");
			prop = new Properties();
			prop.load(fi);
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return prop;
		
	}
	
	
}
