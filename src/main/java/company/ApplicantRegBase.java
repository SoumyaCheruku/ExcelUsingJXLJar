package company;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ApplicantRegBase {

	public static WebDriver driver;

	//@Test
	@BeforeMethod
	public void start() {
		//comments
		System.setProperty("webdriver.chrome.driver", "//home//sbv6//Downloads//chromedriver");
		driver = new ChromeDriver();
		driver.get("http://192.168.2.245:8181");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("employeecode")).sendKeys("30085");
		driver.findElement(By.name("Password")).sendKeys("Leo@1234");
		driver.findElement(By.xpath("//*[@id='loginid']")).click();
		

	}
	
	@AfterMethod
	public void end() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}

}
