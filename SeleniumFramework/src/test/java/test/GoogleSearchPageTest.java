package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPageObjects;

public class GoogleSearchPageTest 
{

	private static WebDriver driver = null;
	public static void main(String[] args) 
	{
		googleSearchTest();

	}
	
	public static void googleSearchTest()
	{
		
		//initiate browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//create object reference of page class file
		GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver); 
		
		//actual test:
		driver.get("https://www.google.com/");
 		searchPageObj.setTextInSearchBox("automation step by step");
		searchPageObj.clickSearchButton();
		driver.close();
		System.out.println("Sucessfully Tested.");
	}
		
}
