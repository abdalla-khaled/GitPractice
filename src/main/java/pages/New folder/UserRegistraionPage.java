package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UserRegistraionPage extends PageBase{

	public UserRegistraionPage(WebDriver driver) {
		super(driver);
		
	
	}
	//find elements in the registration form
	@FindBy (id="uniform-id_gender1")
	WebElement genderRadioButton;
	
	@FindBy (id="customer_firstname")
	WebElement Firetnametextbox;
	
	@FindBy (id="customer_lastname")
	WebElement lastnametextbox;
	
	@FindBy (id="passwd")
	WebElement Passwordtextbox;
	
	@FindBy(id="days")	
	WebElement day;
	Select dayvalue = new Select(day);
	
	@FindBy(id="months")	
	WebElement month;
	Select monthvalue = new Select(month);
	
	@FindBy(id="years")	
	WebElement year;
	Select yearvalue = new Select(year);
	
	@FindBy (id="firstname")
	WebElement addressFiretnametextbox;
	
	@FindBy (id="lastname")
	WebElement addresslastnametextbox;
	
	@FindBy (id="company")
	WebElement addresscompanytextbox;
	

	@FindBy (id="address1")
	WebElement address1textbox;
	
	@FindBy (id="address2")
	WebElement address2textbox;
	
	@FindBy (id="city")
	WebElement citytextbox;
	
	@FindBy(id="id_state")	
	WebElement state;
	Select statevalue = new Select(state);
	
	@FindBy (id="postcode")
	WebElement postcodetextbox;
	
	@FindBy(id="id_country")	
	WebElement country;
	Select countryvalue = new Select(country);
	
	@FindBy (id="other")
	WebElement Additionalinformationtextbox;
	
	@FindBy (id="phone")
	WebElement homephonetextbox;
	
	@FindBy (id="phone_mobile")
	WebElement phonetextbox;
	
	@FindBy (id="submitAccount")
	WebElement registerbutton;
	
	
	
	//create method 
	public void UserRegistraion(String email,String firstname,String lastname,String password,String addressfirstname,
			String addresslastname,String companyname,String firstaddress,String secondaddress,
			String city,String stateselect,String postalcode,String countryselect,String Additionalinformation,
				String homephone,String mobilephone)
	{
		clickButton(genderRadioButton);
		sendtext(Firetnametextbox, firstname);
		sendtext(lastnametextbox, lastname);
		sendtext(Passwordtextbox, password);
//choose the first index from the drop down for birth(days)
		dayvalue.selectByIndex(1);
//choose the forth index from the drop down for birth(months)
		monthvalue.selectByIndex(4);
		yearvalue.selectByIndex(20);
		sendtext(addressFiretnametextbox, addressfirstname);
		sendtext(addresslastnametextbox, addresslastname);
		sendtext(addresscompanytextbox, companyname);
		sendtext(address1textbox, firstaddress);
		sendtext(address2textbox, secondaddress);
		sendtext(citytextbox, city);
		statevalue.selectByVisibleText(stateselect);
		sendtext(postcodetextbox, postalcode);
		countryvalue.selectByVisibleText(countryselect);
		sendtext(Additionalinformationtextbox, Additionalinformation);
		sendtext(homephonetextbox, homephone);
		sendtext(phonetextbox, mobilephone);
		clickButton(registerbutton);
		
		
	}

}
