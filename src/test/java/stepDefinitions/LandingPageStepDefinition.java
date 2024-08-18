package stepDefinitions;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {

TestContextSetup testContextSetup;
LandingPage landingPage;

	//Making class loosely coupled
	public LandingPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
		landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}
	
	@Given("User is on GreenCart landing page")
	public void user_is_on_green_cart_landing_page() throws IOException {
	   		  
		 landingPage.getTitleLandingPage().contains("Greencart");
	}
	
	@When("^User searched with short name (.+) and extracted actual name of product$")
	public void user_searched_with_short_name_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		
	    // Write code here that turns the phrase above into concrete actions				
		landingPage.searchPage(shortName);
		
	    Thread.sleep(2000);
	    		
	    testContextSetup.landingPagePdName = landingPage.getLandingPagePdName();
	    
	}
	
	@When("Added {string} items of the selected product to cart")
	public void Added_items_product(String quantity)
	{
		
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
		
	}
	
}
