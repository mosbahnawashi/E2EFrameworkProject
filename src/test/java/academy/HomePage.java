package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPageClass;
import pageObjects.LoginPageClass;
import resources.baseClass;

public class HomePage extends baseClass {
	
	//public ExtentReports extent;
	
	public static Logger log = LogManager.getLogger(baseClass.class.getName());


	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
	}
	
	@Test
	public void validateHomePage() throws IOException {
		

		// To access methods in different class:
		// 1. Inheritance by using extends keyword
		// 2. Creating object from the other class and invoke it's methods
		
		driver.get(prop.getProperty("url"));
		log.info("Navigating to Home Page");
		LandingPageClass landingpage = new LandingPageClass(driver);
		landingpage.getLogin().click();

		LoginPageClass loginpage = new LoginPageClass(driver);
		loginpage.getEmail().sendKeys("fakeemail@yahoo.com");
		loginpage.getPassword().sendKeys("987fdsfsdrfgbfdbfdbf#$%%");
		loginpage.clickLogin().click();

	}
	
	
	
	  @AfterTest
	  public void taerDown()
	  {
		  driver.close();
		  driver = null;
		  //extent.flush();
		  }
}
