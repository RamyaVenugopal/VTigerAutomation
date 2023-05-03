package Automation.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertityFileUtility {

	public String getDataFromProperty(String key) throws IOException {
		
		//step 1:Load the FileIntoInputStream to make it java readable
		FileInputStream fie=new FileInputStream(ConstantUtility.properityfilepath);
		
		//step 2:create an objet for property
		Properties pobj=new Properties();
		
		//step 3:To load the file
		pobj.load(fie);
		
		// step 4:To get the value from property
	   String value=pobj.getProperty(key);
		return value;	
	}
}
	
	
	

