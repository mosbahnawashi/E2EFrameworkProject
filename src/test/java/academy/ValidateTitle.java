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

//The first Test will Fail:
public class ValidateTitle extends baseClass {

	public static Logger log = LogManager.getLogger(baseClass.class.getName());

	LandingPageClass landingpage;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigating to Home Page");
	}

	// This Test will Fail:
	@Test
	public void validateAppTitle() throws IOException {

		landingpage = new LandingPageClass(driver);
		System.out.println("The desired test is " + landingpage.getTitle().getText());

		// Compare the text from the browser with actual text value given in the
		// requirements document from the client.
		Assert.assertEquals(landingpage.getTitle().getText(), "FEATURED COURSES1111");
		log.info("Successfully Validating Title Text Message");

		// Use Assert.assertEquals with the name "FEATURED COURSES123" in the next
		// method as an example only to check the screenshot output file name. Check
		// ListenersClass for more info:
		// Assert.assertEquals(landingpage.getTitle().getText(), "FEATURED COURSES123");
		// log.info("Successfully Validating Title Text Message");
	}

	//This test will also fail:
	//To make it pass; try the second Assert line:
	@Test
	public void validateHearder() throws IOException {

		Assert.assertEquals(landingpage.getHeader().getText(), "An Academy to learn Everything about Testing");
		//Try this to make this test pass:
		//Assert.assertEquals(landingpage.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");

		log.info("Successfully Validating Title Text Message");
	}

	@AfterTest
	public void taerDown() {
		driver.close();
		driver = null;
		// extent.flush();
	}

}
