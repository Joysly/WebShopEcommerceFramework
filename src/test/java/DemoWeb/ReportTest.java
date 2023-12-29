package DemoWeb;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportTest {
	@Test
	public void reportTest() throws InterruptedException
	{
		ExtentReports report=new ExtentReports("./Reports/Report.html");
		ExtentTest test=report.startTest("loginTest");
		
		WebDriver driver=new EdgeDriver();
		test.log(LogStatus.INFO, "Edge browser launched");
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Edge Browser Maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("saljoyfj@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Jesusg30$");
		driver.findElement(By.cssSelector("[value='Log in']")).click();
		
		Assert.assertEquals(driver.findElement(By.linkText("Log out")).isDisplayed(), true,"Log out is not displayed");
		test.log(LogStatus.INFO, "Login successful");
		report.endTest(test);
		report.flush();
		driver.quit();
	}
}
