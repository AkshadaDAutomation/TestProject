package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OpenStarrMailPage {
	
	@FindBy(xpath="//a[text()='Starred']")
	private WebElement starred;
	@FindBy(xpath = "//table[@role='grid'])[2]//tr[1]")
	private WebElement firstMail;
	@FindBy(xpath = "")
	private WebElement click;
	
	  public void OpenStarrMailPage( WebDriver driver ) 
	{
		PageFactory.initElements(driver,this);
	}
	
	  public void openFirstStarMail()
	{
		starred.click();
		firstMail.click();
		
	}
	
	  public void checkResult()
	{
		String actualMailText = firstMail.getText();
		String expectedText ="";
		if (actualMailText.equals(expectedText))
			
		{
			System.out.println("pass");
		}
		
		else
		{
			System.out.println("Fail");
		}
		
	}
	
    //WebElement starred = driver.findElement(By.xpath("//a[text()='Starred']"));
	//starred.click();

	//Thread.sleep(2000);
	//WebElement firstMail = driver.findElement(By.xpath("(//table[@role='grid'])[2]//tr[1]"));
	//String text = firstMail.getText();
	//System.out.println(text);
	//firstMail.click();
	 
	
}
