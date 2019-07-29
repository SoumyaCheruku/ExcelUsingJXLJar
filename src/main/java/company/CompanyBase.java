package company;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompanyBase {
	
	public static WebDriver driver;
	@BeforeMethod
	//@Test
	public void start(){
		System.setProperty("webdriver.chrome.driver","//home//sbv6//Downloads//chromedriver");		
		driver =  new ChromeDriver(); 
		driver.get("http://192.168.2.191:8080/SFM/");
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("Username")).sendKeys("pavan");
		driver.findElement(By.id("password")).sendKeys("123");
		driver.findElement(By.xpath("/html/body/div/form/button")).click();	
		driver.get("http://192.168.2.191:8080/SFM/addCompanyMaster");
	}
	
	@AfterMethod
	public void end() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}
	
	
	

}
