package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import example.FirstSeleniumTest;

public class PropertiesFile 
{

	static Properties prop = new Properties(); // making it global for all functions
	
	public static void main(String[] args) 
	{
		readPropertiesFile();		
		writePropertiesFile();
		readPropertiesFile();	
	}
	
	public static void readPropertiesFile()
	{
		
		try 
		{
			InputStream input = new FileInputStream ("src\\test\\java\\config\\config.properties");
			prop.load(input);
			//System.out.println(prop.getProperty("browser"));
			FirstSeleniumTest.browser = prop.getProperty("browser");
			System.out.println(FirstSeleniumTest.browser);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void writePropertiesFile()
	{
		try 
		{
			OutputStream output = new FileOutputStream ("src\\test\\java\\config\\config.properties");
			prop.setProperty("browser", "Chrome");
			prop.setProperty("Result", "Passed");
			prop.store(output , "Stored Successfully inside config.propertyFile");
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
