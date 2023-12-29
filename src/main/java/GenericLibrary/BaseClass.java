package GenericLibrary;
	import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.Reporter;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

	public class BaseClass extends WebDriverUtility{
		public WebDriver driver;
		
		@BeforeSuite
		public void beforeSuite() {
			Reporter.log("Connect to the database",true);
			report=new ExtentReports(REPORTS_PATH);
		}
		@AfterSuite
		public void afterSuite() {
			report.flush();
			Reporter.log("DisConnect to the database",true);
		}
		@BeforeTest
		public void beforeTest() {
			Reporter.log("Before test",true);
		}
		@AfterTest
		public void afterTest() {
			Reporter.log("After test",true);
		}
		@BeforeClass
		public void beforeClass() throws InterruptedException {
			Reporter.log("Launch the browser",true);
			String browser=FileUtility.getProperty("browser");
			if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("Edge")){
				driver=new EdgeDriver();
			}
			else if(browser.equalsIgnoreCase("Firefox")){
				driver=new FirefoxDriver();
			}
			else {
				driver=new EdgeDriver();
			}	
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			String url=FileUtility.getProperty("url");
			driver.get(url);
			Thread.sleep(6000);
			//initObjects();
		
		}
		@AfterClass
		public void afterClass() {
			Reporter.log("Close the browser",true);
			driver.quit();
		}
		@BeforeMethod
		public void beforeMethod(Method method) {
			String methodName=method.getName();
			test=report.startTest(methodName);
			Reporter.log("Login",true);
			LoginPage loginpage=new LoginPage(driver);
			loginpage.login(driver);	
		}
		@AfterMethod
		public void afterMethod() {
			report.endTest(test);
			Reporter.log("Logout",true);
			LoginPage loginpage=new LoginPage(driver);
			loginpage.logout(driver);
		}
	}