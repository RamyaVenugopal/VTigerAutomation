 package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
//Rule 1:Create a separate class for every webpage
	//Rule 2:Identify the element using annotation
	
	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(name="leadsource")
	private WebElement leadSorucedropdown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement title;
 
	//Rule 3:create a constructor to initilise the element
    public  ContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//Rule 4: Provide getters to access the variables
	
	public WebElement getLastName() {
		return lastname;
	}
	public WebElement getLeadSoruce() {
		return leadSorucedropdown;
	}
	  
	public WebElement getSave() {
		return savebtn;
	}
	public WebElement getTitle() {
		return title;
	}
	/**
	 * 
	 * @param CONTACTNAME 
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 */
	public void lastName(String CONTACTNAME) {
		lastname.sendKeys(CONTACTNAME);
		
	}
	/**
	 * 
	 */
	public void leadSoruce(String CONTACTDROPDOWN) {
		leadSorucedropdown.sendKeys(CONTACTDROPDOWN);
	}
	/**
	 * 
	 */
	public void save() {
		savebtn.click();
	}
	/**
	 * 
	 */
	public void title() {
		title.getText();
	}
}
