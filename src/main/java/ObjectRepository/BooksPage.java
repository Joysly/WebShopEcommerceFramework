package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksPage extends BasePage{

	public BooksPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//div[@class='page-title']/h1")
	private WebElement booksPageHeading;
	
	public WebElement getBooksPageHeading() {
		return booksPageHeading;
	}
	@FindBy(xpath = "//a[.='Computing and Internet']/../..//div/input")
	private WebElement addComputingandInternetBookToCart;

	public WebElement getAddComputingandInternetBookToCart() {
		return addComputingandInternetBookToCart;
	}
	@FindBy(id = "products-orderby")
	private WebElement sortbyDropdown;
	@FindBy(id = "products-pagesize")
	private WebElement displayDropdown;
	@FindBy(id = "products-viewmode")
	private WebElement viewasDropdown;

	public WebElement getSortbyDropdown() {
		return sortbyDropdown;
	}
	public WebElement getDisplayDropdown() {
		return displayDropdown;
	}
	public WebElement getViewasDropdown() {
		return viewasDropdown;
	}}