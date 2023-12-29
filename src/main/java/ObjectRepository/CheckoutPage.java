package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "BillingNewAddress_FirstName")
	private WebElement firstNameTextField;
	@FindBy(id = "BillingNewAddress_LastName")
	private WebElement lastNameTextField;
	@FindBy(id = "BillingNewAddress_Email")
	private WebElement emailTextField;
	@FindBy(id = "BillingNewAddress_City")
	private WebElement cityTextField;
	@FindBy(id = "BillingNewAddress_Address1")
	private WebElement addressTextField;
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	private WebElement zipcodeTextField;
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	private WebElement phoneTextField;
	@FindBy(id = "BillingNewAddress_CountryId")
	private WebElement countryDropdown;
	@FindBy(id = "BillingNewAddress_StateProvinceId")
	private WebElement statedropdown;
	@FindBy(xpath = "//div[@id='billing-buttons-container']//input")
	private WebElement billingContinueButton;
	@FindBy(xpath = "//div[@id='shipping-buttons-container']//input")
	private WebElement shippingContinueButton;
	@FindBy(xpath = "//div[@id='shipping-method-buttons-container']//input")
	private WebElement shippingMethodContinueButton;
	@FindBy(xpath = "//div[@id='payment-method-buttons-container']//input")
	private WebElement paymentMethodContinueButton;
	@FindBy(xpath = "//div[@id='payment-info-buttons-container']//input")
	private WebElement paymentInformationContinueButton;
	@FindBy(xpath = "//div[@id='payment-info-buttons-container']//input")
	private WebElement confirmOrderConfirmButton;
	
	public WebElement getConfirmOrderConfirmButton() {
		return confirmOrderConfirmButton;
	}
	public WebElement getPaymentInformationContinueButton() {
		return paymentInformationContinueButton;
	}
	public WebElement getShippingMethodContinueButton() {
		return shippingMethodContinueButton;
	}
	public WebElement getBillingContinueButton() {
		return billingContinueButton;
	}
	public WebElement getShippingContinueButton() {
		return shippingContinueButton;
	}
	public WebElement getPaymentMethodContinueButton() {
		return paymentMethodContinueButton;
	}
	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}
	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}
	public WebElement getEmailTextField() {
		return emailTextField;
	}
	public WebElement getCityTextField() {
		return cityTextField;
	}
	public WebElement getAddressTextField() {
		return addressTextField;
	}
	public WebElement getZipcodeTextField() {
		return zipcodeTextField;
	}
	public WebElement getPhoneTextField() {
		return phoneTextField;
	}
	public WebElement getCountryDropdown() {
		return countryDropdown;
	}
	public WebElement getStatedropdown() {
		return statedropdown;
	}

}
