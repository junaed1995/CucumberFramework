package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {

	public TestContextSetup testContextSetup;
	
	public Hooks(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
	}
	
	@After
	public void CloseDriver() throws IOException
	{
		testContextSetup.testBase.WebDiverManager().quit();
	}
	
	@AfterStep
	public void takeScreenshot(Scenario scenario) throws IOException
	{
		WebDriver driver = testContextSetup.testBase.WebDiverManager();
		if(scenario.isFailed())
		{
			//take screenshot
			byte[] file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(file, "image/png", "screenshot");
		}
	}
}
