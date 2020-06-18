package htmlunitdriver;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverTest 
{
	public static void main(String[] args)
	{
		HtmlUnitDriver driver = new HtmlUnitDriver();
		driver.get("https://automationstepbystep.com/");
		System.out.println("Title is "+ driver.getTitle());
		driver.quit();
	}
}
