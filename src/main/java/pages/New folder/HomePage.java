package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
//find elements in the Home Page

//sign in button in the header of the home
	@FindBy (linkText="Sign in")
	public WebElement SigninLink;

//women is a category 
	@FindBy (linkText="Women")
	WebElement womenLink;
	
	
//sign out button in the header of the home
	@FindBy (linkText = "Sign out")
	public WebElement LougOutButton;
	
	

//create method to click on the sign in button/link
	public void OpenRegistraionPage()
	{
		clickButton(SigninLink);
	
	}
//open the Women Category
	public void Opensubcategory()
	{
	clickButton(womenLink);
	
	
	/*    Actions action= new Actions(driver);
		action.moveToElement(womenLink).click().perform();
		clickButton(BlousesLink);*/
		
	}
//create method to click on the sign out button/link so the logged in user can log out
		public void Signout()
		{
			clickButton(LougOutButton);
		
		}
	

		

	
}
