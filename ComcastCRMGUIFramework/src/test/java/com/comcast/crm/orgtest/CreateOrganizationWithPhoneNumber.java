package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationWithPhoneNumber {
public static void main(String[] args) throws Throwable { 
	FileUtility FU=new FileUtility();
	ExcelUtility EU=new ExcelUtility();
	JavaUtility JU=new JavaUtility();
	WebDriverUtility WU=new WebDriverUtility();
	//read common data from Properties file
	FileInputStream fis=new FileInputStream("E:\\data/commondata.properties");
	Properties pObj=new Properties();
    pObj.load(fis);
     String BROWSER=FU.getDataFromPropertiesFile("browser");
     String URL=FU.getDataFromPropertiesFile("url");
     String USERNAME=FU.getDataFromPropertiesFile("username");
     String PASSWORD=FU.getDataFromPropertiesFile("password");
 //read testScript data from Excel file
	String orgName = EU.getDataFromExcel("org",7,2)+JU.getRandonNum();
	String phoneNumber = EU.getDataFromExcel("org",7,3);
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
WU.waitForPageToLoad(driver);
LoginPage lp=new LoginPage(driver);
lp.loginToapp(URL,"admin","admin");
//Step2:navigate to Organization page
HomePage hp=new HomePage(driver);
hp.getOrgLink().click();
//Step3:Click on "Create Organization Button"
OrganizationsPage op=new OrganizationsPage(driver);
op.getCreateNewOrgBtn().click();
//Step4:Enter all the details & Create new Organization
CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
cnop.createOrg(orgName);
cnop.getPhonenum().sendKeys(phoneNumber);
cnop.getSaveBtn();
//Verify the industries and type info
String actNum = driver.findElement(By.id("dtlview_Phone")).getText();
if(actNum.equals(phoneNumber)) {
	System.out.println(actNum+"PhoneNumber is verified==PASS");
}
else {
	System.out.println(actNum+"PhoneNumber is not verified==FAIL");
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
