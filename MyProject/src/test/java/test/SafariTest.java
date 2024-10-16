package test;

	import org.testng.annotations.AfterClass;
	import org.testng.annotations.Test;
	import org.testng.annotations.BeforeClass;
	import org.testng.AssertJUnit;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.Test;
	import org.testng.annotations.BeforeClass;
	import org.testng.AssertJUnit;
	import org.testng.annotations.Test;
	import org.testng.annotations.BeforeClass;
	import org.testng.AssertJUnit;
	import org.testng.annotations.Test;
	import org.testng.annotations.BeforeClass;
	import org.testng.AssertJUnit;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;

	import pages.AddtoWishListPage;
	import pages.AmazonCancelOrderConformationPage;
	import pages.AmazonCartDetailsPage;
	import pages.AmazonCreateReviewPage;
	import pages.AmazonHomePage;
	import pages.AmazonOrderDetailsPage;
	import pages.AmazonProductDetailsPage;
	import pages.AmazonSearchReultPage;
	import pages.AmazonSignInPage;
	import pages.AmazonYourOrdersPage;
	import pages.ReviewYourPurchesPage;
	import pom.modules.RcommandedWishListModule;
	import pom.modules.RecommandedAccModule;
import utlis.Utility;


	public class SafariTest {
		
		WebDriver driver;
		private AmazonHomePage amazonHomePage;
		private AmazonSignInPage amazonSignInPage;
		private AmazonYourOrdersPage amazonYourOrdersPage;
		private AmazonCreateReviewPage amazonCreateReviewPage;
		private ReviewYourPurchesPage reviewYourPurchesPage;
		private AmazonOrderDetailsPage amazonOrderDetailsPage;
		private AmazonCancelOrderConformationPage amazonCancelOrderConformationPage;
		
		
	
		
		@BeforeClass
		void initilizePOM() {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
			    amazonHomePage = new AmazonHomePage(driver);
			    amazonSignInPage = new AmazonSignInPage(driver);
			    amazonYourOrdersPage= new AmazonYourOrdersPage(driver);
			    amazonCreateReviewPage = new AmazonCreateReviewPage(driver);
			    reviewYourPurchesPage = new ReviewYourPurchesPage(driver);
			    amazonOrderDetailsPage= new AmazonOrderDetailsPage(driver);
			    amazonCancelOrderConformationPage = new AmazonCancelOrderConformationPage(driver);
			  
		}

		@BeforeMethod
	     void logInToAmazon() throws InterruptedException, EncryptedDocumentException, IOException {
			
		   driver.get("http://www.Amazon.in");
		  // amazonHomePage = new AmazonHomePage(driver);
		   Thread.sleep(5000);
		   amazonHomePage.clickOnLoginButton();
		   
		//   amazonSignInPage = new AmazonSignInPage(driver);
		   Thread.sleep(5000);
		   amazonSignInPage.enteremailId(Utility.getDataFromExcelSheet("sheet1",1,0));
		   amazonSignInPage.clickOnContinue();
		   Thread.sleep(5000);
		   amazonSignInPage.enterPassword(Utility.getDataFromExcelSheet("sheet1",1,1));
		   amazonSignInPage.clickOnSignIn();
		   
		}
		
		@Test()
		void verifyLoginFun() {
		String expectedUrl = "https://www.amazon.in/?ref_=nav_signin"	;
		String actualUrl = driver.getCurrentUrl().trim();
		
		AssertJUnit.assertEquals(actualUrl, expectedUrl);
		
		}
		
		@Test(enabled = false)
		void verifySubmitReview() {
		
			//amazonHomePage = new AmazonHomePage(driver);
			amazonHomePage.clickOnReturnsOrder();
			
		//	amazonYourOrdersPage = new AmazonYourOrdersPage(driver);
			amazonYourOrdersPage.clickOnWriteProductReview();
			
		//	amazonCreateReviewPage= new AmazonCreateReviewPage(driver);
			amazonCreateReviewPage.clickOnRating();
			amazonCreateReviewPage.sendHeadLineReview("VeryGood");
			amazonCreateReviewPage.writeReview("very happy with product");
			amazonCreateReviewPage.clickOnSubmitReview();
			
			String expectedTextOfReview ="Review submitted - Thank you!";
			
		//	reviewYourPurchesPage= new ReviewYourPurchesPage(driver);
			String actaulTextOfReview = reviewYourPurchesPage.getActualText();
			 
			AssertJUnit.assertEquals(actaulTextOfReview, expectedTextOfReview);
			
			}
		
		@Test()
		void verifyCancelOrder() {
			
		//	amazonHomePage = new AmazonHomePage(driver);
			amazonHomePage.clickOnReturnsOrder();
			

		//	amazonYourOrdersPage = new AmazonYourOrdersPage(driver);
			amazonYourOrdersPage.clickOnviewOrEditOrder();
			
		//	amazonOrderDetailsPage = new AmazonOrderDetailsPage(driver);
			amazonOrderDetailsPage.clickOncancelIteamButton();
			
		//	amazonCancelOrderConformationPage = new AmazonCancelOrderConformationPage(driver);
			amazonCancelOrderConformationPage.clickOncancelReasonDropDown();
			amazonCancelOrderConformationPage.clickOncancelorderRequest();
			
			String expectedUrl ="https://www.amazon.in/gp/css/order/edit.html/ref=ppx_od_dt_b_ci_s00?ie=UTF8&orderID=408-8582265-6028335&useCase=cancel";
			String actualUrl = driver.getCurrentUrl();
			
		   Assert.assertNotEquals(actualUrl, expectedUrl);
			
		}
		
		@AfterMethod
		void logoutFromAmazon() throws InterruptedException {
			Thread.sleep(5000);			
			amazonHomePage.clickOnLogOutButton();;
			}
		
		@AfterClass
		void removePOM() {
			amazonHomePage = null;
		    amazonSignInPage = null;
		    amazonYourOrdersPage= null;
		    amazonCreateReviewPage = null;
		    reviewYourPurchesPage = null;
		    amazonOrderDetailsPage= null;
		    amazonCancelOrderConformationPage = null;
		    System.gc();
		}
		
		@AfterTest
		void closeBrowser() {
			driver.quit();
		}
		

	}



