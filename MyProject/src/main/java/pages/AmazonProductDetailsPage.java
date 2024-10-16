package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonProductDetailsPage {

	@FindBy(xpath="//h1[@id='title']/span")
	private WebElement productName;
	
	@FindBy(xpath="(//span[@class='a-price-whole'])[5]")
	private WebElement productPrice;
	
	@FindBy(xpath="(//input[@id=\"add-to-cart-button\"])[2]")
	private WebElement addToCart;
	
	@FindBy(xpath="//span[@id='wishListMainButton']")
	private WebElement addToWishlist;
	
	 
	
	public  AmazonProductDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public String getProductName()
	{
		return productName.getText().trim();
	}
	
	public String getProductPrice()
	{
		return productPrice.getText().trim();
	}
	
	public void clickOnAddToCart() {
		
		addToCart.click();
		
	}
	
	public void clickOnWishList() {
		
		addToWishlist.click();
		
		
		
	}
}
