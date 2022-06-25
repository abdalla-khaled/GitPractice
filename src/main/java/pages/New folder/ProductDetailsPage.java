package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@FindBy(xpath = "//span[@class='cat-name']")
	public	WebElement assertsubwomensection;
	
	@FindBy(css = "img[title='Blouse']")
	WebElement selcetBlouse;
	
	@FindBy(xpath = "//span[contains(text(),'Add to cart')]")
	WebElement addtocartbutton;
	
	@FindBy(xpath = "//span[normalize-space()='Proceed to checkout']")
	WebElement Proceedtocheckoutbutton;
	
	
	
	@FindBy(xpath = "//span[@id='our_price_display']")
	public WebElement assertproductpage;
//click on the Blouse ,Blouse is a sub category from the women section
	public void Openproductdetailspage()
	{
		clickButton(selcetBlouse);

	}
//open add to cart pop up to complete the order
	public void OpenAddtocartpopup()
	{
		clickButton(addtocartbutton);
		clickButton(Proceedtocheckoutbutton);
	}
	

}
