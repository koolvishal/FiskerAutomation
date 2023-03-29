package com.qa.DPS.Base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.DPS.Factory.PlaywrightFactory;
import com.qa.DPS.Pages.Createreservationpage;
import com.qa.DPS.Pages.Homepage;
import com.qa.DPS.Pages.Loginpage;


public class BaseTest {

	protected Page page; 
	PlaywrightFactory playwrightfactory;
	protected Loginpage loginpage; 
	protected Homepage homegpage; 
	protected Createreservationpage createreservationpage; 
	Properties prop;
	
	@BeforeTest
	public void setup()
	{
		playwrightfactory = new PlaywrightFactory();
		prop=playwrightfactory.init_prop();
		page = playwrightfactory.init(prop);
		loginpage = new Loginpage(page);
		//homegpage = new Homepage(page);
		//paymentpage = new Createreservationpage(page);
		//reservationsuccesspage = new ReservationSuccesspage(page);
		
	}
	
	@AfterTest
	public void tearDown()
	{
		page.context().browser().close();
	}
	
}
