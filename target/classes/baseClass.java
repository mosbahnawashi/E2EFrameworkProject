package resources;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.google.common.io.Files;

public class baseClass {

	//public static WebDriver driver;
	public WebDriver driver;
	
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		
		//This Java command will get the directory path for our current project to avoid hardcoding the whole path to make it runnable in any machine:
		//System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		//FileInputStream fis = new FileInputStream("C:\\Users\\mosba\\OneDrive\\Desktop\\QA\\eclipse workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		//mvn test -Dbrowser=fireFox
		
		String browserName = System.getProperty("browser");
		//String browserName = prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			// Execute in Chrome Browser Driver			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
			
			
			//Run test cases in headless mode. using the browser binary without invoking the browser:
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless"))
				options.addArguments("headless");
			
			driver = new ChromeDriver(options);
			
		} else if (browserName.equals("fireFox")) {
			// Execute in FireFox Browser Driver
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {
			// Execute in FireFox IE Driver
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}

	public void getScreenshot(String result) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(
				System.getProperty("user.dir") + result
						+ ".png");
		Files.copy(SrcFile, DestFile);

	}

}
