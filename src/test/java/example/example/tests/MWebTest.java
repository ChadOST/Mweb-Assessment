package example.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import example.example.factory.PageinstancesFactory;
import example.example.pages.MwebHomePage;

@Test(testName = "Facebook login test", description = "Facebook login test")
public class MWebTest extends BaseTest {

	@Test
	public void mwebHomePageCoverageTest() 
	{
		driver.get("https://www.mweb.co.za/");
		MwebHomePage mwebHomePage = PageinstancesFactory.getInstance(MwebHomePage.class);
		Assert.assertTrue(mwebHomePage.enterAddress("4 Jansen Street Aurora"), "Failed To Enter Text Into Coverage Input Field");
		Assert.assertTrue(mwebHomePage.validateAvaiableProvider("Openserve"),"Could not Find Expected Coverage For Openserve");
		Assert.assertTrue(mwebHomePage.validateAvaiableProvider("Vumatel"),"Could not Find Expected Coverage For Vumatel");
		Assert.assertTrue(mwebHomePage.clickFirstOpenserveResult(),"Could not select the first Openserve Result");
	}
}
