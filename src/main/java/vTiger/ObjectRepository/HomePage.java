package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Automation.GenericUtility.JavaUtility;
import Automation.GenericUtility.WebDriverUtility;

public class HomePage {
	WebDriverUtility wUtil=new WebDriverUtility();
//Rule 1:create a separate class for every webpages
	//Rule 2:Identify the elements using annotation
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement Contact;
	
	@FindBy(linkText="Organizations")
	private WebElement Organisation;
	//Rule 3:create a constructor to initialise these elements
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Rule 4: provide getters to access the variable
	public WebElement getHomePage() {
	  return Contact;
	}
	public WebElement getOrgani() {
		return Organisation;
	}
	/**
	 * Business logic
	 */
	public void contact() {
		Contact.click();
	}
	/**
	 * Business logic
	 */
	public void organisation() {
		Organisation.click();
	}
	public void signout(WebDriver driver) {
		WebElement moveto=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseOverAction(driver, moveto);
		
		//logout
		driver.findElement(By.linkText("Sign Out")).click();
	}
	
	
}
