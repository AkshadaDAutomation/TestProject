package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewYourPurchesPage {
	
	@FindBy(xpath ="//span[@data-hook='ryp-thank-you-title']//span")
	private WebElement actualtext;
	
	public ReviewYourPurchesPage (WebDriver driver) {
		  
		  PageFactory.initElements(driver,this);
	   }
	
	public String getActualText(){
		
	return actualtext.getText().trim();
	
		}
}
