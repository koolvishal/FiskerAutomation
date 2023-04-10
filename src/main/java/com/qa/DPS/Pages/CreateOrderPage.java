package com.qa.DPS.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CreateOrderPage {

	Page page;
	

	//constructor
	public CreateOrderPage(Page page)
		{
			this.page=page;
		}
	
	//locators
	private String unity = "//canvas[@id='react-unity-webgl-canvas-1']";
	private String lnkTrimSelector = "//span[contains(text(),'Trim Selector')]";	
		
	//methods
	public void clickUnity(double xCord, double yCord)
	{
		page.locator(unity).click(new Locator.ClickOptions() .setPosition(xCord, yCord));
	}
		
	public void waitForUnity()
	{
		page.waitForSelector(unity);
	}
	
	public boolean isVisibleTrimSelector()
	{
		return page.locator(lnkTrimSelector).isVisible();
	}
	
	public void waitForTrimSelector()
	{
		page.waitForSelector(lnkTrimSelector);
		
	}
		
}
