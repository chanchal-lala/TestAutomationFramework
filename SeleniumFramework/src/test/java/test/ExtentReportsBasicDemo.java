package test;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPageObjects;

public class ExtentReportsBasicDemo 
{

	private static WebDriver driver = null;
	public static void main(String[] args) throws Exception 
	{
		// start reporters
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
    
        //create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.createTest("Google Search Test One", "This is a set to validate google search functionality");
	
        // Initiate Browser:
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	
		//create object reference of page class file
		GoogleSearchPageObjects searchPageObj1 = new GoogleSearchPageObjects(driver); 
				
		//ACTUAL TEST EXECUTION:
		
		//log(Status, details)
        test1.log(Status.INFO, "Starting Test Case 1");
        
		driver.get("https://www.google.com/");
		test1.pass("Navigated to google.com");
        		
		searchPageObj1.setTextInSearchBox("automation step by step");
		test1.pass("Entered text in searchbox");
		
		searchPageObj1.clickSearchButton();
		test1.pass("Pressed keyboard Enter key");
		
		driver.close();
		driver.quit();
		test1.pass("Browser has been closed");
		
		test1.info("Test1 Completed");
		
				
		ExtentTest test2 = extent.createTest("Google Search Test Two", "This is a set to validate google search functionality");
		
        // Initiate Browser:
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	
		//create object reference of page class file
		GoogleSearchPageObjects searchPageObj2 = new GoogleSearchPageObjects(driver); 
				
		//log(Status, details)
        test2.log(Status.INFO, "Starting Test Case 2");
        
		driver.get("https://www.google.com/");
		test2.pass("Navigated to google.com");
        		
		Thread.sleep(10000);
		searchPageObj2.setTextInSearchBox("automation step by step");
		test2.pass("Entered text in searchbox");
		
		searchPageObj2.clickSearchButton();
		test2.fail("Pressed keyboard Enter key");
		
		driver.close();
		driver.quit();
		test2.pass("Browser has been closed");
		
		test2.info("Test2 Completed");
		
		//Calling flush writes everything to the log file
        extent.flush();
	}

}
