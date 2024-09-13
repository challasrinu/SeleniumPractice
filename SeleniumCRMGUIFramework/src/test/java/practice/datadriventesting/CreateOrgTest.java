package practice.datadriventesting;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrgTest {
public static void main(String[] args) throws IOException {
			FileInputStream fis=new FileInputStream("./configAppData/commondata.properties");
		  Properties pobj=new Properties();
		  pobj.load(fis);
		  String BROWSER=pobj.getProperty("browser");
		  String URL=pobj.getProperty("url");
		  String USERNAME=pobj.getProperty("username");
		  String PASSWORD=pobj.getProperty("password");
		 
		  WebDriver driver=null;
		  if (BROWSER.equalsIgnoreCase("chrome")) {
			  driver=new ChromeDriver();
		  }
		  else if(BROWSER.equalsIgnoreCase("firefox")) {
			  driver=new FirefoxDriver();
		  }
		  else if(BROWSER.equalsIgnoreCase("edge")) {
			  driver=new EdgeDriver();
		  }
		  else
			  driver=new ChromeDriver();	
	driver.get(URL);
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
	driver.findElement(By.xpath("//input[@type='submit']")).submit();
	driver.findElement(By.linkText("Organizations")).click();
	driver.quit();
}
}

