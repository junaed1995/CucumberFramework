package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	WebDriver driver;
	public String url;
	
	public WebDriver WebDiverManager() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		url = prop.getProperty("QAurl");
				
		if (driver==null) {
			if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\Mimo\\Documents\\chromedriver-win64\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			if (prop.getProperty("browser").equalsIgnoreCase("firefox"))
			{
				//firefox code
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(url); 
			driver.manage().window().maximize();
		}
		
				
		
		return driver;
	}
	
}
