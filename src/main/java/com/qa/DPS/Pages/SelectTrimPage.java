package com.qa.DPS.Pages;

import com.microsoft.playwright.Page;

public class SelectTrimPage {

	Page page;
	//constructor
	public SelectTrimPage(Page page)
	{
		
		this.page=page;
	}
	
	//locators
	private String lblExtreme = "(//button[@type='button' and @role='tab'])[1]/span[1]";
	private String lblUltra = "(//button[@type='button' and @role='tab'])[2]/span[1]";
	private String lblSport = "(//button[@type='button' and @role='tab'])[3]/span[1]";
	private String btnConfigure = "(//button[@type='button' ])[6]/span[1]";
	private String btnTrimSelector = "//span[contains(@class,'MuiTypography-button2')]/span[1]";
	
	//methods
	public void SelectExtremeTrim()
	{
		page.locator(lblExtreme).click();
	}
	
	public void SelectUltraTrim()
	{
		page.locator(lblUltra).click();
	}
	
	public void SelectSportTrim()
	{
		page.locator(lblSport).click();
	}
	
	public void ClickConfigure()
	{
		page.locator(btnConfigure).click();
	}
	
	public boolean btnTrimSelector()
	{
		return page.locator(btnTrimSelector).isVisible();
	}
	
}
