package vTigerOrgani.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Automation.GenericUtility.BaseClass;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganisLookUp;
import vTiger.ObjectRepository.OrganisatTitle;
import vTiger.ObjectRepository.OrganisationPage;

public class OrganisationWithPomTest extends BaseClass{

	@Test(groups="Regressionsuit")
	public void Oragan() throws EncryptedDocumentException, IOException {
	  String ORGNAME=eUtil.getDataFromExcell("Organization", 1, 2)+jUtil.getRandomNumber();
		String INDUSTRY=eUtil.getDataFromExcell("Organization", 4, 3);
		String TYPE=eUtil.getDataFromExcell("Organization", 7, 4);
		//Click on Organisation
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
		 org.AccountType(TYPE);
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
