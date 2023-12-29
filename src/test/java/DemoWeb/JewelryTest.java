package DemoWeb;

import org.testng.annotations.Test;

import GenericLibrary.BaseClass;
import ObjectRepository.HomePage;
import ObjectRepository.JewelryPage;

public class JewelryTest extends BaseClass{
	@Test
	public void diamondHeart() {
		HomePage homepage=new HomePage(driver);
		JewelryPage jewelrypage=new JewelryPage(driver);
		clickElement(homepage.getJewelryLink());//--->	homepage.getJewelryLink().click();
		keyboardScrollByAmount(driver, 0, 500);
		takeScreenshotWebPage(driver);
		takeScreenshotWebElement(jewelrypage.getDiamondHeartImage());
	}
}
