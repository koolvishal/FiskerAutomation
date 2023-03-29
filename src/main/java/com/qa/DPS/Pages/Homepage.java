package com.qa.DPS.Pages;

import com.microsoft.playwright.Page;

public class Homepage {

	Page page;
	
		//locators
		private String btnReserve = "(//button[contains(@class,'MuiButtonBase-')])[2]/span[contains(text(),'Reserve')]";
		private String lblHello = "//h6[contains(text(),'Hello!')]";
		//1st Reservation locator
		private String lblReservationFirst = "//li[contains(@class,'css-')]//h2[contains(text(),'Reservation')]";
		private String headerFiskerOcean = "//h1[contains(text(),'Fisker Ocean')]";
	
	
	//constructor
	public Homepage(Page page)
		{
			this.page=page;
		}
	
	public Createreservationpage clickReserve()
	{
		page.click(btnReserve);
		return new Createreservationpage(page);
	}
	
	public String getHelloMSG()
	{
		String strMsg = page.textContent(lblHello);
		return strMsg;
	}
	
	public String getHeaderMSG()
	{
		String strMsg = page.textContent(headerFiskerOcean);
		return strMsg;
	}
	
	public String getFirstReservationMsg()
	{
		String strMsg = page.textContent(lblReservationFirst);
		return strMsg;
	}
	
	
	
	
	
}
