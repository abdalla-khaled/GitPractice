package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
//find elements in the login page
	
		@FindBy (id="email_create")
		WebElement emailtextbox;
		
		@FindBy(xpath = "//input[@id='email'][1]")
		WebElement emaillogintextbox;
	

		@FindBy (id="passwd")
		WebElement passwordtextbox;
		
		@FindBy (id="SubmitCreate")
		WebElement createaccountbutton;
		
		@FindBy (id="SubmitLogin")
		WebElement signinbutton;
		
		
	//first setp in the registraion is to write a valid mail
	//	then to click on create account button 
	//	so the registraion page should open to fill the rest of the data 
	public void createnewaccount(String email)
	{
		sendtext(emailtextbox, email);
		clickButton(createaccountbutton);
	}
//to fill the data to do login 
	public void login(String email,String password )
	
	{
		sendtext(emaillogintextbox, email);
		sendtext(passwordtextbox, password);
		clickButton(signinbutton);
	}
}
