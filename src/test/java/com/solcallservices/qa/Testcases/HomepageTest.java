package com.solcallservices.qa.Testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.solcallservices.qa.Base.TestBase;
import com.solcallservices.qa.pages.Homepage;

public class HomepageTest extends TestBase {
	
	
	Homepage homepage;



	public HomepageTest() {

		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		//testutil=new Testutil();
		//contactpage=new Contactspage();
		homepage=new Homepage ();
	

	}
	@Test(priority=1)
	public void verifyHomepageTitleTest() {
		String homepageTitle=homepage.validatehomepageTitle();
	Assert.assertEquals(homepageTitle, "SOLCALL SERVICES","Homepage Title is not matched");

	}
   @Test(priority=2)
	public void  VerifysolcallserviceslogoTest() {
		//testutil.switchtoframe();
	boolean a=	homepage.solcallserviceslogo();
	AssertJUnit.assertTrue(a);


	}
	@Test(priority=3)
	public void scrolldownTest() {
		homepage.scrollpagedown(driver);

		
		
	}
	@Test(priority=4)
   public void getpageInnerTextTest() {
		homepage.getpageInnerText(driver);
		System.out.println(homepage.getpageInnerText(driver));
		
  }
	@Test(priority=5)
	public void getintouchbtntest() {
		homepage.validateGettochbtn();
		
	}
	@Test(priority=6)
	public void readmorebtntest() {
		homepage.validdatereadmorebtn();
		
	}	@Test(priority=7)
	public void verifyHomepageText() {
	boolean b1=	homepage.validateHomeText();
	Assert.assertTrue(b1);
	
		 
	}
	@Test(priority=8)
	
  public void validateAboutnetsuitelinkTest() {
	homepage.validateAboutnetsuite();
		
	}
	@Test(priority=9)
	public void validatenetsuiteserviceslinkTest() {
		homepage.validateNetsuiteservices();		
  }
	@Test(priority=10)
	public void integratedproductlinkTest() {
	homepage.validateIntegratedproductlink();
		
	}
  @Test(priority=11)
	public void validateservicelinkTest() {
	homepage.validateservicelink();		
	}
	@Test(priority=12)
    public void validatecontactlinkTest() {
	homepage.validatecontactlink("Raju", "Rajukumar@123", "Hi raju is here");		

	}
	@Test(priority=13)
	public void validateNumberoflinkTest() throws MalformedURLException, IOException {
		homepage.validateNumberofBrokenlink();
		
	}




	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}


}
