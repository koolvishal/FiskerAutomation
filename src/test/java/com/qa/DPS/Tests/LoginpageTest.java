package com.qa.DPS.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.DPS.Base.BaseTest;

public class LoginpageTest extends BaseTest{

	
	  @Test(priority=1)
	  public void VerifyClickAccountlnk() 
	  {
		  loginpage.clickAccount(); String strAct = loginpage.getWelcomeMsg();
		  Assert.assertEquals(strAct, "Welcome back.");
	  
	  }
	 
	 
	
	@Test(priority=1)
	public void VerifyLogin()
	{
		loginpage.clickAccount();
		homegpage = loginpage.Login("automation@qa.com", "Test@1234");
		String str = homegpage.getHeaderMSG();
		Assert.assertEquals(str, "Fisker Ocean");
		
	
	}
	
	
	
	
}
