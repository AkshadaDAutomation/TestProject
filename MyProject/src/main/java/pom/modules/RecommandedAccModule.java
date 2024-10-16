package pom.modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecommandedAccModule {
	
	@FindBy(xpath="//span[@id='attach-sidesheet-view-cart-button']//input")
	private WebElement cartButton;
	
	public RecommandedAccModule(WebDriver driver)
	{
		
	PageFactory.initElements(driver,this);
	}
	
	public void goToCartPage()
	{
		cartButton.click();
	}

}
