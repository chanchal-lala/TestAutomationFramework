package reports;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.jboss.aerogear.security.otp.Totp;

public class ReportToSharePoint {
  
  private WebDriver driver;
  @BeforeTest
  public void beforeTest() 
  {
	  WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.manage().window().maximize();
  }
  
  @Test
  public void SharePointUpload() throws Exception 
  {
	    driver.get("https://vodafone.sharepoint.com.eu.cas.ms/sites/Jenkins142/Shared%20Documents/Forms/AllItems.aspx?RootFolder=%2Fsites%2FJenkins142%2FShared%20Documents%2FGeneral%2FJenkinsSanity%2DTestResults%2FE4%5FSanity%2FE4%5F112%5FTestResult&FolderCTID=0x012000FAED0D35A2E85E428B6B268E3F8A2E06");
		WebElement Email_Username = driver.findElement(By.xpath("//input[@type='email']"));
		Email_Username.sendKeys("chanchal.lala@vodafone.com");
		Thread.sleep(5000);
		WebElement next = driver.findElement(By.xpath("//input[@type='submit']"));
		next.isDisplayed();
		next.isEnabled();
		next.click();
		Thread.sleep(20000);
		WebElement Username = driver.findElement(By.xpath("//input[@id='userNameInput']"));
		Username.clear();
		Username.sendKeys("chanchal.lala@vodafone.com");
		Thread.sleep(5000);
		WebElement passkey = driver.findElement(By.xpath("//input[@id='passwordInput']"));
		passkey.clear();
		passkey.sendKeys(decodeString("X1ZPSVNAMTAwNg=="));
		Thread.sleep(5000);
	    WebElement submit = driver.findElement(By.xpath("//span[@id='submitButton']"));
		submit.click();
		Thread.sleep(20000);
		
		
		String otpKeyStr = "anicllnlgpbdhkpgmhjepdnablmbglgf"; // <- this 2FA secret key.
		Totp totp = new Totp(otpKeyStr);
		String twoFactorCode = totp.now(); // <- got 2FA code at this time!
		WebElement userAnotherOption = driver.findElement(By.linkText("Use another option to Sign In"));
		userAnotherOption.click();
		Thread.sleep(15000);
		WebElement securitycode = driver.findElement(By.xpath("//input[@id='securityCode']"));
		securitycode.sendKeys(twoFactorCode);
		Thread.sleep(15000);
		WebElement submittocontinue = driver.findElement(By.xpath("//button[@id='continueButton']"));
		submittocontinue.click();
		Thread.sleep(10000);
		WebElement NotNowRememberme = driver.findElement(By.xpath("//button[@id='notNowRememberDevice']"));
	    NotNowRememberme.isDisplayed();
	    NotNowRememberme.isEnabled();
	    NotNowRememberme.click();
	    Thread.sleep(45000);
	 /* WebElement clickNo = driver.findElement(By.xpath("//input[@value='No']"));
	    clickNo.isDisplayed();
	    clickNo.isEnabled();
	    clickNo.click();
	    Thread.sleep(45000);*/
	    driver.navigate().to("https://vodafone.sharepoint.com.eu.cas.ms/sites/Jenkins142/Shared%20Documents/Forms/AllItems.aspx?RootFolder=%2Fsites%2FJenkins142%2FShared%20Documents%2FGeneral%2FJenkinsSanity%2DTestResults%2FE4%5FSanity%2FE4%5F112%5FTestResult&FolderCTID=0x012000FAED0D35A2E85E428B6B268E3F8A2E06");
	    Thread.sleep(30000);
	    WebElement UploadElement = driver.findElement(By.xpath("//span[contains(text(),'Upload')]"));
		UploadElement.isDisplayed();
		UploadElement.isEnabled();
		UploadElement.click();
		WebElement FilesLink = driver.findElement(By.xpath("//span[contains(text(),'Files')] "));
		Actions actions = new Actions(driver);
		actions.moveToElement(FilesLink).perform();
		FilesLink.click();
		Thread.sleep(10000);
		Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");
		Thread.sleep(20000);
  }
  
  private CharSequence decodeString(String password) 
  {
	  byte[] decodedString = Base64.decodeBase64(password);
	  return(new String(decodedString));
  }
  
  @AfterTest
  public void afterTest()
  {
		/*driver.close();
		driver.quit();*/
		System.out.println("Files are successfully uploaded");
  }

}
