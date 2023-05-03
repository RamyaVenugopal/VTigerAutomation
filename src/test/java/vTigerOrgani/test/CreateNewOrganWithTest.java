package vTigerOrgani.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Automation.GenericUtility.BaseClass;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganisLookUp;
import vTiger.ObjectRepository.OrganisatTitle;
import vTiger.ObjectRepository.OrganisationPage;

public class CreateNewOrganWithTest extends BaseClass{
//@Test
	@Test(groups = "Smokesuit")
	public void OrganName() throws EncryptedDocumentException, IOException, InterruptedException {
		String ORGNAME=eUtil.getDataFromExcell("Organization", 1, 2)+jUtil.getRandomNumber();
		String INDUSTRY=eUtil.getDataFromExcell("Organization", 4, 3);
		//Click on Organization
		 HomePage hp=new HomePage(driver);
		 hp.organisation();
		 
		 //Click on the look up image
		 OrganisLookUp IMG=new OrganisLookUp(driver);
		 IMG.LookUpImg();
		 
		 //To Pass the organ name
		 OrganisationPage org=new OrganisationPage(driver);
		 org.OrganNameDetails(ORGNAME);
		 //To pass The industry type
		 org.IndustryType(INDUSTRY);
		
		 // To save
	      org.savebtn();
		 
		
		 OrganisatTitle TITLE=new OrganisatTitle(driver);
		 String ORGNTITLE=TITLE.OrganTitle();
		 
		 //To validate
		 Assert.assertTrue(true, ORGNTITLE);
		
		 //SIGN OUT
		 hp.signout(driver);	
	}
	
}
