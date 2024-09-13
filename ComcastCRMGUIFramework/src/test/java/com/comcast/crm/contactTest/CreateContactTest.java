package com.comcast.crm.contactTest;

import java.io.FileInputStream;
import java.time.Duration;
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

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class CreateContactTest {
public static void main(String[] args) throws Throwable {
	//Create Object Utility
	FileUtility fu=new FileUtility();
	ExcelUtility EU=new ExcelUtility();
	JavaUtility JU=new JavaUtility();
	WebDriverUtility WU=new WebDriverUtility();
	String URL = fu.getDataFromPropertiesFile("url");
	String BROWSER=fu.getDataFromPropertiesFile("browser");
	String USERNAME = fu.getDataFromPropertiesFile("username");
	String PASSWORD = fu.getDataFromPropertiesFile("password");
	 //read testScript data from Excel file
	
		String LastName = EU.getDataFromExcel("contact", 1, 2)+JU.getRandonNum();
	
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
	 
	//Login
	LoginPage lp=new LoginPage(driver);
	lp.loginToapp(URL,"admin","admin");
	//Step2:navigate to Contact page
	HomePage hp=new HomePage(driver);
	hp.getContactLink().click();
	//Step3:Click on "Create Contact Button"
	ContactsPage cp=new ContactsPage(driver);
	cp.getCreateNewContact().click();
	//Step4:Enter all the details & Create new Organization
	CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
	cncp.createContact(LastName);
	//verify Header phone Number info Expected result
	String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
	if(actLastName.contains(LastName)) {
		System.out.println(LastName + "LastName is verifies==PASS");
	}
	else {
		System.out.println(LastName + "LastName is verifies==FAIL");
	}
	//Step5:Logout
	Thread.sleep(2000);
	cp.getSignoutbtn().click();

	driver.quit();
}
}
