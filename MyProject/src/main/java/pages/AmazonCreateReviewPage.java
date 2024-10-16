package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonCreateReviewPage {

	@FindBy(xpath ="//img[@alt='select to rate item four star.']")
	private WebElement rating;
	
	@FindBy(xpath ="//input[@id='scarface-review-title-label']")
	private WebElement addHeadline;
	
	@FindBy(xpath ="//textarea[@id='scarface-review-text-card-title']")
	private WebElement writeReview;
	
	@FindBy(xpath ="//button[text()='Submit']")
	private WebElement submitReview;
	
  public AmazonCreateReviewPage (WebDriver driver) {
	  
	  PageFactory.initElements(driver,this);
   }
  
  public void clickOnRating() {
		rating.click();
	}
  
  public void sendHeadLineReview(String headLine) {
	  addHeadline.sendKeys(headLine);
  }
	
  public void writeReview(String userwriteReview){
	  writeReview.sendKeys(userwriteReview);
  }
  
  public void clickOnSubmitReview() {
	  submitReview.click();
	}

  
}
