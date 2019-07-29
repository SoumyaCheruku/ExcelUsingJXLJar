package company;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class InterviewrAssign extends ApplicantRegBase {
	@Test(dataProvider="login")
	public void reg(String empl) throws InterruptedException{	
		/*driver.findElement(By.xpath("//*[@id='navbar-collapse-1']/ul/li/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Arrange Interview")).click();*/
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://192.168.2.245:8181/shortlistCandidates");
		driver.findElement(By.xpath("//*[@id='checkout_filter']/label/input")).sendKeys(empl);
		driver.findElement(By.xpath("//*[@id='scheduleid']")).click();
		WebElement e1=driver.findElement(By.id("txtassignto"));
		e1.sendKeys("venkateshwarlu");
		e1.sendKeys(Keys.TAB);
		
		
		
		((JavascriptExecutor)driver).executeScript ("document.getElementById('datetxtid').removeAttribute('readonly',0);"); // Enables the from date box

		WebElement fromDateBox= driver.findElement(By.id("datetxtid"));
		fromDateBox.clear();
		fromDateBox.sendKeys("04-06-2019");
		fromDateBox.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@id='ddltypeofInterview_chzn']")).click();	
		WebElement e2= driver.findElement(By.xpath("//*[@id='ddltypeofInterview_chzn']/div/div/input"));
		e2.sendKeys("Telephonic");
		e2.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//*[@id='ddllocation_chzn']/a")).click();
		driver.findElement(By.id("ddllocation_chzn_o_1")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("txtremarks")).sendKeys("Applied");
		driver.findElement(By.xpath("//*[@id='btnsave']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button[2]")).click();
		Thread.sleep(2000);
		
	}
	
	@DataProvider
	public Object[][] login() throws BiffException, IOException 
	{
		  Object [][]data= getExcelDat();
		  
		  return data;

	}
	private Object[][] getExcelDat() throws BiffException, IOException
	{
			FileInputStream fi= new FileInputStream("/home/sbv6/Desktop/Empassign.xls");
			Workbook wb= Workbook.getWorkbook(fi);
			Sheet sh= wb.getSheet("emp");
			String[][] arexceldada = new String[sh.getRows()][sh.getColumns()];
			for (int i = 0; i < sh.getRows(); i++) 
			{
				for (int j = 0; j < sh.getColumns(); j++) 
				{
					arexceldada[i][j]=sh.getCell(j, i).getContents();
				}
			}
			return arexceldada;
		}

}
