package test;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import base.Browser;

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
import java.time.Duration;

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


public class AmazonTestNg2 extends Browser {
	
	WebDriver driver;
	private AmazonHomePage amazonHomePage;
	private AmazonSignInPage amazonSignInPage;
	private AmazonYourOrdersPage amazonYourOrdersPage;
	private AmazonCreateReviewPage amazonCreateReviewPage;
	private ReviewYourPurchesPage reviewYourPurchesPage;
	private AmazonOrderDetailsPage amazonOrderDetailsPage;
	private AmazonCancelOrderConformationPage amazonCancelOrderConformationPage;
	
	
	@Parameters("browser")
	
	@BeforeTest
	void openBrowser(String expectedBrower) {
		
		System.out.println(expectedBrower);
		
//		if (expectedBrower.equals("Chrome"))
//		{
//			driver = new ChromeDriver();
//		}
//		
//		if (expectedBrower.equals("Firefox"))
//		{
//			driver = new FirefoxDriver();
//		}
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
//		
		 driver = launchBrowser(expectedBrower);
		
	}
	  
	
	@BeforeClass
	void initilizePOM() {
		
		
		    amazonHomePage = new AmazonHomePage(driver);
		    amazonSignInPage = new AmazonSignInPage(driver);
		    amazonYourOrdersPage= new AmazonYourOrdersPage(driver);
		    amazonCreateReviewPage = new AmazonCreateReviewPage(driver);
		    reviewYourPurchesPage = new ReviewYourPurchesPage(driver);
		    amazonOrderDetailsPage= new AmazonOrderDetailsPage(driver);
		    amazonCancelOrderConformationPage = new AmazonCancelOrderConformationPage(driver);
		  
	}

	@BeforeMethod
     void logInToAmazon() throws InterruptedException {
		
	   driver.get("http://www.Amazon.in");
	  // amazonHomePage = new AmazonHomePage(driver);
	   Thread.sleep(5000);
	   amazonHomePage.clickOnLoginButton();
	   
	//   amazonSignInPage = new AmazonSignInPage(driver);
	   Thread.sleep(5000);
	   amazonSignInPage.enteremailId("9767376868");
	   amazonSignInPage.clickOnContinue();
	   Thread.sleep(5000);
	   amazonSignInPage.enterPassword("amazon@1000");
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
	
	@Test(enabled = false)
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
	void logoutFromAmazon() {
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
