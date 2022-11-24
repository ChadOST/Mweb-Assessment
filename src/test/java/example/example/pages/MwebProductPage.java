package example.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The Class represents FacebookLoginPage.
 *
 * @author Bharathish
 */
public class MwebProductPage extends BasePage {

	/** The check coverage button. */
	@FindBy(className = "text-center laptop:text-left mb-1 text-lg laptop:text-2xl font-bold text-mwgray")
	private WebElement pageTitle;

	@FindBy(xpath = "//div[@class= 'hidden laptop:grid laptop:grid-cols-3 laptop:gap-4' ]//div[@class = 'flex flex-1 flex-col border border-mwgray-xd mb-8']")
	private WebElement routerOptions;

	public MwebProductPage(WebDriver driver) {
		super(driver);
	}

	public boolean validateAvaiableProviderNew(int expectedNumberofResults) 
	{
		int xpathCount= driver.findElements(By.xpath("//div[@class= 'hidden laptop:grid laptop:grid-cols-3 laptop:gap-4' ]//div[@class = 'flex flex-1 flex-col border border-mwgray-xd mb-8']")).size();
		if(xpathCount==expectedNumberofResults)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean validateAvaiableProvider(int expectedNumberofResults) {
		int results = 0;
		boolean isAvailable = true;
		WebElement availableProvider = driver.findElement(By.xpath("//div[@class= 'hidden laptop:grid laptop:grid-cols-3 laptop:gap-4' ]//div[@id='"+results+"']"));
		while (isAvailable)
		{
		if(availableProvider.isDisplayed())
		{
			results++;
		}
		else
		{
			isAvailable=false;
		}
	}
		if(results==expectedNumberofResults)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
