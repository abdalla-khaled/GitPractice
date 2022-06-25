package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends PageBase{

	public CategoryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
//find elements in the Category page 
	
// Tops is a section in the women Category
	@FindBy (linkText="Tops")
	WebElement TopsLink;
//Blouses is  sub section in the women Category
	@FindBy (linkText="Blouses")
	WebElement BlousesLink;
	
//TO open "Blouses" sub category in women category 
	public void openwomensubcategory()
	{
	clickButton(TopsLink);
	clickButton(BlousesLink);
	}

}
