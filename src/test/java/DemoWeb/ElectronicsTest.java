package DemoWeb;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericLibrary.BaseClass;

public class ElectronicsTest extends BaseClass {
	@Test
	public void books() throws AWTException
	{
		driver.findElement(By.linkText("Electronics")).click();
		driver.findElement(By.xpath("//img[contains(@alt,'Camera, photo')]")).click();
		Robot robot=new Robot();
		for (int i = 0; i < 3; i++) {
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
		}
		String camcorderPrice = driver.findElement(By.xpath("//span[contains(.,'349.00')]")).getText();
		Reporter.log("Camcorder price is "+camcorderPrice,true);
		
	}
	@Test
	public void addBooktoCart() {
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("Electronics"))).perform();
		driver.findElement(By.id("small-searchterms")).sendKeys("mobile");
		driver.findElement(By.cssSelector("[type='submit']")).click();
	}
}
