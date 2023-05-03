package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisLookUp {
	//Rule 1:Create a separate class for webElement
	//Rule 2:Identify the element using annonations

	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement Lookupimg;
	
	//Rule 3:Create a constructor to initize the variables
	public  OrganisLookUp(WebDriver driver) {
	PageFactory.initElements(driver,this);
	}
		//Rule 4:using getter to acces the private variables
		
public WebElement getLookupimg() {
	return Lookupimg;
}
	
public void LookUpImg() {
	Lookupimg.click();
	
	
}
	}
	
	

