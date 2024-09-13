package practice.contactTest;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactWithSupportDateTest {
public static void main(String[] args) throws Throwable {
	//read common data from Properties file
		FileInputStream fis=new FileInputStream("./configAppData/commondata.properties");
		Properties pObj=new Properties();
	    pObj.load(fis);
	     String BROWSER=pObj.getProperty("browser");
	     String URL=pObj.getProperty("url");
	     String USERNAME=pObj.getProperty("username");
	     System.out.println(USERNAME);
	     String PASSWORD=pObj.getProperty("password");
	 //generate the random number
	 Random random=new Random();
		int ran=random.nextInt(1000);
	 //read testScript data from Excel file
		FileInputStream fis1=new FileInputStream("./testdata/al.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet("Contact");
		Row row = sheet.getRow(4);
		String LastName = row.getCell(2).toString()+ran;
		wb.close();
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
	 //step1: Login to app
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
	driver.findElement(By.xpath("//input[@type='submit']")).submit();
	//Step2:navigate to Contact page
	driver.findElement(By.linkText("Contacts")).click();
	//Step3:Click on "Create Contact Button"
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	//Step4:Enter all the details & Create new Organization
	
	Date dateObj=new Date();
	SimpleDateFormat sim=new SimpleDateFormat("YYYY-MM-dd");
     String startDate = sim.format(dateObj);
 	Calendar cal=sim.getCalendar();
     cal.add(Calendar.DAY_OF_MONTH,30);
    String endDate= sim.format(cal.getTime());
     
	driver.findElement(By.name("lastname")).sendKeys(LastName);
	driver.findElement(By.name("support_start_date")).clear();
	driver.findElement(By.name("support_start_date")).sendKeys(startDate);
	driver.findElement(By.name("support_end_date")).clear();
	driver.findElement(By.name("support_end_date")).sendKeys(endDate);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//verify Header phone Number info Expected result
	String actstartdate = driver.findElement(By.id("mouseArea_Support Start Date")).getText();
	if(actstartdate.contains(startDate)) {
		System.out.println(startDate + "startdate is verifies==PASS");
	}
	else {
		System.out.println(startDate + "startdate is not verifies==FAIL");
	}
	String actenddate = driver.findElement(By.id("mouseArea_Support End Date")).getText();
	if(actenddate.contains(endDate)) {
		System.out.println(endDate + "endDate is verifies==PASS");
	}
	else {
		System.out.println(endDate + "endDate is not verifies==FAIL");
	}
	//Step5:Logout
	Thread.sleep(2000);
	WebElement Signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act=new Actions(driver);
	act.moveToElement(Signout).perform();
	driver.findElement(By.linkText("Sign Out")).click();

	driver.quit();
}
}
