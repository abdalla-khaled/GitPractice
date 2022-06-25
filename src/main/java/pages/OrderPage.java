package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends PageBase{

	public OrderPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//Finding Elements in the order page
	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedtocheckoutbutton;
	
	@FindBy(xpath = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
	WebElement addressproceedtocheckoutbutton;
	
	@FindBy(id="cgv")
	WebElement Termsofserviceradiobutton;
	
	@FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
	WebElement shippingproceedtocheckoutbutton;
	
	@FindBy(xpath = "//a[@title='Pay by bank wire']")
	WebElement paybankbutton;
	
	@FindBy(xpath = "//span[normalize-space()='I confirm my order']")
	WebElement confirmorderbutton;
	
	@FindBy(xpath = "//a[normalize-space()='Back to orders']")
	public WebElement assertcompletedorder;
	
	@FindBy(xpath = "//a[normalize-space()='Back to orders']")
	public WebElement BackToOrderHistoryButton;
	
// To follow check out procedure 
	public void checkoutprocedure()
	{
		clickButton(proceedtocheckoutbutton);
		clickButton(addressproceedtocheckoutbutton);
		clickButton(Termsofserviceradiobutton);
		clickButton(shippingproceedtocheckoutbutton);
		clickButton(paybankbutton);
		clickButton(confirmorderbutton);
		
	}
// To Open the order history page
	public void OpenOrderHistoryPage()
	{
		clickButton(BackToOrderHistoryButton);
	}
}
