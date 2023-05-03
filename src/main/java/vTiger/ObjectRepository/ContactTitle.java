package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactTitle {

	 //Rule 1:Create a separate class for every webpage
	//Rule 2:Identify the element using annotation
	
	@FindBy(className = "dvHeaderText")
	private WebElement title;
	
	//Rule 3:Create a class to initize the element
	public ContactTitle(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Rule 4:Assces the private variable by creating getters
	
	public WebElement getContactTitle() {
		return title;
	}
	/**
	 * This method is used to fetch the title of contact
	 */
	public String title() {
	return title.getText();
		
		
	}
	
}
