package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import base.Browser;

import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.AddtoWishListPage;
import pages.AmazonCartDetailsPage;
import pages.AmazonHomePage;
import pages.AmazonProductDetailsPage;
import pages.AmazonSearchReultPage;
import pages.AmazonSignInPage;
import pom.modules.RcommandedWishListModule;
import pom.modules.RecommandedAccModule;


public class AmazonTestNg extends Browser{

	private WebDriver driver;
	private AmazonHomePage amazonHomePage;
	private AmazonSignInPage amazonSignInPage;
	private AmazonSearchReultPage amazonSearchReultPage;
	private AmazonProductDetailsPage amazonProductDetailsPage;
	private RecommandedAccModule recommandedAccModule;
	private AmazonCartDetailsPage amazonCartDetailsPage;
	private RcommandedWishListModule rcommandedWishListModule;
	private AddtoWishListPage addtoWishListPage;
	private ArrayList<String> addres;
	
	
	@Parameters("browser")
	
	@BeforeTest
	void openBrowser(String expectedBrower) {
		
		System.out.println(expectedBrower);
//		
//		if (expectedBrower.equals("Chrome"))
//		{
//			driver = new ChromeDriver();
//		}
		
//		if (expectedBrower.equals("Firefox"))
//		{
//			driver = new FirefoxDriver();
//		}
//		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));
//		
		driver = launchBrowser(expectedBrower);
	}
	  
	
	
	@BeforeClass
	void intilasePOM() {
	   
	   amazonHomePage = new AmazonHomePage(driver);
	   amazonSignInPage = new AmazonSignInPage(driver);
	   amazonSearchReultPage= new AmazonSearchReultPage(driver);
	   amazonProductDetailsPage = new AmazonProductDetailsPage(driver);
	   recommandedAccModule = new RecommandedAccModule(driver);
	   amazonCartDetailsPage= new AmazonCartDetailsPage(driver);
	   rcommandedWishListModule = new RcommandedWishListModule(driver);
	   addtoWishListPage = new AddtoWishListPage(driver);
	  
	}
	
	@BeforeMethod
	void logInToAmazon(){
	driver.get("http://www.Amazon.in");
	
//  amazonHomePage = new AmazonHomePage(driver);
    amazonHomePage.clickOnLoginButton();
	
//	amazonSignInPage = new AmazonSignInPage(driver);
    amazonSignInPage.enteremailId("shyam253@gmail.com");
    amazonSignInPage.clickOnContinue();
    amazonSignInPage.enterPassword("mechanical@1000");
    amazonSignInPage.clickOnSignIn();
	}
	
	@Test
	 void verifyAddToCart() throws InterruptedException{
		
	//	amazonHomePage = new AmazonHomePage(driver);
	    amazonHomePage.enterProductName("iphone  mobile");
	    Thread.sleep(3000);
	    amazonHomePage.clickOnFirstSuggestionOption();
	    amazonHomePage.clickOnSearchButton();
	    
    //  amazonSearchReultPage= new AmazonSearchReultPage(driver);
	    amazonSearchReultPage.clickOnSelectItem();
	    
	    addres = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addres.get(1));
	
	   // amazonProductDetailsPage = new AmazonProductDetailsPage(driver);
		String expectedProductName = amazonProductDetailsPage.getProductName();
		String expectedProductPrice = amazonProductDetailsPage.getProductPrice();
		amazonProductDetailsPage.clickOnAddToCart();
		
		Thread.sleep(5000);
	   // recommandedAccModule = new RecommandedAccModule(driver);
		recommandedAccModule.goToCartPage();
		
	   // amazonCartDetailsPage= new AmazonCartDetailsPage(driver);
	    Thread.sleep(3000);
		String actualProductName = amazonCartDetailsPage.getFirstProductName();
		String actualProductPrice = amazonCartDetailsPage.getFirstProductPrice();
		
		AssertJUnit.assertEquals(actualProductName, expectedProductName);
		AssertJUnit.assertEquals(actualProductPrice, expectedProductPrice);
		Thread.sleep(3000);
	}
	
	@Test
	void verifyAddToWishlist() throws InterruptedException{
		
		//String testId = "11" ;
		//amazonHomePage = new AmazonHomePage(driver);
	    amazonHomePage.enterProductName("iphone  mobile");
	    Thread.sleep(3000);
	    amazonHomePage.clickOnFirstSuggestionOption();
	    amazonHomePage.clickOnSearchButton();
	    
	    //amazonSearchReultPage= new AmazonSearchReultPage(driver);
	    amazonSearchReultPage.clickOnSelectItem();
	    
	    addres = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addres.get(1));
	
	   // amazonProductDetailsPage = new AmazonProductDetailsPage(driver);
		String expectedWishListProductName = amazonProductDetailsPage.getProductName();
		String expectedWishListProductPrice = amazonProductDetailsPage.getProductPrice();
		amazonProductDetailsPage.clickOnWishList();
		
	//	rcommandedWishListModule = new RcommandedWishListModule(driver);
		rcommandedWishListModule.goToWishListPage();
		
		//addtoWishListPage = new AddtoWishListPage(driver);
		
		String actualWishLishProductName= addtoWishListPage.getFirstProductName();
		String actualWishLishProductPrice= addtoWishListPage.getFirstProductPrice();
		
		AssertJUnit.assertEquals(actualWishLishProductName, expectedWishListProductName);
		AssertJUnit.assertEquals(actualWishLishProductPrice, expectedWishListProductPrice);
		
	}
	
	
	
	@AfterMethod 
	void logoutFromAmazon() throws InterruptedException {
		
	
		driver.close();
		driver.switchTo().window(addres.get(0));
	amazonHomePage.clickOnLogOutButton();
	}
	
	@AfterClass
	void closeBrower() {
		driver.quit();
	}
}
