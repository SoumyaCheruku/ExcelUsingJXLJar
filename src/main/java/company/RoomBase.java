package company;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RoomBase {
	
	public static WebDriver driver;
	//@BeforeMethod
	@Test
	public void start(){
		System.setProperty("webdriver.chrome.driver","//home//sbv6//Downloads//chromedriver");		
		driver =  new ChromeDriver(); 
		driver.get("http://staging.app.centerpoint.io:82/masters/rooms");
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
		
	}
	
	/*@AfterMethod
	public void end() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}
*/
}
