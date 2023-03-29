package com.qa.DPS.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.DPS.Base.BaseTest;

public class CreatereservationpageTest extends BaseTest {

	
	
	@Test(priority=1)
	public void VerifyCreateReservation()
	{
		  loginpage.clickAccount();
		  homegpage=loginpage.Login("automation2@qa.com", "Test@1234");
		  createreservationpage=homegpage.clickReserve(); 
		  createreservationpage.EnterNameOfCardOwner("autousa");
		  createreservationpage.EnterCardNo("4242424242424242");
		  createreservationpage.EnterExpDate("06/24");
		  createreservationpage.EnterCVC("123");
		  createreservationpage.EnterBillingZip("99999");
		  createreservationpage.ClickConfirm();
		  String act = createreservationpage.getResSuccessMsg();
		  Assert.assertEquals(act, "Your First Fisker Ocean is now Reserved!");
		  
		
	}
	
	
	
}
