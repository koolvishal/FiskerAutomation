package com.qa.DPS.Pages;

import com.microsoft.playwright.Page;

public class Loginpage {

	Page page;
		//locators
		//private String lnkCreateAccount = "//a[@href='/create-account']";
		private String btnAcceptCookies = "//button[@id='onetrust-accept-btn-handler']";
		private String btnMenu = "//button[@id='menuNavLink']";
		private String lnkAccountUnderMenu = "//a[@data-testid='primary-link15']/span[1]";
		private String lnkAccount = "//a[@id='accountNavLink2']";
		private String lblWelcome = "//h2[contains(text(),'Welcome back.')]";
		private String txtemail = "//input[@id='email']";
		private String txtpassword = "//input[@id='password']";
		private String btnSignin = "(//button[@type='submit'])[1]";
		
		//constructor
		public Loginpage(Page page)
		{
			this.page=page;
		}
	
		//methods
		public void clickAcceptCookies()
		{
			
			page.click(btnAcceptCookies);
			
		}
		public void clickMenu()
		{
			
			page.click(btnMenu);
			
		}
		
		public void clickAccountUnderMenu()
		{
			
			page.click(lnkAccountUnderMenu);
			
		}
		
		public void clickAccount()
		{
			page.click(lnkAccount);
		}
		
		public String getWelcomeMsg()
		{
			String strmsg = page.textContent(lblWelcome);
			return strmsg;
		}
		
		public void enterUsername(String username)
		{
			page.fill(txtemail, username);
		}
		
		public void enterPassword(String password)
		{
			page.fill(txtpassword, password);
		}
		
		public void clickLogin()
		{
			page.click(btnSignin);
		}
		
		public Homepage Login(String username,String password)
		{
			enterUsername(username);
			enterPassword(password);
			clickLogin();
			return new Homepage(page);
			/*
			 * String str = page.textContent(strHello); if(str.contains("Hello!")) {
			 * System.out.println("Login Successfull"); System.out.println("done"); }
			 */
			
			}
	
}
