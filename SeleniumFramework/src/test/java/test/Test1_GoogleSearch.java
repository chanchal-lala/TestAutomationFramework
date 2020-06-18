package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1_GoogleSearch 
{

	static WebDriver driver;
	public static void main(String[] args) 
	{
		googleSearch();

	}
	
	public static void googleSearch() 
	{
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Go to google.com and start search
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("automation step by step");
		
		//click on search button
	    //driver.findElement(By.xpath("//input[@name='btnK']")).click();
		driver.findElement(By.xpath("//input[@name='btnK']")).sendKeys(Keys.RETURN);
		
		//close browser
		driver.close();
		
		System.out.println("Test Completed Successfully");
		
	}

}
