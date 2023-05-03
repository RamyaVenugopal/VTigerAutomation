package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	//Rule 1: Create a separate class for every webpage
	//Rule 2:Identify all the Webelement by using annotations 

	@FindBy(name = "accountname")
	private WebElement OrganName;
	
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement IndustryDropdown;
	
	
	@FindBy(xpath = "//select[@name='accounttype']")
	private WebElement accounttype;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	//Rule 3:Create a constructor to initize the variables
	public OrganisationPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
	}
	
	//Rule 4:To  access the private variable by using getters
	public WebElement getOrganName() {
		return OrganName;
	}
	
	public WebElement getIndustryDropdown() {
		return IndustryDropdown;
	}
	public WebElement getAccoutType() {
		return accounttype;
	}
	
	
	public WebElement getSavebtn() {
		return savebtn;
	}
	 
	/**
	 * This method is used to 
	 * @param ORGNAME
	 */
	
	public void OrganNameDetails(String ORGNAME) {
		OrganName.sendKeys(ORGNAME);
	}
	/**
	 * 
	 * @param INDUSTRY
	 */
	public void IndustryType(String INDUSTRY) {
		IndustryDropdown.sendKeys(INDUSTRY);
	}
	/**
	 * 
	 * @param TYPE
	 */
	public void AccountType(String TYPE) {
		accounttype.sendKeys(TYPE);
	}
	
	/**
	 * 
	 */
	public void savebtn() {
		savebtn.click();
	}
}
