package example.example.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import example.example.factory.PageinstancesFactory;
import example.example.pages.MwebHomePage;
import example.example.pages.MwebProductPage;
import example.example.util.ReportUtil;

@Test(testName = "Mweb Coverage test", description = "Mweb Coverage test")
public class MWebTest extends BaseTest {

	@Test
	public void mwebHomePageCoverageTest() 
	{
		//Variables used to hold testdata
		//These can be updated to use different sources. for this PoC it will be hard coded
		//Feel free to change these to adjust the test outcome
		driver.get("https://www.mweb.co.za/");
		String title = "MWEB";
		String description = "Mweb's 25Mbps download and 10Mbps upload Uncapped Fibre from Openserve offers you a high speed internet connection at an affordable cost. Check your coverage." ; 
		int expectedNumberofResults = 2;

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		MwebHomePage mwebHomePage = PageinstancesFactory.getInstance(MwebHomePage.class);
		MwebProductPage mwebProductPage = PageinstancesFactory.getInstance(MwebProductPage.class);

		Assert.assertTrue(mwebHomePage.enterAddress("4 Jansen Street Aurora"), "Failed To Enter Text Into Coverage Input Field");
		ReportUtil.addScreenShot("Entered Text Into Coverage Input Field");

		Assert.assertTrue(mwebHomePage.SelectFirstAddress(), "Failed To Enter Text Into Coverage Input Field");
		ReportUtil.addScreenShot("Entered Text Into Coverage Input Field");

		Assert.assertTrue(mwebHomePage.validateAvaiableProvider("Openserve"),"Could not Find Expected Coverage For Openserve");
		ReportUtil.addScreenShot("Found Expected Coverage For Openserve");

		Assert.assertTrue(mwebHomePage.validateAvaiableProvider("Vumatel"),"Could not Find Expected Coverage For Vumatel");
		ReportUtil.addScreenShot("found Expected Coverage For Openserve");

		//Varaible is Dynamic based off the data provided on the Home Page
		String pageTitle = mwebHomePage.getPackageTitle();

		Assert.assertTrue(mwebHomePage.clickFirstOpenserveResult(),"Could not select the first Openserve Result");
		ReportUtil.addScreenShot("Successfully selected the first Openserve Result");

		Assert.assertTrue(mwebProductPage.validatePageTitle(pageTitle),"Page Title Did Not Match the Expected Value "+pageTitle);
		ReportUtil.addScreenShot("Made sure the Page Title Matched the Expected Value "+pageTitle);

		Assert.assertTrue(mwebProductPage.validateAvaiableProvider(expectedNumberofResults),"Available router options did not match the expected number of "+expectedNumberofResults);
		ReportUtil.addScreenShot("Available router options matched the expected number of "+expectedNumberofResults);

		Assert.assertTrue(mwebProductPage.validatePageTitleProperty(title),"Page Title Property did not match the expected title : "+title);
		ReportUtil.addScreenShot("Page Title Property matched the expected title : "+title);

		Assert.assertTrue(mwebProductPage.validatePageDescriptionProperty(description),"Page Description Property did not match the expected description : "+description);
		ReportUtil.addScreenShot("Page Description Property matched the expected description : "+description);

	}
}
