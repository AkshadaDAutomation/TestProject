package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {

	@FindBy(xpath="//span[@class='nav-line-2 ']")
	private WebElement accountList;
	
	@FindBy(xpath="//span[text()='Sign in']")
	private WebElement signInButton;
	
	@FindBy(xpath="//span[text()='Sign Out']")
	private WebElement logoutButton;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	private WebElement searchTextBox;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement searchButton;
	
	@FindBy(xpath="(//div[@id ='nav-flyout-searchAjax']//div[@role=\"button\"])[1]")
	private WebElement suggesstionOption;
	
	@FindBy(xpath="//a[@id='nav-orders']")
	private WebElement returnsOrder;
	 
	private Actions action;
	
	public  AmazonHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		action = new Actions(driver);
	}
	
   public void clickOnAccountList() {
    accountList.click();
		
   }
	
   public void clickOnLoginButton() {
	 
		action.moveToElement(accountList).moveToElement(signInButton).click().build().perform();
	}
	
	public void clickOnLogOutButton() {
	
		action.moveToElement(accountList).moveToElement(logoutButton).click().build().perform();
	}
	
	public void enterProductName(String productName) {
		searchTextBox.sendKeys(productName);
		
	}
	public void clickOnSearchButton() {
		searchButton.click();
		
	}
	
	public void clickOnFirstSuggestionOption() {
		suggesstionOption.click();
		
	}
	
	public void clickOnReturnsOrder() {
		returnsOrder.click();
		
	}
	
}
