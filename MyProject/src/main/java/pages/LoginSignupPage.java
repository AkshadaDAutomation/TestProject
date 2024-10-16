package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSignupPage {
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@id='pass']")
	private WebElement password;
	
	@FindBy(xpath="//button[text()='Log in']") 
	private WebElement loginButton;
	
	public LoginSignupPage(WebDriver driver)
	{
		PageFactory.initElements (driver, this);
	}
	
	public void login() {
		userName.sendKeys("akshada@gamil.com");
		password.sendKeys("12344");
		loginButton.click();
	}
	

}
