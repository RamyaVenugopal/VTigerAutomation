package vTigerContancts.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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

public class CreateContactTest extends BaseClass {
@Test(groups="Smokesuit")
		
		public void Contact() throws EncryptedDocumentException, IOException {
			
			
	
	String   CONTACTNAME=eUtil.getDataFromExcell("Contact", 1, 2)+jUtil.getRandomNumber();
		 //Click on contacts
			HomePage hp=new HomePage(driver);
			hp.contact();
		//Click on Lookup img
			ContactLookUp cl=new ContactLookUp(driver);
			cl.loopUpImg();
			
			ContactPage cp=new ContactPage(driver);
		cp.lastName(CONTACTNAME);
			cp.save();
			
			//To Validate
			ContactTitle Title=new ContactTitle(driver);
			String CONTTITLE=Title.title();
			Assert.assertTrue(true);
		
			//singout
		     hp.signout(driver);
	}
		
		
	}
	
	


