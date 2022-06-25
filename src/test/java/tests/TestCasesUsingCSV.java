package tests;

import java.io.FileReader;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderHistory;
import pages.OrderPage;
import pages.ProductDetailsPage;
import pages.UserRegistraionPage;

public class TestCasesUsingCSV extends TestBase{
	
//taking objects from the pages 
	
	HomePage HomePageObject;
	UserRegistraionPage UserRegistraionObject;
	CategoryPage CategoryObject;
	LoginPage LoginObject;
	ProductDetailsPage ProductDetailsobject;
	OrderPage Orderobject;
	OrderHistory OrderHistoryObject;
	
	

		
		CSVReader reader ;
//*****************************************************************************************************************************************************************************************
//users can register in our web appication 
//*****************************************************************************************************************************************************************************************	
		@Test(priority=1)

		public void usercanRegister() throws IOException
		{
			//get path of CSV file
			String CSV_file=System.getProperty("user.dir")+"/src/test/java/data/UserData.csv";
			reader= new CSVReader(new FileReader(CSV_file));
			String [] csvCell;
			//while loop will be executed till the last value in CSV file
			while ((csvCell=reader.readNext()) != null)
					{
				String email= csvCell[0];
				String firstname= csvCell[1];
				String lastname= csvCell[2];
				String password= csvCell[3];
				String addressfirstname= csvCell[4];
				String addresslastname= csvCell[5];
				String companyname= csvCell[6];
				String firstaddress= csvCell[7];
				String secondaddress= csvCell[8];
				String city= csvCell[9];
				String stateselect= csvCell[10];
				String postalcode= csvCell[11];
				String countryselect= csvCell[12];
				String Additionalinformation= csvCell[13];
				String homephone= csvCell[14];
				String mobilephone= csvCell[15];
				HomePageObject= new HomePage(driver);
				HomePageObject.OpenRegistraionPage();
				LoginObject =new LoginPage(driver);
				LoginObject.createnewaccount(email);
				UserRegistraionObject= new UserRegistraionPage(driver);
				
				UserRegistraionObject.UserRegistraion(email, firstname, lastname, password, addressfirstname, addresslastname, companyname, firstaddress, secondaddress, city, stateselect, postalcode, countryselect, Additionalinformation, homephone, mobilephone);
				Assert.assertTrue(HomePageObject.LougOutButton.isDisplayed());
			}
		
		
		}
 //*****************************************************************************************************************************************************************************************
//logged in users can logout  
//*****************************************************************************************************************************************************************************************	
		@Test(priority=2)
		public void UserCanLogout()
		
		{
			HomePageObject= new HomePage(driver);
			HomePageObject.Signout();
			Assert.assertTrue(HomePageObject.SigninLink.isDisplayed());
		}
		
 //*****************************************************************************************************************************************************************************************
//user can login using valid data as what is written in the CSV file 
//*****************************************************************************************************************************************************************************************	
		@Test(priority=3)
		public void usercanlogin() throws IOException
		{
			//get path of CSV file
			String CSV_file=System.getProperty("user.dir")+"/src/test/java/data/UserData.csv";
			reader= new CSVReader(new FileReader(CSV_file));
			String [] csvCell;
			//while loop will be executed till the last value in CSV file
			while ((csvCell=reader.readNext()) != null)
					{
				String email= csvCell[0];
				String password= csvCell[3];
				

		HomePageObject= new HomePage(driver);
		HomePageObject.OpenRegistraionPage();
		LoginObject = new LoginPage(driver);
		LoginObject.login(email, password);
		Assert.assertTrue(HomePageObject.LougOutButton.isDisplayed());

		}}
			
 //*****************************************************************************************************************************************************************************************
//users can open sub category to choose or to see products 
 //*****************************************************************************************************************************************************************************************
		
		@Test(priority=4)

		public void usercanchoosefromsubcategory()
		{
			HomePageObject = new HomePage(driver);
			HomePageObject.Opensubcategory();

			CategoryObject = new CategoryPage(driver);
			CategoryObject.openwomensubcategory();
			ProductDetailsobject = new ProductDetailsPage(driver);
			ProductDetailsobject.assertsubwomensection.isDisplayed();

		}
		
//*****************************************************************************************************************************************************************************************
//users can add open product details page to check the product(color/size)
//*****************************************************************************************************************************************************************************************
		
		@Test(priority=5)
		public void usercanopenproductdetailspage()
		{
			ProductDetailsobject = new ProductDetailsPage(driver);
			ProductDetailsobject.Openproductdetailspage();
			Assert.assertTrue(ProductDetailsobject.assertproductpage.isDisplayed());
		}
 //*****************************************************************************************************************************************************************************************
//users can add products to the cart
//*****************************************************************************************************************************************************************************************
		
		@Test(priority=6)

		public void usercanbuyAproduct()
		{
			ProductDetailsobject = new ProductDetailsPage(driver);
			ProductDetailsobject.OpenAddtocartpopup();
		
			//Assert.assertTrue(ProductDetailsobject.assertproductpage.getText().contains("Your shopping cart contains: 1 Product"));
		}

//*****************************************************************************************************************************************************************************************
//users can complete their orders 
//*****************************************************************************************************************************************************************************************
		@Test(priority=7)
		public void usercancompletetheorder()
		{
			Orderobject = new OrderPage(driver);
			Orderobject.checkoutprocedure();
			Assert.assertTrue(Orderobject.assertcompletedorder.isDisplayed());
		}
		
		
 //*****************************************************************************************************************************************************************************************
//Open order history page to make sure of the order is completed 
//*****************************************************************************************************************************************************************************************
	   @Test(priority=8)
		public void UsercCanOpenOrderHistoryPage()
		{
			Orderobject = new OrderPage(driver);
			Orderobject.OpenOrderHistoryPage();
			OrderHistoryObject = new OrderHistory(driver);
			Assert.assertTrue(OrderHistoryObject.AssertMassageForPlacedorders.isDisplayed());
			HomePageObject.Signout();
			Assert.assertTrue(HomePageObject.SigninLink.isDisplayed());
			
		}

}
