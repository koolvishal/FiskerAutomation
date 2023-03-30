package com.qa.DPS.Factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
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
	
	private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
	private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
	private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
	private static ThreadLocal<Page> tlPage = new ThreadLocal<>();
	
	public static Playwright getPlaywright()
	{
		return tlPlaywright.get();
	}
	
	public static Browser getBrowser()
	{
		return tlBrowser.get();
	}
	
	public static BrowserContext getBrowserContext()
	{
		return tlBrowserContext.get();
	}
	
	public static Page getPage()
	{
		return tlPage.get();
	}
	
	
	public Page init(Properties prop)
	{
		String strBrowser = prop.getProperty("browser").trim();
		//playwright = Playwright.create();
		tlPlaywright.set(Playwright.create());
		 switch (strBrowser) 
		 {
		 case "chrome":
			 LaunchOptions lp = new LaunchOptions();
			 lp.setChannel("chrome");
			 lp.setHeadless(false);
			 //browser = playwright.chromium().launch(lp);
			 tlBrowser.set(getPlaywright().chromium().launch(lp));
			 break;
		 case "firefox":
			 LaunchOptions lp1 = new LaunchOptions();
			 lp1.setChannel("firefox");
			 lp1.setHeadless(false);
			 //browser = playwright.firefox().launch(lp1);
			 tlBrowser.set(playwright.firefox().launch(lp1));
			 break;
		 }
		 
		 //browserContext = browser.newContext(new Browser.NewContextOptions().setHttpCredentials(prop.getProperty("username").trim(), prop.getProperty("password").trim()));
		 tlBrowserContext.set(getBrowser().newContext(new Browser.NewContextOptions().setHttpCredentials(prop.getProperty("username").trim(), prop.getProperty("password").trim())));
		 //page = browserContext.newPage();
		 tlPage.set(getBrowserContext().newPage());
		 String strURL = prop.getProperty("url");
		// page.navigate(strURL);
		 getPage().navigate(strURL);
		 //return page;
		 return getPage();
		 
		 
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
	
	public static String takeScreenshot() {
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		//getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		
		byte[] buffer = getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		String base64Path = Base64.getEncoder().encodeToString(buffer);
		
		return base64Path;
	}
	
	
}
