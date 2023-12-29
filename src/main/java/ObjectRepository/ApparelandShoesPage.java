package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApparelandShoesPage extends BasePage {

	public ApparelandShoesPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//div[@class='item-box']//img[@title='Show details for Blue Jeans']")
	private WebElement bluejeansLink;
	public WebElement getBluejeansLink() {
		return bluejeansLink;
	}
	@FindBy(id = "add-to-cart-button-36")
	private WebElement bluejeansaddtoCartLink;
	public WebElement getBluejeansaddtoCartLink() {
		return bluejeansaddtoCartLink;
	}
	@FindBy(name = "termsofservice")
	private WebElement termsAndConditionsLink;
	public WebElement getTermsAndConditionsLink() {
		return termsAndConditionsLink;
	}
	@FindBy(id = "checkout")
	private WebElement checkoutLink;
	public WebElement getCheckoutLink() {
		return checkoutLink;
	}
	

	

}
