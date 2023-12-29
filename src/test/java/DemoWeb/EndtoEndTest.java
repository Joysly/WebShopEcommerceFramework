package DemoWeb;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import GenericLibrary.BaseClass;
import GenericLibrary.FileUtility;
import ObjectRepository.ApparelandShoesPage;
import ObjectRepository.CheckoutPage;
import ObjectRepository.HomePage;

public class EndtoEndTest extends BaseClass{
	@Test
	public void checkOut() {
		HomePage homepage=new HomePage(driver);
		ApparelandShoesPage appandshoPage=new ApparelandShoesPage(driver);
		CheckoutPage checkoutPage=new CheckoutPage(driver);
		//click on apparel and shoes link
		homepage.getApparelandShoesLink().click();
		//keyboardScrollByAmount(driver, 0, 300);
		//click on blue jeans
		clickElement(appandshoPage.getBluejeansLink());
		//Click on AddtoCart link to add Blue Jeans to the Cart
		appandshoPage.getBluejeansaddtoCartLink().click();
		//Click on shopping cart in the homePage
		homepage.getShoppingcartLink().click();
		//Click on Terms and Conditions checkbox
		appandshoPage.getTermsAndConditionsLink().click();
		//Click on checkout button
		appandshoPage.getCheckoutLink().click();
		//Enter billing address details
		checkoutPage.getFirstNameTextField().sendKeys(FileUtility.getProperty("FirstName"));
		checkoutPage.getLastNameTextField().sendKeys(FileUtility.getProperty("LastName"));
		checkoutPage.getEmailTextField().sendKeys(FileUtility.getProperty("Email"));
		selectDropdownbyValue(checkoutPage.getCountryDropdown(), "41");
		checkoutPage.getCityTextField().sendKeys(FileUtility.getProperty("City"));
		checkoutPage.getAddressTextField().sendKeys(FileUtility.getProperty("Address"));
		checkoutPage.getZipcodeTextField().sendKeys(FileUtility.getProperty("ZipCode"));
		checkoutPage.getPhoneTextField().sendKeys(FileUtility.getProperty("phone"));
		//click on continue button in the billing address
		checkoutPage.getBillingContinueButton().click();
		//click on continue button in the shipping address
		checkoutPage.getShippingContinueButton().click();
		//click on continue button in the shipping method
		checkoutPage.getShippingMethodContinueButton().click();
		//click on continue button in the Payment method
		checkoutPage.getPaymentMethodContinueButton().click();
		//click on continue button in the Payment Information
		checkoutPage.getPaymentInformationContinueButton().click();
		//click on confirm button
		checkoutPage.getConfirmOrderConfirmButton().click();
		
		
	}
}
