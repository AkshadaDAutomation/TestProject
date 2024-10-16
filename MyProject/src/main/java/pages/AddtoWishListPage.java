package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoWishListPage {
	
//	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
//	private WebElement searchBox1;
//	
//	@FindBy(xpath="//input[@type='submit']")
//	private WebElement click1;
//	
//	@FindBy(xpath="//div[contains(@cel_widget_id,'MAIN-SEARCH_RESULTS-3')]")
//	private WebElement searchResult;
//	
//	@FindBy(xpath="//span[@id='wishListMainButton']")
//	private WebElement addToWishlist;
//	
//	@FindBy(xpath="//a[text()='View Your List']")
//	private WebElement viewWishlist;
	
	@FindBy(xpath="//ul[@id='g-items']//li[2]")
	private WebElement firstProduct;
	 
	
	@FindBy(xpath="//ul[@id='g-items']//li[2]//h2//a")
	private WebElement firstProductWishListName;
	
	@FindBy(xpath="(//span[@class=\"a-price-whole\"])[1]")
	private WebElement firstProductWishListPrice;
	
	
	public  AddtoWishListPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	
	}
	
	public String getFirstProductName() {
		
		return firstProductWishListName.getText();
	}

   public String getFirstProductPrice() {
		
		return firstProductWishListPrice.getText();
	}
	
//	public  AddtoWishListPage(WebDriver driver)
//	{
//		PageFactory.initElements(driver,this);
//	}
//	
//	public void AddToWishlist() 
//	{
//		 searchBox1.sendKeys("iPhone 13");
//		 click1.click();
//		 searchResult.click();
//	}
//		 
//  public void VerifyAddToWishlist() 	 
//  {
//	  addToWishlist.click();
//		 viewWishlist.click();
//		 String actualText =firstProduct.getTagName() ;
//		 System.out.println(actualText);
//		   String expextedText= "Apple iPhone 13 (128GB) - Midnight\n"
//		   		+ "by Apple (Electronics)\n"
//		   		+ "29,578\n"
//		   		+ "28% off Great Indian Festival\n"
//		   		+ "₹42,999.00 Fulfilled FREE Delivery. Details\n"
//		   		+ "M.R.P.:\n"
//		   		+ "Rs.59,600.00\n"
//		   		+ "Size : 128 GB Colour : Midnight\n"
//		   		+ "Item added 4 October 2024\n"
//		   		+ "Add to Cart\n"
//		   		+ "Move\n"
//		   		+ "Add comment, quantity & priority";
//		   
//		   if (actualText.equals(expextedText))
//		   {
//			   System.out.println("Test case Pass");
//		   }
		   
//		   else
//		   {
//			   System.out.println("Test case fail");
//		   }
//		   
//	}
//	
//  
  
     // In test class add code for child browser switch
     //addtoWishListPage.AddToWishlist();
    //ArrayList<String> addres = new ArrayList<String>(driver.getWindowHandles());
    //driver.switchTo().window(addres.get(1));
   // addtoWishListPage.VerifyAddToWishlist();
	
	
	
	
}