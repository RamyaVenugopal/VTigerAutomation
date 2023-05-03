package Automation.GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

/**
 * This class contains of all basic configuration annotation
 * @author Ramya Venugopal
 *
 */
public class BaseClass{

	//create object for all utility
		public ExcellFileUtility eUtil=new ExcellFileUtility();
		public JavaUtility jUtil=new JavaUtility();
		public WebDriverUtility wUtil=new WebDriverUtility();
		public PropertityFileUtility pUtil=new PropertityFileUtility();
		
		//public WebDriver driver=new EdgeDriver();
		public WebDriver driver=null;
		public static WebDriver sDriver;
		
		@BeforeSuite(alwaysRun=true)
		public void dsConfig() {
			System.out.println(" --- Database Connection Successful ---");
		}
		//@Parameters("browser")
		//@BeforeClass
		@BeforeClass(groups={"Smokesuit","Regressionsuit"})
		public void browserCon(/*String BROWSER*/) throws IOException {
			String BROWSER = pUtil.getDataFromProperty("browser");
			String URL = pUtil.getDataFromProperty("url");
			
		if(BROWSER.equalsIgnoreCase("Chrome"))
			{
				ChromeOptions opt=new ChromeOptions();
	  			opt.addArguments("--remote-allow-origins=*");
	  			opt.addArguments("--disable-notification");
	  		 driver=new ChromeDriver(opt); // driver is initialised to chrome 
				System.out.println(BROWSER+" --- Browser launch successful ---");
			}
			else if(BROWSER.equalsIgnoreCase("Firefox"))
			{
				driver = new FirefoxDriver();
				System.out.println(BROWSER+" --- Browser launch successful ---");
			}
			else
			{
				System.out.println("invalid browser name in property file");
			}
			sDriver=driver; //take Screenshot
			wUtil.maximize(driver);
			wUtil.waitForPageLoad(driver);
			driver.get(URL);
			
		}
		//@BeforeMethod
		@BeforeMethod(groups={"Smokesuit","Regressionsuit"})
	public void login() throws IOException {
		String	USERNAME=pUtil.getDataFromProperty("username");
		String PASSWORD=pUtil.getDataFromProperty("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println(" --- Login is Successful ---");
	}
	    // @AfterMethod
		@AfterMethod(groups={"Smokesuit","Regressionsuit"})
	public void logout() {
		HomePage hp=new HomePage(driver);
		System.out.println(" --- Logout is Successful ---");
		
	}
		//@AfterClass
		@AfterClass(alwaysRun=true)
		public void close() {
			driver.quit();
			System.out.println(" --- browser closed Successfully ---");
		}
		@AfterSuite
		//@AfterSuite(alwaysRun=true)
		public void asConfig()
		{
			System.out.println(" --- Database closed Successfully ---");
		}
		
}
