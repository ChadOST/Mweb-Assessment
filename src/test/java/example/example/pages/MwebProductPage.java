package example.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The Class represents The Mweb Product Page.
 *
 * @author CWilliams
 */
public class MwebProductPage extends BasePage {

	@FindBy(xpath = "(//h1)[1]")
	private WebElement pageTitle;

	@FindBy(id = "product_accordion")
	private WebElement productAccordion;

	@FindBy(xpath = "//div[@class= 'hidden laptop:grid laptop:grid-cols-3 laptop:gap-4' ]//div[@class = 'flex flex-1 flex-col border border-mwgray-xd mb-8']")
	private WebElement routerOptions;

	@FindBy(xpath = "//meta[@property = 'og:title']")
	private WebElement metaTitle;

	@FindBy(xpath = "//meta[@property = 'og:description']")
	private WebElement metaDescription;

	public MwebProductPage(WebDriver driver) {
		super(driver);
	}

	public boolean validatePageTitle(String packageTitle)
	{
		productAccordion.isDisplayed();
		WebElement pageHeader = driver.findElement(By.xpath("//h1[contains(text(),'"+packageTitle+"')][1]"));
		pageHeader.isDisplayed();
		pageTitle.isDisplayed();
		if(pageTitle.getText().equals(packageTitle))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean validateAvaiableProvider(int expectedNumberofResults) 
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
	public boolean validatePageTitleProperty(String title) 
	{
		if(metaTitle.getAttribute("content").equals(title))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean validatePageDescriptionProperty(String description) 
	{
		if(metaDescription.getAttribute("content").equals(description))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
