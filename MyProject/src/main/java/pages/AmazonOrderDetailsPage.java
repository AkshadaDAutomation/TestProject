package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonOrderDetailsPage {

	@FindBy(xpath="//a[@id='Cancel-items_1']")
	private WebElement cancelIteamButton;
	
public  AmazonOrderDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
public void clickOncancelIteamButton() {
		
    	cancelIteamButton.click();
		
}
    
   
    
    
}

