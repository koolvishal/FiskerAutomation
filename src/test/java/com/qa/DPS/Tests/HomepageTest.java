package com.qa.DPS.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.DPS.Base.BaseTest;

public class HomepageTest extends BaseTest{

	
	@Test(priority=1)
	public void VerifyHelloMSG() 
	{ String strAct = homegpage.getHelloMSG();
		Assert.assertEquals(strAct, "Hello!");
		  
	}
		 

	@Test(priority=2)
	public void VerifyClickReserve()
	{
			createreservationpage = homegpage.clickReserve();
			
			
	}
	
	
}
