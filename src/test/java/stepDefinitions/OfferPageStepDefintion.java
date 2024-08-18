package stepDefinitions;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.sun.tools.sjavac.Log;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class OfferPageStepDefintion {

public TestContextSetup testContextSetup;
	
	// Making class loosely coupled
	public OfferPageStepDefintion(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;	
	}

	@Then("^User searched for the same (.+) in offers page$")
	public void user_searched_for_the_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) throws InterruptedException, IOException {
		switchToOffersPage();		
		LandingPage landingPage = new LandingPage(testContextSetup.testBase.WebDiverManager());
		landingPage.searchPage(shortName);
			    
	    Thread.sleep(5000);
	    
	    testContextSetup.offerPagePdName = testContextSetup.testBase.WebDiverManager().findElement(By.cssSelector("tr td:nth-child(1)")).getText();
	}

	//SRP rule
	public void switchToOffersPage()
	{
		//OffersPage offersPage = new OffersPage(testContextSetup.driver);
		OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
		
		offersPage.selectTopDeals();
		
	    testContextSetup.genericUtils.switchToChildWindow();
	}

	@Then("validate product name in offers page matches with Landing page")
	public void validate_product_name_in_Offers_Page() throws IOException {		  
		  Assert.assertTrue(testContextSetup.landingPagePdName.equals(testContextSetup.offerPagePdName));
		  testContextSetup.testBase.WebDiverManager().close();
	}
	
	
	 

	
}
