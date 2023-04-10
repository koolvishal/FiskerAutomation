package com.qa.DPS.Tests;

import java.awt.Window;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import com.microsoft.playwright.JSHandle;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.BoundingBox;
import com.microsoft.playwright.options.LoadState;
import com.qa.DPS.Base.BaseTest;
import com.qa.DPS.Pages.CreateOrderPage;

public class CreateOrderPageTest extends BaseTest {

	
	@Test(priority=1)
	public void VerifyCreateOrder() throws Exception 
	{
		  loginpage.clickAcceptCookies();
		  loginpage.clickMenu();
		  loginpage.clickAccountUnderMenu();
		  homegpage=loginpage.Login("automation3@qa.com","Test@1234");
		  selectcountrypage=homegpage.clickGetStarted();
		  String strActMSG = selectcountrypage.getWelcomeMSG();
		  Assert.assertEquals(strActMSG, "Welcome. Let's get started.");
		  selectcountrypage.SelectCountry("United States");
		  Thread.sleep(5000);
		  selecttrimpage = selectcountrypage.clickNext();
		  Thread.sleep(3000);
		  selecttrimpage.SelectExtremeTrim();
		  selecttrimpage.ClickConfigure();
		  Boolean flag= selecttrimpage.btnTrimSelector();
		  Assert.assertTrue(flag);
		  createOrderPage = new CreateOrderPage(page);
		  //createOrderPage.waitForUnity();
		  Thread.sleep(40000);
		  createOrderPage.clickUnity(307, 398);
		  Thread.sleep(2000);
		  createOrderPage.clickUnity(742, 265);
		  Thread.sleep(2000);
		  createOrderPage.clickUnity(349, 394);
		  Thread.sleep(2000);
		  createOrderPage.clickUnity(741, 302);
		  Thread.sleep(2000);
		  createOrderPage.clickUnity(741, 334);
		  Thread.sleep(2000);
		  createOrderPage.clickUnity(426, 400);
		  Thread.sleep(2000);
		  createOrderPage.clickUnity(709, 464);
		  Thread.sleep(2000);
		  createOrderPage.clickUnity(692, 455);
		  Thread.sleep(2000);
		  
		  
		  
		  

	}
	
	
	 
	
	
	
	
	
	
	
	
	
	
}
