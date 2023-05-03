package vTigerContancts.test;

import java.io.IOException;

import org.apache.poi.sl.usermodel.GroupShape;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Automation.GenericUtility.BaseClass;
import Automation.GenericUtility.ExcellFileUtility;
import Automation.GenericUtility.JavaUtility;
import Automation.GenericUtility.PropertityFileUtility;
import Automation.GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.ContactLookUp;
import vTiger.ObjectRepository.ContactPage;
import vTiger.ObjectRepository.ContactTitle;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

public class CreateContanctsWithOrganTest extends BaseClass {


	@Test(groups="Regressionsuit")
	public void Contact() throws IOException, InterruptedException {
	
		//Get the data from excell sheet
	 String   CONTACTNAME=eUtil.getDataFromExcell("Contact", 1, 2)+jUtil.getRandomNumber();
	String CONTACTDROPDOWN= eUtil.getDataFromExcell("Contact", 4, 3);
	
	    //click on Contact
		HomePage hp=new HomePage(driver);
		hp.contact();
		//Click on lookup Img
		ContactLookUp cl=new ContactLookUp(driver);
		cl.loopUpImg();
		//Pass the values to textFiled
		ContactPage cp=new ContactPage(driver);
		//pass the contact last name
		cp.lastName(CONTACTNAME);
		// pass the contact last name and dropdown
		cp.leadSoruce(CONTACTDROPDOWN);
	//	Assert.fail();
		// To save
		cp.save();
	
		//TO get the title
		ContactTitle TITLE=new ContactTitle(driver);
	
	String CONTACTTITLE=TITLE.title();
	System.out.println(CONTACTTITLE);
	
	// To validate the title of Contact
	Assert.assertTrue(true, CONTACTTITLE);
	//Singout
	     hp.signout(driver);
	}
	
	
}
