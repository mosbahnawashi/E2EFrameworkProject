package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPageClass;
import resources.baseClass;

public class ValidateNavigationBar extends baseClass {
	
	//public ExtentReports extent;
	
	public static Logger log = LogManager.getLogger(baseClass.class.getName());


	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigating to Home Page");
	}
	
	@Test
	public void validateNavigationBar() throws IOException {
		

		LandingPageClass landingpage = new LandingPageClass(driver);
		
		Assert.assertTrue(landingpage.getNavigationBar().isDisplayed());
		//Use Assert.assertFalse in the next method as an example only to check the screenshot output file name. Check ListenersClass for more info:
		//Assert.assertFalse(landingpage.getNavigationBar().isDisplayed());
	}
	
	@AfterTest
	public void taerDown()
	{
		driver.close();
		driver = null;
		//extent.flush();
		}
	
}
