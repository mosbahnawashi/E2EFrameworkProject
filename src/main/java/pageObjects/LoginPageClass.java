package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageClass {

	public WebDriver driver;
	private By email = By.id("user_email");
	private By password = By.xpath("//*[@id=\"user_password\"]");
	private By loginButton = By.xpath("//*[@id=\"new_user\"]/div[4]/input");

	public LoginPageClass(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmail() 
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement clickLogin()
	{
		return driver.findElement(loginButton);
	}
	
	
}
