package com.qa.DPS.Pages;

import com.microsoft.playwright.Page;

public class SelectCountryPage {

	Page page;
	//constructor
	public SelectCountryPage(Page page)
	{
		
		this.page=page;
	}
	
	//locators
	private String headerWelcome = "//h3[starts-with(text(),'Welcome')]";
	private String selectCountry = "//select[@id='country-select']";
	private String btnNext = "(//button[@type='submit'])[1]";
	
	//methods
	public String getWelcomeMSG()
	{
		return page.textContent(headerWelcome);
	}
	
	public void SelectCountry(String str)
	{
		page.locator(selectCountry).selectOption(str);
	}
	
	public SelectTrimPage clickNext()
	{
		page.locator(btnNext).click();
		return new SelectTrimPage(page);
	}
	
}
