package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {

	WebDriver driver;
	
	By topDeals = By.linkText("Top Deals");
	
	public OffersPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void selectTopDeals()
	{
		driver.findElement(topDeals).click();
	}
	
	
}
