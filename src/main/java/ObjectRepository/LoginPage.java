package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibrary.FileUtility;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "Email")
	private WebElement emailTextField;
	@FindBy(id = "Password")
	private WebElement passwordTextField;
	@FindBy(id = "RememberMe")
	private WebElement remembermeCheckBox;
	@FindBy(linkText = "Forgot password?")
	private WebElement forgotpasswordLink;
	@FindBy(css = "[value='Log in']")
	private WebElement loginButton;
	

	public WebElement getEmailTextField() {
		return emailTextField;
	}
	public WebElement getPasswordTextField() {
		return passwordTextField;
	}
	public WebElement getRemembermeCheckBox() {
		return remembermeCheckBox;
	}
	public WebElement getForgotpasswordLink() {
		return forgotpasswordLink;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	/**
	 * Used to login using email and password
	 * @param driver
	 */
	public void login(WebDriver driver) {
		HomePage homepage=new HomePage(driver);
		LoginPage loginpage=new LoginPage(driver);
		homepage.getLoginLink().click();
		//Click on login link
		homepage.getLoginLink().click();
		//Enter the email 
		loginpage.getEmailTextField().sendKeys(FileUtility.getProperty("email"));
		//Enter the password
		loginpage.getPasswordTextField().sendKeys(FileUtility.getProperty("password"));
		//Click on remember me
		loginpage.getRemembermeCheckBox().click();
		//click on login button
		loginpage.getLoginButton().click();
	}
	/**
	 * Used to logout 
	 * @param driver
	 */
	public void logout(WebDriver driver) {
		HomePage homepage=new HomePage(driver);
		homepage.getLogoutLink().click();
	}
}