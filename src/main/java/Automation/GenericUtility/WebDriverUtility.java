package Automation.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
/**
 * This method is used to maximize the window
 * @param driver
 */
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
}
	/**
	 * This method is used to minimize the window
	 * @param driver
	 */
	public void minimize(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * This method is used to wait to page get load
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * 
	 * this method will wait for the given seconds to page get loaded
	 * @param driver
	 * @param element
	 * @param range
	 */
	public void getvislibleTextWeb(WebDriver driver,WebElement element,int range) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(range));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait for the given seconds for an element to become clickable
	 * @param driver
	 * @param element
	 * @param range
	 */
	public void getElementTobeClickable(WebDriver driver,WebElement element,int range) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(range));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * 
	 * This method will handle the dropdowm with the help of index
	 * @param element
	 * @param index
	 */
	public void hadleDropDowm(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method will handle the dropdowm with the help of value
	 * @param element
	 * @param value
	 */
	public void hadleDropDowm(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method will handle the dropdowm with the help of visble text
	 * @param element
	 * @param value
	 */
	public void hadleDropDowm(String text,WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * This method will perform right click action anywhere on the webpage
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver) {
		Actions act=new Actions(driver);
		act.contextClick().perform();	
	}
	/**
	 * This method will perform right click action on the particular webelement on the webpage
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This method will perform double click action anywhere on the webpage
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver) {
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * This method will perform double click action on the particular webElement on the webpage
	 * @param driver
	 * @param element
	 */
	 public void doubleClickAction(WebDriver driver,WebElement element) {
		 Actions act=new Actions(driver);
		 act.doubleClick(element).perform();
	 }
	/**
	 * This method will perform drag and drop operation 
	 * @param driver
	 * @param src
	 * @param trg
	 */
	 public void dragAndDropAction(WebDriver driver,WebElement src,WebElement trg) {
		 Actions act=new Actions(driver);
		 act.dragAndDrop(src, trg).perform(); 
	 }
	 /**
	  * This method will perform drag and drop opertion 
	  * @param driver
	  * @param src
	  * @param x
	  * @param y
	  */
	 public void dragAndDropAction(WebDriver driver,WebElement src,int x,int y) {
		 Actions act=new Actions(driver);
		 act.dragAndDropBy(src, x, y).perform();
		 
	 }
	 /**
	  * This method is used to press entre using robot class
	  * @throws AWTException
	  */
	 
	public void pressEnter() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseOverAction(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
/**
 * 
 * @param driver
 * @param trg
 * @param x
 * @param y
 */
	public void mouseOverAction(WebDriver driver,WebElement trg,int x,int y) {
		Actions act=new Actions(driver);
		act.moveToElement(trg, x, y).perform();	
	}
	/**
	 * This method is used to switch into frame by using index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch into frame by using name or id value
	 * @param driver
	 * @param nameorid
	 */
	public void switchToFrame(WebDriver driver,String nameorid) {
		driver.switchTo().frame(nameorid);
	}
	/**
	 * This method is used to switch into frame by using frame element
	 * @param driver
	 * @param frameelement
	 */
	public void switchToFrame(WebDriver driver,WebElement frameelement) {
		driver.switchTo().frame(frameelement);
	}
	/**
	 * This method is used to change the driver to parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	/**
	 * This method is used to change the driver to that mainpage
	 * @param driver
	 */
	public void switchToDefalutcontent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used to accept the alert popup
	 * @param driver
	 */
	public void acceptAlertPopup(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * This method is used to dismiss the alert popup
	 * @param driver
	 */
	public void dismissAlertPopup(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method is used to fetch the msg from alert popup
	 * @param driver
	 * @return
	 */
	public String getTextFromAlertPopup(WebDriver driver) {
		String value=driver.switchTo().alert().getText();
		return value;
	}
	/**
	 * This method is used to pass the msg to alert popup
	 * @param driver
	 * @param text
	 */
	public void sendMsgToAlertPopup(WebDriver driver,String text) {
		driver.switchTo().alert().sendKeys(text);
	}
	/**
	 * This method is used to take the screenshot
	 * @param driver
	 * @param foldername
	 * @return 
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver,String foldername) throws IOException {
		TakesScreenshot take=(TakesScreenshot) driver;
		File scr=take.getScreenshotAs(OutputType.FILE);
		File trg=new File(".\\Screenshot\\"+ foldername +".png");
		FileUtils.copyFile(scr, trg);
		return trg.getAbsolutePath();
	}
	public void switchToWindow(WebDriver driver,String partialtitle) {
		//step 1: capture the mailid
		String mainid=driver.getWindowHandle();
		// step 2:capture allid
		Set<String> allid=driver.getWindowHandles();
		//step3:Navigate to each window id
		
		for(String id:allid) {
			//Step 4:Switch to each window and capture the title
			String title=driver.switchTo().window(id).getTitle();
			//Step 5: Compare the title with required title
			if(title.contains(partialtitle)) {
				break;
			}
		}
		
		
	}
}
