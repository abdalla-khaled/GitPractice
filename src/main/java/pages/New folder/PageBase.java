package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
	public WebDriver driver;
	//create constructor 
	public PageBase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//create my own function to click on buttons instead of button.click
	protected static void clickButton(WebElement button)
	{
		button.click();
	}
//create my own function to send text instead of using sendkeys 
	protected static void sendtext(WebElement text, String value)
	{
		text.sendKeys(value);
	}
}
