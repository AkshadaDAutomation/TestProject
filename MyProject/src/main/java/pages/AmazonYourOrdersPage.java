package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonYourOrdersPage {
	
   @FindBy(xpath="//a[@id='Write-a-product-review_2']")
   private WebElement writeProductReview;
   
   @FindBy(xpath="//a[@id='a-autoid-3-announce']")
   private WebElement viewOrEditOrder;
	

   @FindBy(xpath="//span[@id='a-autoid-1-announce']")
   private WebElement orderPlacedInDropDown;
   

   @FindBy(xpath="//a[@id='time-filter_2']")
   private WebElement selectYearOrderPlaceIn;
   
   public AmazonYourOrdersPage(WebDriver driver) {
	   PageFactory.initElements(driver,this);
	   
   }
   
   public void clickOnWriteProductReview() {
	   writeProductReview.click();
	   
   }
   
   public void clickOnviewOrEditOrder() {
	   viewOrEditOrder.click();
	   
   }

}
