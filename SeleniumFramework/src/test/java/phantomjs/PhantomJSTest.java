package phantomjs;

import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class PhantomJSTest {

	public static void main(String[] args) 
	{
		System.setProperty("phantomjs.binary.path", "BrowserDrivers\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		PhantomJSDriver driver = new PhantomJSDriver();
		driver.get("https://automationstepbystep.com/");
		System.out.println("Title is "+ driver.getTitle());
		driver.quit();

	}

}
