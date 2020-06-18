package example;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;		
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;		
public class NewTest 
{		
	    private WebDriver driver;
	    @BeforeTest
		public void beforeTest() 
		{	
			//System.setProperty("webdriver.chrome.driver", "BrowserDrivers\\chromedriver.exe");
		   // driver = new ChromeDriver();  
	    	//System.setProperty("webdriver.gecko.driver", "BrowserDrivers\\geckodriver.exe");
	    	//driver = new FirefoxDriver();
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	    	
		}		
		@Test				
		public void test1() throws Exception 
		{	
			driver.get("http://localhost/mantisbt/");
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys("administrator");
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("CHANchal23#");
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			//driver.get("http://demo.guru99.com/test/guru99home/");  
			//String title = driver.getTitle();				 
			//Assert.assertTrue(title.contains("Demo Guru99 Page")); 		
		}	
		
	    @Test
	    public void test2()
	    {
	    	driver.get("https://automationstepbystep.com/");
	    }
	    
		@AfterTest
		public void afterTest() throws Exception 
		{
			Thread.sleep(5000);
			driver.close();
			//driver.quit();
			System.out.println("Tested Successfully");
		}	

}

