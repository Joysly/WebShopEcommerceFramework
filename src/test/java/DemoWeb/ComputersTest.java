package DemoWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericLibrary.BaseClass;

public class ComputersTest extends BaseClass{
	@Test
	public void books()
	{
		driver.findElement(By.linkText("Computers")).click();
		driver.findElement(By.xpath("//img[@alt='Picture for category Notebooks']")).click();
		WebElement position = driver.findElement(By.id("products-orderby"));
		Select select= new Select(position);
		select.selectByIndex(2);
		driver.findElement(By.cssSelector("[value='Add to cart']")).click();
		Reporter.log(driver.findElement(By.cssSelector("[class='content']")).getText(),true);
	}
	@Test
	public void addBooktoCart() {
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("Computers"))).perform();
	}
}
