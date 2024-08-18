package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

	WebDriver driver;
	
	By search = By.xpath("//input[@type='search']");
	
	By pdName = By.cssSelector("h4.product-name");
	By addToCart = By.cssSelector(".product-action button");
	By increment=   By.cssSelector("a.increment");
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void searchPage(String userInput)
	{
		driver.findElement(search).sendKeys(userInput);
	}
	
	public String getLandingPagePdName()
	{
		 String landingPahgePdName = driver.findElement(pdName).getText().split("-")[0].trim();
		 System.out.println(landingPahgePdName+" is extracted from home page");
		 return landingPahgePdName;
	}
	
	public String getTitleLandingPage()
	{
		String titleLandingPage = driver.getTitle();
		return titleLandingPage;
	}
	
	public void addToCart()
	{
		driver.findElement(addToCart).click();
	}
	
	public void incrementQuantity(int quantity)
	{
		int i = quantity-1;
		while(i>0)
		{
			driver.findElement(increment).click();
			i--;
		}
		
	}
}
