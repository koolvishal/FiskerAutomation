package com.qa.DPS.Pages;

import com.microsoft.playwright.Page;

public class Homepage {

	Page page;
	
		//locators
		private String btnReserve = "(//button[contains(@class,'MuiButtonBase-')])[2]/span[contains(text(),'Reserve')]";
		private String lblHello = "//h6[contains(text(),'Hello!')]";
		//1st Reservation locator
		//private String lblReservationFirst = "//li[contains(@class,'css-')]//h2[contains(text(),'Reservation')]";
		private String headerFiskerOcean = "//h1[contains(text(),'Fisker Ocean')]";
		private String lblReservationFirst = "(//a[starts-with(@href,'/account/my-orders')])[2]/h2[2]";
		private String lblReservationSecond = "(//a[starts-with(@href,'/account/my-orders')])[3]/h2[2]";
		private String btnGetStarted = "//a[starts-with(@href,'/account/order/ocean?reservationId')]";
		private String reservationID = "//h6[@data-id='date']";
		
		
		
		
		
		
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
	
	public String getReservationID()
	{
		String strMsg = page.textContent(reservationID);
		return strMsg;
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
	
	public String getSecondReservationMsg()
	{
		String strMsg = page.textContent(lblReservationSecond);
		return strMsg;
	}
	
	public void clickReservation()
	{
		page.locator(lblReservationSecond).click();
		
	}
	
	public SelectCountryPage clickGetStarted()
	{
		page.locator(btnGetStarted).click();
		return new SelectCountryPage(page);
		
	}
	
	
	
	
	
	
}
