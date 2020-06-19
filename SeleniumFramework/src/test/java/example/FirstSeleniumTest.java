package example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstSeleniumTest 
{

	public static String browser;
	static WebDriver driver;
	
	public static void main(String[] args) 
	{
		//setBrowser();
		PropertiesFile.readPropertiesFile();
		setBrowserConfig();
		runTest();
		PropertiesFile.writePropertiesFile();
	}
	
	//setBrowser
	//setBrowserConfig
	//runTest
	
	/**
	 * Description: Modular Coding approach
	 * @Author: Chanchal
	 * @date: 
	 */
	
	//setBrowser
	public static void setBrowser()
	{
	browser="firefox";	
	}
	
	//setBrowserConfig
	public static void setBrowserConfig()
	{
		//This condition block sets configuration for FireFox Browser
		if(browser.contains("firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", "BrowserDrivers\\geckodriver.exe");
			//driver = new FirefoxDriver();
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
	
		//This condition block sets configuration for Chrome Browser
		if(browser.contains("Chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "BrowserDrivers\\chromedriver.exe");
			//driver = new ChromeDriver(); 
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
	}
	
	//runTest
	public static void runTest()
	{
		driver.get("https://mail.google.com/");  
		driver.close();
		driver.quit();
	}
}