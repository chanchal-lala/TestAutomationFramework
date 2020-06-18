package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

public class GoogleSearchTest 
{

	private static WebDriver driver =null;
	
	public static void main(String[] args) 
	{
		googleSearch();
	}
	
	public static void googleSearch() 
	{
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Go to google.com
		driver.get("https://www.google.com/");
		
		//Perform a search of keyword:
		
		//driver.findElement(By.xpath("//input[@name='q']")).sendKeys("automation step by step");
		GoogleSearchPage.textbox_search(driver).sendKeys("automation step by step");
		
		//click on search button
	    //driver.findElement(By.xpath("//input[@name='btnK']")).click(); -- this might display number of search results so difficult to choose which one to choose from list.
		//driver.findElement(By.xpath("//input[@name='btnK']")).sendKeys(Keys.RETURN); ------ effective way, instead of clicking press enter through keyboard by code
		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);
		
		//close browser
		driver.close();
		driver.quit();
		
		System.out.println("Test Completed Successfully");
		
	}

}
