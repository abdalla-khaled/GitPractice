package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistory extends PageBase{

	public OrderHistory(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//find elements in order history page 
	//this element as assertion for Placed orders
	@FindBy(xpath = "//p[@class='info-title']")
	public	WebElement AssertMassageForPlacedorders;

}
