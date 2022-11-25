package example.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.LogStatus;

import example.example.util.ReportUtil;
/**
 * The Class represents The Mweb Home Page.
 *
 * @author CWilliams
 */
public class MwebHomePage extends BasePage {

	//Web Elements Needed to conduct tests
	@FindBy(id = "coverage")
	private WebElement coverageInput;

	@FindBy(className = "svg-inline--fa fa-magnifying-glass md:hidden h-5")
	private WebElement checkCoverageButton;

	@FindBy(xpath = "(//span[@href = '/fibre/openserve/uncapped-25mbps-download-10mbps-upload']//button)[2]")
	private WebElement firstOpenserveResultButton;

	

	public MwebHomePage(WebDriver driver) {
		super(driver);
	}

	public Boolean enterAddress(String address) {
		try 
		{
			coverageInput.sendKeys(address);
		} catch (Exception e) 
		{
			ReportUtil.addScreenShot(LogStatus.FAIL,"exception : " + e.getMessage());
			return false;
		}
		return true;
	}

	public Boolean SelectFirstAddress() {
		try 
		{
			Thread.sleep(1000);
			coverageInput.sendKeys(Keys.DOWN);
			Thread.sleep(500);
			coverageInput.sendKeys(Keys.RETURN);
			
		} catch (Exception e) 
		{
			ReportUtil.addScreenShot(LogStatus.FAIL,"exception : " + e.getMessage());
			return false;
		}
		return true;
	}

	//Using a Dynamic imput this method checks for an Xpath with the expected provider
	//This method could also be adjusted to used to take in an array of Strings and validate against that
	public Boolean validateAvaiableProvider(String expectedProvider) {
		
		WebElement availableProvider = driver.findElement(By.xpath("//img[@alt='"+expectedProvider+"']"));
		
		if(availableProvider.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public String getPackageTitle()
	{
		firstOpenserveResultButton.isDisplayed();
		WebElement titleText = driver.findElement(By.xpath("(//span[@href = '/fibre/openserve/uncapped-25mbps-download-10mbps-upload']//button)[2]"+"/../../..//h1"));
		return titleText.getText();
	}

	public Boolean clickFirstOpenserveResult() {
		try 
		{
			firstOpenserveResultButton.isDisplayed();
			firstOpenserveResultButton.click();
			
		} catch (Exception e) 
		{
			ReportUtil.addScreenShot(LogStatus.FAIL,"exception : " + e.getMessage());
			return false;
		}
		return true;
	}
}
