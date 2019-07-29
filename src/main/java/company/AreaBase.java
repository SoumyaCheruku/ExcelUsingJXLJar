package company;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AreaBase {
	
	public static WebDriver driver;
	@BeforeMethod
	//@Test
	public void start(){
		System.setProperty("webdriver.chrome.driver","//home//sbv6//Downloads//chromedriver");		
		driver =  new ChromeDriver(); 
		driver.get("http://localhost:3000/bnc/masters/areas");
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[1]")).click();
		
		
		
	}
	
	@AfterMethod
	public void end() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}
	

}
