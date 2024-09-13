package practiceprograms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AmazonMobiles {

@Test
public void amazonmoblies() throws Throwable, IOException {
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

driver.get("https://www.amazon.in/");
driver.findElement(By.id("twotabsearchtextbox")).sendKeys("phones");
driver.findElement(By.id("nav-search-submit-button")).click();

FileInputStream fis=new FileInputStream("C:\\Users\\chall\\OneDrive\\Desktop\\al.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sheet = wb.createSheet("srinivas78");
//List<WebElement> moblies = driver.findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']"));
List<WebElement> moblies = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
List<WebElement> prices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
for (int i = 0; i <moblies.size(); i++) {
	sheet.createRow(i).createCell(0).setCellValue(moblies.get(i).getText());
	sheet.getRow(i).createCell(1).setCellValue(prices.get(i).getText());
}
FileOutputStream fos=new FileOutputStream("C:\\Users\\chall\\OneDrive\\Desktop\\al.xlsx");
wb.write(fos);
wb.close();
}

@Test
public void Mobliesabove60000() throws Throwable {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	driver.get("https://www.amazon.in/");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("phones");
	driver.findElement(By.id("nav-search-submit-button")).click();

	FileInputStream fis=new FileInputStream("C:\\Users\\chall\\OneDrive\\Desktop\\al.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.createSheet("srinivas85");
	List<WebElement> moblies = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	List<WebElement> prices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
int rowcount=0;
for (int i = 0; i <moblies.size(); i++) {
	String data = prices.get(i).getText();
	int price_num = Integer.parseInt(data.replace(",",""));
		if (price_num > 30000) {
			 Row r=sheet.createRow(rowcount++);
	     	r.createCell(0).setCellValue(moblies.get(i).getText());
				System.out.println(moblies.get(i).getText()+"\t"+prices.get(i).getText());
				r.createCell(1).setCellValue(prices.get(i).getText());
			
	}
	
}
FileOutputStream fos1=new FileOutputStream("C:\\Users\\chall\\OneDrive\\Desktop\\al.xlsx");
wb.write(fos1);
wb.close();


}
}
