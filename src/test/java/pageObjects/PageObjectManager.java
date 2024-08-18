package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	LandingPage landingPage ;
	OffersPage offersPage;
	CheckoutPage checkoutPage;
	WebDriver driver;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public LandingPage getLandingPage()
	{
		landingPage = new LandingPage(driver);
		return landingPage;
	}
	
	public OffersPage getOffersPage()
	{
		offersPage = new OffersPage(driver);
		return offersPage;
	}
	public CheckoutPage getCheckoutPage()
	{
		checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
}
