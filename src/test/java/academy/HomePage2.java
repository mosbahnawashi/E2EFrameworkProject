package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPageClass;
import pageObjects.LoginPageClass;
import resources.baseClass;

public class HomePage2 extends baseClass {
	
	//public ExtentReports extent;
	
	public static Logger log = LogManager.getLogger(baseClass.class.getName());


	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
	}
	
	@Test(dataProvider = "getData")
	public void validateLoginPage(String username, String Password,String text) throws IOException {
		
		// To access methods in different class:
		// 1. Inheritance by using extends keyword
		// 2. Creating object from the other class and invoke it's methods
		
		driver.get(prop.getProperty("url"));
		log.info("Navigating to Login Page");
		LandingPageClass landingpage = new LandingPageClass(driver);
		landingpage.getLogin().click();

		LoginPageClass loginpage = new LoginPageClass(driver);
		loginpage.getEmail().sendKeys(username);
		loginpage.getPassword().sendKeys(Password);
		//System.out.println(text);
		log.info(text);
		loginpage.clickLogin().click();

	}
	
	@DataProvider
	public Object[][] getData() {
		// Row stands for how many different data types test should run
		// Column stand for how many values per each test
		Object[][] data = new Object[2][3];
		// 0th row
		data[0][0] = "NONrestrictedUser@a.com";
		data[0][1] = "0123456789";
		data[0][2] = "NON Restricted User";
		
		//1st row
		data[1][0] = "RestrictedUser@z.com";
		data[1][1] = "9876543210";
		data[1][2] = "Restricted User";

		return data;
	}
	
	@AfterTest
	public void taerDown()
	{
		driver.close();
		driver = null;
		//extent.flush();
		}
	
}
