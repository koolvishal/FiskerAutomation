package com.qa.DPS.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.DPS.Utilities.*;
import com.qa.DPS.Base.BaseTest;
import com.qa.DPS.Pages.AddNewReservationpage;
import com.qa.DPS.Pages.Homepage;

public class CreatereservationpageTest extends BaseTest {

	
	@Test(dataProvider="createReservationtestData",priority=1)
	public void VerifyFirstOceanReservation(String cardowner,String cardno,String expdate,String CVC,String zip)
	{
		  loginpage.clickAcceptCookies();
		  loginpage.clickMenu();
		  loginpage.clickAccountUnderMenu();
		  homegpage=loginpage.Login("automation4@qa.com","Test@1234");
		  createreservationpage=homegpage.clickReserve(); 
		  createreservationpage.EnterNameOfCardOwner(cardowner);
		  createreservationpage.EnterCardNo(cardno);
		  createreservationpage.EnterExpDate(expdate);
		  createreservationpage.EnterCVC(CVC);
		  createreservationpage.EnterBillingZip(zip);
		  createreservationpage.ClickConfirm();
		  String act = createreservationpage.getResSuccessMsg();
		  Assert.assertEquals(act, "Your First Fisker Ocean is now Reserved!");
		  createreservationpage.clickProceedToAccount();
		  String actReserVationID= homegpage.getReservationID();
		  System.out.println("first Reservation "+actReserVationID);
		  Assert.assertNotNull(actReserVationID);
		 
		  

	}
	
	
	 @Test(dataProvider="createReservationtestData",priority=2)	
	  public void VerifySecondOceanReservation(String cardowner,String cardno,String expdate,String CVC,String zip) throws Exception 
	  {
		  loginpage.clickMenu(); 
		  loginpage.clickAddNewUnderMenu();
		  addNewReservationpage = new AddNewReservationpage(page); 
		  //addNewReservationpage.clickAddNew(); 
		  addNewReservationpage.clickReserveOnOceanTile();
		  createreservationpage.EnterNameOfCardOwner(cardowner);
		  createreservationpage.EnterCardNo(cardno);
		  createreservationpage.EnterExpDate(expdate);
		  createreservationpage.EnterCVC(CVC);
		  createreservationpage.EnterBillingZip(zip);
		  createreservationpage.ClickConfirm(); 
		  String act =createreservationpage.getResSuccessMsgSecond();
		  Assert.assertEquals(act,"Your Second Fisker Ocean is Reserved!");
		  createreservationpage.clickProceedToAccount();
		  //homegpage.clickReservation();
		  Thread.sleep(3000);
		  loginpage.clickMenu(); 
		  loginpage.clickSecondResOption();
		  String actReserVationID= homegpage.getReservationID();
		  System.out.println("Second Reservation "+actReserVationID);
		  Assert.assertNotNull(actReserVationID);
		 
		  
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
