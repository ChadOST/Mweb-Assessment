package example.example.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import example.example.factory.PageinstancesFactory;
import example.example.pages.MwebHomePage;
import example.example.util.ReportUtil;

@Test(testName = "Mweb Coverage test", description = "Mweb Coverage test")
public class MWebTest extends BaseTest {

	@Test
	public void mwebHomePageCoverageTest() 
	{
		driver.get("https://www.mweb.co.za/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		MwebHomePage mwebHomePage = PageinstancesFactory.getInstance(MwebHomePage.class);

		Assert.assertTrue(mwebHomePage.enterAddress("4 Jansen Street Aurora"), "Failed To Enter Text Into Coverage Input Field");
		ReportUtil.addScreenShot("Entered Text Into Coverage Input Field");

		Assert.assertTrue(mwebHomePage.SelectFirstAddress(), "Failed To Enter Text Into Coverage Input Field");
		ReportUtil.addScreenShot("Entered Text Into Coverage Input Field");

		Assert.assertTrue(mwebHomePage.validateAvaiableProvider("Openserve"),"Could not Find Expected Coverage For Openserve");
		ReportUtil.addScreenShot("Entered Text Into Coverage Input Field");

		Assert.assertTrue(mwebHomePage.validateAvaiableProvider("Vumatel"),"Could not Find Expected Coverage For Vumatel");
		ReportUtil.addScreenShot("Entered Text Into Coverage Input Field");
		
		Assert.assertTrue(mwebHomePage.clickFirstOpenserveResult(),"Could not select the first Openserve Result");
	}
}
