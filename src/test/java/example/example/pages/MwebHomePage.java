package example.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.internal.thread.ThreadExecutionException;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
/**
 * The Class represents FacebookLoginPage.
 *
 * @author Bharathish
 */
public class MwebHomePage extends BasePage {

	/** The address input field. */
	@FindBy(id = "coverage")
	private WebElement coverageInput;

	/** The check coverage button. */
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
		} catch (Exception e) {
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
			return false;
		}
		return true;
	}

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
	public Boolean clickFirstOpenserveResult() {
		try 
		{
			firstOpenserveResultButton.isDisplayed();
			firstOpenserveResultButton.click();
		} catch (Exception e) 
		{
			return false;
		}
		return true;
	}
}
