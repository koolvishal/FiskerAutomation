package com.qa.DPS.Pages;

import com.microsoft.playwright.Page;

public class AddNewReservationpage {

	Page page;
	
	
		//locators
		private String lnkAddNewReservation = "//a[starts-with(@href,'/account/my-orders?addNew=')]";
		private String btnReserveOnOcean = "//a[starts-with(@href,'/reserve/ocean')]/span[1]";
		
		
		//constructor
		public AddNewReservationpage(Page page)
		{
			this.page=page;
		}
	
		
		
		//methods
		public void clickAddNew()
		{
			
			page.locator(lnkAddNewReservation).click();
			
		}
		
		public void clickReserveOnOceanTile()
		{
			page.locator(btnReserveOnOcean).click();
		}
		
	
}
