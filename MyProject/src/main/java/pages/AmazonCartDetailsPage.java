package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonCartDetailsPage {
	@FindBy(xpath="(//div[@data-item-index='1'])[1]//h4//span[@class='a-truncate-cut']")
	private WebElement firstProductName;
	
	@FindBy(xpath="(//span[@class='a-price-whole'])[5]")
	private WebElement firstProductPrice;
	//((//div[@data-item-index='1'])[1]//div[@class='sc-item-price-block']//div/span)[3]"
	
	public  AmazonCartDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	
	}
	
	public String getFirstProductName() {
		
		return firstProductName.getText();
	}

   public String getFirstProductPrice() {
		
		return firstProductPrice.getText();
	}

}
