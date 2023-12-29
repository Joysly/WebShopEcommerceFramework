package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
	public HomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(linkText = "Register")
	private WebElement registerLink;
	@FindBy(linkText = "Log in")
	private WebElement loginLink;
	@FindBy(linkText = "Log out")
	private WebElement logoutLink;
	@FindBy(partialLinkText = "Shopping cart")
	private WebElement shoppingcartLink;
	@FindBy(partialLinkText = "Wishlist")
	private WebElement wishlistLink;
	@FindBy(id="small-searchterms")
	private WebElement searchTextField;
	@FindBy(css="[value='search']")
	private WebElement searchButton;
	@FindBy(partialLinkText = "Apparel & Shoes")
	private WebElement apparelandShoesLink;
	public WebElement getApparelandShoesLink() {
		return apparelandShoesLink;
	}
	@FindBy(partialLinkText = "Books")
	private WebElement booksLink;
	@FindBy(partialLinkText = "Computers")
	private WebElement computersLink;
	@FindBy(partialLinkText = "Electronics")
	private WebElement electronicsLink;
	@FindBy(partialLinkText = "Jewelry")
	private WebElement jewelryLink;
	
	
	
	public WebElement getJewelryLink() {
		return jewelryLink;
	}
	public WebElement getBooksLink() {
		return booksLink;
	}
	public WebElement getComputersLink() {
		return computersLink;
	}
	public WebElement getRegisterLink() {
		return registerLink;
	}
	public WebElement getLogoutLink() {
		return logoutLink;
	}
	public WebElement getLoginLink() {
		return loginLink;
	}
	public WebElement getShoppingcartLink() {
		return shoppingcartLink;
	}
	public WebElement getWishlistLink() {
		return wishlistLink;
	}
	public WebElement getSearchTextField() {
		return searchTextField;
	}
	public WebElement getSearchButton() {
		return searchButton;
	}
	public WebElement getElectronicsLink() {
		return electronicsLink;
	}
}
