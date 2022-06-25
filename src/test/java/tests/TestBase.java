package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
	public static WebDriver driver;
	@BeforeSuite
//here you can choose the browser wither if its chrome or firefox or ie
//notice that the default browser is chrome as you can see "@Optional ("chrome")"
	@Parameters({"browser"})
	public void startDriver(@Optional ("chrome")String browsername)
	{
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"/resources/chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir")+"/resources/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		
		else if(browsername.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir")+"/resources/IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}
//To handel the browser resolution of 1024x768px 
		driver.manage().window().setSize(new Dimension(1024, 768));
//wait 4 seconds before giving me an error 
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
	}
//after suite quit the driver
	@AfterSuite
	public void stopDriver()
	{
		driver.quit();
	}
}
