package GenericLibrary;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
/**
 * This class is created for all the reusable methods
 */
public class WebDriverUtility implements FrameworkConstants{
	public static WebDriver driver;
	public static Actions action;
	public static JavascriptExecutor je;
	public ExtentReports report;
	public ExtentTest test;
	
	public void initObjects() {
		action=new Actions(driver);
		je=(JavascriptExecutor) driver;
	}
	public static void selectDropdownbyIndex(WebElement dropdown,int index) {
		Select select=new Select(dropdown);
		select.selectByIndex(index);
	}
	public static void selectDropdownbyValue(WebElement dropdown, String value) {
		Select select=new Select(dropdown);
		select.selectByValue(value);
	}
	public static void selectDropdownbyVisibleText(WebElement dropdown, String visibleText) {
		Select select=new Select(dropdown);
		select.selectByVisibleText(visibleText);
	}
	//Switch to Window using TITLE
	public static void switchToWindowbyTilte(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			driver.switchTo().window(window);
			if(driver.getTitle().contains(title))
				break;
			
		}
	}
		//Switch to Window using URL
		public static void switchToWindowbyUrl(WebDriver driver, String url) {
			Set<String> allWindows = driver.getWindowHandles();
			for (String window : allWindows) {
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains(url))
					break;
				
			}
		}
		//Switch to frame using INDEX 
		public static void switchToFramebyINDEX(WebDriver driver, int index) {
			driver.switchTo().frame(index);
		}
		//Switch to frame using NAMEorID
		public static void switchToFramebyNAMEorID(WebDriver driver, String nameORid) {
			driver.switchTo().frame(nameORid);
		}
		//Switch to frame using WEBELEMENT 
		public static void switchToFramebyWEBELEMENT(WebDriver driver, String webelement) {
			driver.switchTo().frame(webelement);
		}
		//Switch to Parent Frame
		public static void switchToParentFrame(WebDriver driver) {
			driver.switchTo().parentFrame();
		}
		/**
		 * It is a Method to switch to the default parent frame
		 * @param driver
		 */
		public static void switchToDefaultParentFrame(WebDriver driver) {
			driver.switchTo().defaultContent();
		}
		//WebDriver methods
		/**
		 * It is a Method to the particular webelement using click()
		 * @param driver
		 */
		public static void clickElement(WebElement element) {
			element.click();
		}
		/**
		 * It is a Method to enter the text using sendKeys()
		 * @param driver
		 */
		public static void sendKeysMethod(WebElement element, String text) {
			element.sendKeys(text);
		}
		
		/**
		 * It is a method to take the Screenshot of WebPage
		 * @param driver
		 */
		public static String takeScreenshotWebPage(WebDriver driver) {
			TakesScreenshot ts=(TakesScreenshot) driver;
			File temp=ts.getScreenshotAs(OutputType.FILE);
			String imgPath=Screenshot_path+getSystemDateTime()+".png";
			File permanent=new File(imgPath);
			try {
				FileHandler.copy(temp, permanent);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "."+imgPath;
		}
		/**
		 * It is a method to take the screenshot of WebElement
		 * @param driver
		 */
		public static String takeScreenshotWebElement(WebElement element) {
			File temp=element.getScreenshotAs(OutputType.FILE);
			String imgPath=Screenshot_path+getSystemDateTime()+".png";
			File perm=new File(imgPath);
			try {
				FileHandler.copy(temp, perm);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "."+imgPath;
		}
		/**
		 * It is a method to get the Current System Date and Time
		 * @param driver
		 */
		public static String getSystemDateTime() {
			 return LocalDateTime.now().toString().replace(":", "_").replace("-", "_");
		}
		/**
		 * It is a Method to handle alert using accept()
		 * @param driver
		 */
		public static void handleAlertbyAccept(WebDriver driver) {
			driver.switchTo().alert().accept();
		}
		/**
		 * It is a Method to handle alert using dismiss()
		 * @param driver
		 */
		public static void handleAlertbyDismiss(WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}
		/**
		 * It is a Method to handle alert using getText()
		 * @param driver
		 */
		public static String handleAlertbyGetText(WebDriver driver) {
			return driver.switchTo().alert().getText();
		}
		/**
		 * It is a Method to handle alert using getText()
		 * @param driver
		 */
		public static void handleAlertbySendkeys(WebDriver driver,String text) {
			driver.switchTo().alert().sendKeys(text);
		}
		//Method to handle mouse actions
		/**
		 * It is a Method to mouse hover click method
		 * @param driver
		 */
		public static void mouseClick(WebDriver driver,WebElement element) {
			Actions action=new Actions(driver);
			action.click(element).perform();
		}
		/**
		 * It is a Method to mouse hover right-click method
		 * @param driver
		 */
		public static void mouseContextClick(WebDriver driver,WebElement element) {
			Actions action=new Actions(driver);
			action.contextClick(element).perform();
		}
		/**
		 * It is a Method to mouse hover right-click method
		 * @param driver
		 */
		public static void mouseDoubleClick(WebDriver driver,WebElement element) {
			Actions action=new Actions(driver);
			action.doubleClick(element).perform();
		}
		/**
		 * It is a Method to move to the particular element
		 * @param driver
		 */
		public static void mouseMovetoElement(WebDriver driver,WebElement element) {
			Actions action=new Actions(driver);
			action.moveToElement(element).perform();
		}
		/**
		 * It is a Method to move the particular element from the source to destination
		 * @param driver
		 */
		public static void mousedragandDrop(WebDriver driver,WebElement srcelement,WebElement destelement) {
			Actions action=new Actions(driver);
			action.dragAndDrop(srcelement, destelement).perform();
		}
		/**
		 * It is a Method to click and hold the particular element
		 * @param driver
		 */
		public static void mouseClickandHold(WebDriver driver,WebElement element) {
			Actions action=new Actions(driver);
			action.clickAndHold(element).perform();
		}
		/**
		 * It is a Method to release the particular element
		 * @param driver
		 */
		public static void mouseRelease(WebDriver driver,WebElement element) {
			Actions action=new Actions(driver);
			action.release(element).perform();
		}
		/**
		 * It is a keyboard Actions Method to scroll to the particular element using x-axis 
		 * and y-axis values
		 * @param driver
		 */
		public static void keyboardScrollByAmount(WebDriver driver,int x, int y) {
			Actions action=new Actions(driver);
			action.scrollByAmount(x, y).perform();
		}
		/**
		 * It is a keyboard Actions Method to scroll to the particular element  
		 * @param driver
		 */
		public static void keyboardScrolltoElement(WebDriver driver,WebElement element) {
			Actions action=new Actions(driver);
			action.scrollToElement(element).perform();
		}
		/**
		 * It is a keyboard Actions Method to scroll to the particular element using x-axis 
		 * and y-axis values
		 * @param driver
		 */
		public static void keyboardScrollfromOrigin(WebDriver driver,WebElement element,int x,int y) {
			Actions action=new Actions(driver);
			WheelInput.ScrollOrigin origin=WheelInput.ScrollOrigin.fromElement(element);
			action.scrollFromOrigin(origin, x, y).perform();
		}
		//JavascriptExecutor Methods
		/**
		 * It is a Method to handle hidden or disabled button
		 * @param driver
		 */
		public void clickOnHiddenorDisabledElement(WebDriver driver,WebElement element) {
			JavascriptExecutor je=(JavascriptExecutor) driver;
			je.executeScript("arguments[0].click();", element);
		}
		/**
		 * It is a Method to handle hidden or disabled button
		 * @param driver
		 */
		public void enterTextonHiddenorDisabledElement(WebDriver driver,WebElement element,String value) {
			//JavascriptExecutor je=(JavascriptExecutor) driver;
			je.executeScript("arguments[0].value='"+value+"';", element);
		}
		/**
		 * It is a Method to scroll the window based on x and y value
		 * @param driver
		 */
		public void scrollByXandY(WebDriver driver,int x,int y) {
			JavascriptExecutor je=(JavascriptExecutor) driver;
			je.executeScript("window.scrollBy("+x+","+y+");");
		}
		/**
		 * It is a Method to scroll the window to the particular element
		 * @param driver
		 */
		public void scrollToXandY(WebDriver driver,int x,int y) {
			//JavascriptExecutor je=(JavascriptExecutor) driver;
			je.executeScript("window.scrollTo("+x+","+y+");");
		}
		/**
		 * It is a Method to scroll the window to the top of the particular element
		 * or bottom of the particular element
		 * @param driver
		 */
		public void scrollIntoView(WebDriver driver,WebElement element,boolean position) {
			//JavascriptExecutor je=(JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView("+position+");");
		}
		
}