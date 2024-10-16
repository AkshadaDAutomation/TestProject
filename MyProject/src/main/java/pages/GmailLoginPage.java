package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailLoginPage {

	@FindBy(xpath = "//input[@type='email']")
	private WebElement email;
	
	@FindBy(xpath = "//span[text()='Next']")
	private WebElement next;
	
	@FindBy(xpath = "//input[@name='Passwd']")
	private WebElement pass;
	
	@FindBy(xpath = "//span[text()='Next']")
	private WebElement next1;
	
	public GmailLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
public void emailSend() 
{
	email.sendKeys("testingscript11@gmail.com");
}
public void clickNext() 
{
	next.click();
}
public void passSend() 
{
	pass.sendKeys("Testing@111");
}
public void clickNext1() 
{
	next.click();
}

	
	
	
	
   // String e ="https://mail.google.com/mail/u/0/#inbox";
    
}
