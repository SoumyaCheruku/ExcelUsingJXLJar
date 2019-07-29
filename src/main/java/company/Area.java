package company;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Area extends AreaBase{
	@Test(dataProvider="login")
	public void company(String area,String hr,String min) throws InterruptedException{
		
		driver.findElement(By.id("areaName")).sendKeys(area);
		
		driver.findElement(By.id("price")).sendKeys("2000");
		
		driver.findElement(By.name("hsnSacCode")).sendKeys("9996");
		
		driver.findElement(By.id("areaMinPax")).sendKeys("300");
		
		driver.findElement(By.id("areaMaxPax")).sendKeys("500");
		
		driver.findElement(By.name("cleanTime")).sendKeys(hr);
		Actions actions = new Actions(driver);
		WebElement clean=driver.findElement(By.name("cleanTimemins"));
		actions.moveToElement(clean);
		actions.sendKeys(min);
		
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);//select tax
		
		Thread.sleep(1000);
		actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);//select item group
		Thread.sleep(1000);
		actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);//select item type
		Thread.sleep(1000);
		actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);//select item subtype
		actions.build().perform();
		
		
		
		/*WebElement ele1 = driver.findElement(By.xpath("//*[@id='AreasForm']/div[1]/div[2]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div/span/div/div/div/div[2]"));
		
		
		actions.moveToElement(ele1);
		actions.click();
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN);
		actions.sendKeys(Keys.ENTER);
		actions.build().perform();		
		
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("/html/body/div[3]/div/div/div/ul/li[5]")).click();//Tax group GST select
		
		//Thread.sleep(2000);
		
		WebElement ele2 = driver.findElement(By.xpath("//*[@id='AreasForm']/div[1]/div[2]/div/span/div/div/div"));//item group
		
		actions.moveToElement(ele2);
		actions.click();
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER);
		actions.build().perform();	
		
		//driver.findElement(By.xpath("/html/body/div[4]/div/div/div/ul/li[1]")).click();//item group venue select
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Thread.sleep(2000);
		
		WebElement ele3 =driver.findElement(By.xpath("//*[@id='AreasForm']/div[2]/div[2]/div/span/div/div/div"));//item type
		
		actions.moveToElement(ele3);
		actions.click();
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);
		actions.build().perform();
		
		
		//driver.findElement(By.xpath("/html/body/div[6]/div/div/div/ul/li")).click();
		
		WebElement ele4 = driver.findElement(By.xpath("//*[@id='AreasForm']/div[3]/div[2]/div/span/div/div/div"));//item sub type
		
		
		
		//driver.findElement(By.xpath("/html/body/div[7]/div/div/div/ul/li")).click();
		actions.moveToElement(ele4);
		actions.click();
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);
		actions.build().perform();	
		*/	
		
		
		driver.findElement(By.xpath("//*[@id='AreasForm']/div[1]/div[1]/div/div/div/div/div[3]")).click();//click on seating type tab
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@id='AreasForm']/div[1]/div[2]/div[2]/div/div/div/span/button")).click();//click on + seating type
		
		Thread.sleep(1000);
		
		WebElement ele5 =driver.findElement(By.xpath("//*[@id='AreasForm']/div[1]/div[2]/div[2]/div/div/div/span/div/div/div/div/div/div/div[2]/table/tbody/tr/td[2]/div/div/div/span/div/div/div"));//select seating type
		
		actions.moveToElement(ele5);
		actions.click();
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);
		actions.build().perform();
		//driver.findElement(By.xpath("/html/body/div[3]/div/div/div/ul/li[1]")).click();
		
		
		actions.sendKeys(Keys.TAB);
		actions.sendKeys("300");
		
		actions.sendKeys(Keys.TAB);
		actions.sendKeys("500");
		actions.build().perform();
		
		//driver.findElement(By.xpath("//*[@id='AreasForm']/div[1]/div[2]/div[3]/div/div/div/span/div/div/div/div/div/div/div[2]/table/tbody/tr/td[4]/input")).sendKeys("500");
		
		driver.findElement(By.xpath("//*[@id='AreasForm']/div[1]/div[2]/div[2]/div/div/div/span/div/div/div/div/div/div/div[2]/table/tbody/tr/td[5]/span/button[1]")).click();
		
		
		driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div/button[2]")).click();
		
				
	}
	
	@DataProvider
	public Object[][] login() throws BiffException, IOException 
	{
		  Object [][]data= getExcelDat();
		  
		  return data;

	}
	private Object[][] getExcelDat() throws BiffException, IOException
	{
			FileInputStream fi= new FileInputStream("/home/sbv6/Desktop/Area.xls");
			Workbook wb= Workbook.getWorkbook(fi);
			Sheet sh= wb.getSheet("areas");
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
