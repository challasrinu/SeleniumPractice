package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfoTest {
@Test(dataProvider ="getdata" )
public void getProductInfoTest(String brandName,String productName){
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://amazon.in");
	
//search product
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
	String x = "//span[contains(.,'"+productName+"')]/ancestor::div[@class='a-section']/descendant::span[@class='a-price-whole']";
    String price = driver.findElement(By.xpath(x)).getText();
    System.out.println(price);
    driver.quit();
    
}
@DataProvider
public Object[][] getdata() throws Throwable {
	ExcelUtility EU=new ExcelUtility();
	int rowcount=EU.getRowcount("product");
	Object[][] objarr=new Object[4][2];
	for(int i=0;i<rowcount;i++) {
	objarr[i][0]=EU.getDataFromExcel("product",i+1, 0);
	objarr[i][1]=EU.getDataFromExcel("product",i+1, 1);
	}
	return objarr;

}
}
