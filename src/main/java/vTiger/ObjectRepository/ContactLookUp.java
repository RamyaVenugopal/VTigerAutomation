package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactLookUp {
	//Rule 1:Create a separate class for every webpage
		//Rule 2:Identify the element using annotation
		
		@FindBy(xpath = "//img[@alt='Create Contact...']")
		private WebElement contactlookupimg;
		
		

		//Rule 3:create a constructor to initilise the element
	    public ContactLookUp(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		
		//Rule 4: Provide getters to access the variables
		
		public WebElement getContactLookupimg() {
			return contactlookupimg;
		}
		
		/**
		 * Business logic for Contact Lookup img
		 */
		
		public void loopUpImg() {
			contactlookupimg.click();
		}

}
