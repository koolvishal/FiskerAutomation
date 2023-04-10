package com.qa.DPS.Pages;

import com.microsoft.playwright.Page;

public class Createreservationpage {

	Page page;
	

	//constructor
	public Createreservationpage(Page page)
		{
			this.page=page;
		}
	
		//locators
		private String txtNameOncard = "//input[@id='nameOnCard']";
		private String txtCardNumber = "//input[@placeholder='0000-0000-0000-0000']";
		private String txtExpirationDate = "//input[@placeholder='MM/YY']";
		private String txtCVC = "//input[@placeholder='000']";
		private String txtBillingZip = "//input[@placeholder='00000']";
		private String btnConfirm = "//button[@id='confirm']";
		private String iframeCardNo = "(//iframe[contains(@name,'privateStripeFrame')])[1]";
		private String iframeExpDate = "(//iframe[contains(@name,'privateStripeFrame')])[2]";
		private String iframeCVC = "(//iframe[contains(@name,'privateStripeFrame')])[3]";
		private String lblResrevationSuccessMsg = "//h1[@id='reservation_successful1']";
		private String btnProceedToAccount= "(//button[contains(@class,'MuiButtonBase-')])[2]/span[1]/span[1]";
		private String lblResrevationSuccessMsg2 = "//h1[@id='reservation_successful2']";
		
		//methods
		public void EnterNameOfCardOwner(String strName)
		{
			page.fill(txtNameOncard, strName);
		}
		
		public void EnterCardNo(String strCardNo)
		{
			page.frameLocator(iframeCardNo).locator(txtCardNumber).fill(strCardNo);
		}
		
		public void EnterExpDate(String strExpDate)
		{
			page.frameLocator(iframeExpDate).locator(txtExpirationDate).fill(strExpDate);
		}
		
		public void EnterCVC(String strCVC)
		{
			page.frameLocator(iframeCVC).locator(txtCVC).fill(strCVC);
		}
		
		public void EnterBillingZip(String strBillingZip)
		{
			page.locator(txtBillingZip).fill(strBillingZip);
		}
		
		
		public void ClickConfirm()
		{
		  page.locator(btnConfirm).click(); 
		   
		 }
		 
		public String getResSuccessMsg()
		{
			String strMsg = page.textContent(lblResrevationSuccessMsg);
			return strMsg;
		}
		
		public String getResSuccessMsgSecond()
		{
			String strMsg = page.textContent(lblResrevationSuccessMsg2);
			return strMsg;
		}
			
		public void clickProceedToAccount()
		{
			page.locator(btnProceedToAccount).click();
			
		}
		
		public boolean createReserve(String strName,String strcardNo,String strExpDate,String strCVC,String strBillingZip)
		{
			page.fill(txtNameOncard, strName);
			page.frameLocator(iframeCardNo).locator(txtCardNumber).fill(strcardNo);
			//page.fill(txtCardNumber, strcardNo);
			page.frameLocator(iframeExpDate).locator(txtExpirationDate).fill(strExpDate);
			//page.fill(txtExpirationDate, strExpDate);
			page.frameLocator(iframeCVC).locator(txtCVC).fill(strCVC);
			//page.fill(txtCVC, strCVC);
			page.fill(txtBillingZip, strBillingZip);
			page.click(btnConfirm);
			return true;
		}
		
		
		
}
