package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JewelryPage extends BasePage{
	public JewelryPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(linkText = "Black & White Diamond Heart")
	private WebElement diamondHeartLink;
	@FindBy(css = "[alt='Picture of Black & White Diamond Heart']")
	private WebElement diamondHeartImage;
	@FindBy(xpath = "//a[.='Black & White Diamond Heart']/../..//div//input[@value='Add to cart']")
	private WebElement diamondHeartAddtoCart;
	@FindBy(xpath = "//a[.='Black & White Diamond Heart']/../..//div/span")
	private WebElement diamondHeartPrice;
	public WebElement getDiamondHeartLink() {
		return diamondHeartLink;
	}
	public WebElement getDiamondHeartImage() {
		return diamondHeartImage;
	}
	public WebElement getDiamondHeartAddtoCart() {
		return diamondHeartAddtoCart;
	}
	public WebElement getDiamondHeartPrice() {
		return diamondHeartPrice;
	}
	
}
