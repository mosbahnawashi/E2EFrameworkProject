package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPageClass {

	public WebDriver driver;
	//By loginLink = By.cssSelector("a[href*='sign_in']");
	private By loginLink = By.xpath("//*[@id=\"homepage\"]/header/div[1]/div/nav/ul/li[4]/a/span");
	
	private By title = By.xpath("//*[@id=\"content\"]/div/div/h2");
	
	private By navigationBar = By.xpath("//div[@class='navbar navbar-default navbar-static-top']//div[@class='container']");
	
	private By header = By.cssSelector("div[class*='video-banner'] h3");

	public LandingPageClass(WebDriver driver) 
	{
		this.driver = driver;
	}

	public WebElement getLogin() 
	{
		return driver.findElement(loginLink);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(navigationBar);
	}
	
	public WebElement getHeader()
	{
		return driver.findElement(header);
	}


}
