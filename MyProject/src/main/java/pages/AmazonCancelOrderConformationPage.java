package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonCancelOrderConformationPage {

	@FindBy(xpath = "//select[@name='cancel.reason']")
	private WebElement cancelReasonDropDown ;
	@FindBy(xpath = "//input[@name='cq.submit']")
	private WebElement cancelorderRequest ;
	
	
public  AmazonCancelOrderConformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
public void clickOncancelReasonDropDown() {
		
	
	Select select = new Select(cancelReasonDropDown);
	select.selectByVisibleText("Order Created by Mistake");
		
}

public void clickOncancelorderRequest() {
	
	cancelorderRequest.click();
		
}
    
}
