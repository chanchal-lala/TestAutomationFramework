package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsDemoWithTestNG 
{
  private WebDriver driver;
  ExtentHtmlReporter htmlReporter;
  ExtentReports extent;
  
  @BeforeSuite
  public void setUp()
  {
	  // start reporters
      htmlReporter = new ExtentHtmlReporter("extent.html");
  
      //create ExtentReports and attach reporter(s)
      extent = new ExtentReports();
      extent.attachReporter(htmlReporter);
      
      // Initiate Browser:
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
  }
    
  @Test
  public void test1() throws Exception 
  {
	  ExtentTest test1 = extent.createTest("MyFirstTest", "Sample description");
	  
	  driver.get("https://www.wikipedia.org/");
	  test1.pass("Navigated to wikipedia.org");
	  
	  //log (Status, details)
      test1.log(Status.INFO, "This step shows usage of log(status, details)");
	  // info(details)
      test1.info("This step shows usage of info(details)");
      // log with snapshot
      test1.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
      // test with snapshot
      test1.addScreenCaptureFromPath("screenshot.png");
  }
  
  @Test
  public void test2() throws Exception 
  {
	  ExtentTest test2 = extent.createTest("MySecondTest", "Sample description");
	  driver.get("https://github.com/");
	  test2.pass("Navigated to github");
	  System.out.println("Test Passed Successfully");
  }
  
  @AfterSuite
  public void tearDown()
  {
	  extent.flush();
  }
  
}
