package TestNGRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="@target/failedscenarios.txt",glue="stepDefinitions",monochrome=true,dryRun=false,tags ="@OffersPage or @PlaceOrder",
plugin={"html:target/cucumberReport.html","json:target/cucumberReport.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:target/failedscenarios.txt"})

public class FailedTestRunner extends AbstractTestNGCucumberTests{

	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
}
