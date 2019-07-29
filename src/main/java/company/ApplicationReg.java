package company;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ApplicationReg extends ApplicantRegBase {
	@Test(dataProvider="login")
	public void reg(String name) throws InterruptedException{
		driver.get("http://192.168.2.245:8181/applicant_registration");
		driver.findElement(By.xpath("//*[@id='vacanyInfoTblId_filter']/label/input")).sendKeys("Sr. Business Analyst");//search position
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='vacanyInfoTblId']/tbody/tr/td[1]/input")).click();//click on position
		driver.findElement(By.xpath("//*[@id='btnproceed']")).click();//click on reg application
		driver.findElement(By.name("applicantname")).sendKeys(name);
		driver.findElement(By.id("txtmobilenumber")).sendKeys("8529639874");
		driver.findElement(By.id("txttotalworkingexp")).sendKeys("3");
		driver.findElement(By.id("txtcurrentorganization")).sendKeys("VBTS");
		driver.findElement(By.id("txtcurrentCTC")).sendKeys("5.6");
		driver.findElement(By.id("txtcurrentworkinglocation")).sendKeys("Hyderabad");
		driver.findElement(By.id("txtqualification")).sendKeys("Btech");
		driver.findElement(By.id("txtemail")).sendKeys("soumya@gmail.com");
		driver.findElement(By.id("txtcurrentcompanyworkingexp")).sendKeys("2.5");
		driver.findElement(By.id("txtcurrentposition")).sendKeys("Business Analyst");
		driver.findElement(By.id("txtExpectedCTC")).sendKeys("7.5");
		driver.findElement(By.id("txtkeyskills")).sendKeys("Java");
		driver.findElement(By.id("resume")).sendKeys("/home/sbv6/Desktop/rose-165819_960_720.jpg");
		WebElement ele1= driver.findElement(By.xpath("//*[@id='ddlsource_chzn']/a"));
		ele1.click();
		WebElement ele2=driver.findElement(By.xpath("//*[@id='ddlsource_chzn']/div/div/input"));
		ele2.sendKeys("Web Portal");
		ele2.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id='ddlsubsource_chzn']/a")).click();
		WebElement ele3=driver.findElement(By.xpath("//*[@id='ddlsubsource_chzn']/div/div/input"));
		ele3.sendKeys("naukari");
		ele3.sendKeys(Keys.ENTER);
		driver.findElement(By.id("btnsave")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/button[2]")).click();
		
		
	}
	
	@DataProvider
	public Object[][] login() throws BiffException, IOException 
	{
		  Object [][]data= getExcelDat();
		  
		  return data;

	}
	private Object[][] getExcelDat() throws BiffException, IOException
	{
			FileInputStream fi= new FileInputStream("/home/sbv6/Desktop/emp.xls");
			Workbook wb= Workbook.getWorkbook(fi);
			Sheet sh= wb.getSheet("reg");
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
