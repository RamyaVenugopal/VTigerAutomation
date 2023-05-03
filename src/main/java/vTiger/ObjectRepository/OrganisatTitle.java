package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisatTitle {

	//Rule1:create a separate class for every WebPage
	//Rule 2:Identify all the Webelement by using annotations 
	
	@FindBy(className ="dvHeaderText")
	private WebElement title;
	
	//Rule 3: create a constructor to initize the variables
	public OrganisatTitle(WebDriver driver) {
	PageFactory.initElements(driver ,this);
	}
	
	//Rule 4: To acess the private methods by using getters
	
	public WebElement getOrganTitle() {
		return title;
	}
	
	public String OrganTitle() {
		return title.getText();
	}
	
}
