package DemoWeb;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import GenericLibrary.BaseClass;
import GenericLibrary.WebDriverUtility;
import ObjectRepository.BooksPage;
import ObjectRepository.HomePage;

public class BooksTest extends BaseClass{
	
	@Test
	public void books()
	{
		HomePage homePage=new HomePage(driver);
		BooksPage booksPage=new BooksPage(driver);
		//Click books link in the home page
		homePage.getBooksLink().click();
		test.log(LogStatus.INFO, "BOOKS link is clicked");
		//driver.findElement(By.linkText("Books")).click();
		String pageHeading=booksPage.getBooksPageHeading().getText();
		try {
		Assert.assertEquals(pageHeading, "Computer","BOOKS is not displayed");
		test.log(LogStatus.PASS, "Test case completed");
		}
		catch(AssertionError e) {
			String path=takeScreenshotWebPage(driver);
			test.log(LogStatus.FAIL, test.addScreenCapture(path));
		}
		//soft.assertEquals(driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText(), "BOOKS");
		
		Reporter.log("Heading of the Books page is "+booksPage.getBooksPageHeading().getText(),true);
	}
	@Test
	public void addBooktoCart() {
		HomePage homePage=new HomePage(driver);
		BooksPage booksPage=new BooksPage(driver);
		//Click books link in the home page
				homePage.getBooksLink().click();
		//driver.findElement(By.linkText("Books")).click();
				//Add computing and internet book to the cart
				booksPage.getAddComputingandInternetBookToCart().click();
		//driver.findElement(By.xpath("//a[.='Computing and Internet']/../..//div/input")).click();
				test.log(LogStatus.INFO, "BOOK is added to the cart");
				Reporter.log("Computing and Internet book is added to the cart successfully",true);
	}
	@Test
	public void dropDown() {
		HomePage homePage=new HomePage(driver);
		BooksPage booksPage=new BooksPage(driver);
		homePage.getBooksLink().click();
		selectDropdownbyIndex(booksPage.getSortbyDropdown(), 2);
	//	selectDropdownbyValue(booksPage.getDisplayDropdown(), "https://demowebshop.tricentis.com/books?pagesize=4");
		test.log(LogStatus.INFO, "Option is selected");
		selectDropdownbyVisibleText(booksPage.getViewasDropdown(), "List");
		
		
	}
}