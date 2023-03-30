package com.qa.DPS.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.DPS.Utilities.*;
import com.qa.DPS.Base.BaseTest;

public class CreatereservationpageTest extends BaseTest {

	
	@Test(dataProvider="createReservationtestData",priority=1)
	public void VerifyCreateReservation(String cardowner,String cardno,String expdate,String CVC,String zip)
	{
		  loginpage.clickAccount();
		  homegpage=loginpage.Login("automation2@qa.com","Test@1234");
		  createreservationpage=homegpage.clickReserve(); 
		  createreservationpage.EnterNameOfCardOwner(cardowner);
		  createreservationpage.EnterCardNo(cardno);
		  createreservationpage.EnterExpDate(expdate);
		  createreservationpage.EnterCVC(CVC);
		  createreservationpage.EnterBillingZip(zip);
		  createreservationpage.ClickConfirm();
		  String act = createreservationpage.getResSuccessMsg();
		  Assert.assertEquals(act, "Your First Fisker Ocean is now Reserved!");

	}
	
	@DataProvider(name="createReservationtestData")
	public String[][] getdata() throws IOException
	{
		String path = "./src\\test\\resources\\Data\\createReservationtestData.xlsx";
		XLUtils xlutils = new XLUtils(path);
		
		int totalrowcount = xlutils.getRowCount("Sheet1");
		int totalcolcount = xlutils.getCellCount("Sheet1", 1);
		
		String createReservationtestData[][] = new String[totalrowcount][totalcolcount];
		
		for(int i=1;i<=totalrowcount;i++)
		{
			for(int j=0;j<totalcolcount;j++)
			{
				createReservationtestData[i-1][j]=xlutils.getCellData("Sheet1", i, j);
			}
			
		}
		
		return createReservationtestData;
		
	}
	
	
	
}
