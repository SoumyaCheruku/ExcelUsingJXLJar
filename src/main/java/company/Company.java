package company;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Company extends CompanyBase{
	
	@Test(dataProvider="login")
	public void company(String company, String territory,String segment,String Address,String city,String area,String pincode,String bo) throws InterruptedException{
		
		driver.findElement(By.id("companyName")).sendKeys(company);
		
		WebElement ele1 = driver.findElement(By.xpath("//*[@id='companyTerritory_chosen']/a/span"));
		ele1.click();		
		Thread.sleep(1000);
		WebElement ele11 =driver.findElement(By.xpath("//*[@id='companyTerritory_chosen']/div/div/input"));
		ele11.sendKeys(territory);
		ele11.sendKeys(Keys.TAB);
		
		WebElement ele2 = driver.findElement(By.xpath("//*[@id='companySegment_chosen']/a/span"));
		ele2.click();
		WebElement ele22 =driver.findElement(By.xpath("//*[@id='companySegment_chosen']/div/div/input"));
		ele22.sendKeys(segment);
		ele22.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		WebElement mySelectElement = driver.findElement(By.id("addressType"));
				
		Select dropdown= new Select(mySelectElement);
		dropdown.selectByVisibleText(Address);
		
		Thread.sleep(1000);
		
		WebElement ele3 = driver.findElement(By.id("city"));
		ele3.sendKeys(city);
		ele3.sendKeys(Keys.TAB);
		
		driver.findElement(By.id("addressLine2")).sendKeys(area);
		
		driver.findElement(By.id("pincode")).sendKeys(pincode);
		
		WebElement mySelectElement1 = driver
				.findElement(By
						.xpath("//*[@id='boAllocation']"));
		Select dropdown1= new Select(mySelectElement1);
		dropdown1.selectByVisibleText(bo);
		
		driver.findElement(By.id("add")).click();
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/button")).click();
		
		Thread.sleep(1000);
		
		
	}
	
	@DataProvider
	public Object[][] login() throws BiffException, IOException 
	{
		  Object [][]data= getExcelDat();
		  
		  return data;

	}
	private Object[][] getExcelDat() throws BiffException, IOException
	{
			FileInputStream fi= new FileInputStream("/home/sbv6/Desktop/company.xls");
			Workbook wb= Workbook.getWorkbook(fi);
			Sheet sh= wb.getSheet("data");
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
