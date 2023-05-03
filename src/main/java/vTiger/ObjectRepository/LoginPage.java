package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//Rule 1: create a separate class for every webpage
	//Rule 2: Identify the elements using annotations
	@FindBy(name="user_name")
	private WebElement Username;
	
	@FindBy(name="user_password")
	private WebElement Password;
	
	@FindBy(id = "submitButton")
	private WebElement submitBtn;
	
	//Rule 3:Create a constructor to initialise these elements
	public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
	}
	
	//Rule 4:Provide getters to access these variables
	public WebElement getUsername() {
		return Username;
	}
	public WebElement getPassword() {
		return Password;
	}
	public WebElement getsubmitBtn() {
		return submitBtn;
	}
	/**
	 * Business logic 
	 * @param username
	 * @param password
	 */
	
	public void loginToApp(String username,String password) {
		Username.sendKeys(username);
		Password.sendKeys(password);
		submitBtn.click();
	}
	
	
}
