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
  
  public void BeforeTest()
  {
	  
  }
  
  @Test
  public void test1() throws Exception 
  {
	  ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
	  
	  driver.get("https://www.google.com/");
	  test.pass("Navigated to google.com");
	  
	  //log (Status, details)
      test.log(Status.INFO, "This step shows usage of log(status, details)");
	  // info(details)
      test.info("This step shows usage of info(details)");
      // log with snapshot
      test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
      // test with snapshot
      test.addScreenCaptureFromPath("screenshot.png");
  }
  
  @AfterSuite
  public void tearDown()
  {
	  extent.flush();
  }
  
}
