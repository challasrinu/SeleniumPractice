package pomimplementation;


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
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.fileutility.JsonUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class CreateContactWithSupportDateTest {
	@Test
  public void SupportDate() throws Throwable {
	ExcelUtility EU=new ExcelUtility();
	FileUtility FU=new FileUtility();
	JavaUtility JU=new JavaUtility();
	JsonUtility JS=new JsonUtility();
	     String BROWSER=FU.getDataFromPropertiesFile("browser");
	     String URL=FU.getDataFromPropertiesFile("url");
	     String USERNAME=FU.getDataFromPropertiesFile("username");
	     String PASSWORD=FU.getDataFromPropertiesFile("password");
	 //read testScript data from Excel file
		String LastName = EU.getDataFromExcel("Contact",4,2)+JU.getRandonNum();
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
	 LoginPage lp=new LoginPage(driver);
	 lp.loginToapp(URL, USERNAME, PASSWORD);
	//Step2:navigate to Contact page
	 HomePage hp=new HomePage(driver);
	 hp.getContactLink().click();
	 ContactsPage cp=new ContactsPage(driver);
	 cp.getCreateNewContact().click();
	//Step4:Enter all the details & Create new Organization
	 CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
	String startDate = JU.getSystemdateYYYYDDMM();
    String endDate = JU.getRequiredDateYYYYDDMM(30);
   cncp.createContactwithSupportDate(LastName, startDate, endDate);
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
	
}
}
