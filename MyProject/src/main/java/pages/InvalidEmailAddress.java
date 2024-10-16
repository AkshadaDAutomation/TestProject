package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvalidEmailAddress {
	@FindBy(xpath="(//div[@data-testid='undefined']//div)[3]")
	private WebElement actualResult;
	
	public InvalidEmailAddress(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void compareResult() {
	String expectedResult ="Please enter a valid mobile number or email address.";
	
	String actualText = actualResult.getText();
	
	if (expectedResult.equals(actualText)) 
	{
		System.out.println("Test case pass");
	}
	else
	{
		System.out.println("Test case fail");
	}
	
	}
}
