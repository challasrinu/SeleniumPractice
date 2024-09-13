package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateOrgTestFromJSON {
	@Test
	public void createOrgTest() throws IOException, InterruptedException, ParseException {
		// read common data from JSON file
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("E:\\data/appCommonData.json"));
		// Step2:Convert java object into JsonObject using downcasting
		JSONObject map = (JSONObject) obj;
		String URL = (String) map.get("url");
		String BROWSER = (String) map.get("browser");
		String USERNAME = (String) map.get("username");
		String PASSWORD = map.get("password").toString();
		// read testscript data from excel
		// generate the random number
		Random random = new Random();
		int ran = random.nextInt(10);
		// Step1:Login to APP
		FileInputStream fis1 = new FileInputStream("E:\\data\\TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet("org");
		Row row = sheet.getRow(1);
		String orgName = row.getCell(2).toString() + ran;
		wb.close();
		WebDriver driver = null;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else
			driver = new ChromeDriver();
		// step1: Login to app
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get(URL);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		// Step2:navigate to Organization page
		driver.findElement(By.linkText("Organizations")).click();
		// Step3:Click on "Create Organization Button"
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		// Step4:Enter all the details & Create new Organization
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		// Step5:Logout
		Thread.sleep(2000);
		WebElement Signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(Signout).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
}
