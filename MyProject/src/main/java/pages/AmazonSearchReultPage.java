package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSearchReultPage {
	
	@FindBy(xpath="//div[@data-cel-widget='search_result_2']//h2/a/span")
	private WebElement titleOfFirtItem;
	
	public AmazonSearchReultPage(WebDriver driver)
	{
		
	PageFactory.initElements(driver,this);
	}
	
	public void clickOnSelectItem()
	{
		titleOfFirtItem.click();
	}

}
