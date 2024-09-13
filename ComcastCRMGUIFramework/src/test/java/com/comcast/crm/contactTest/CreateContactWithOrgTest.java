package com.comcast.crm.contactTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithOrgTest {
public static void main(String[] args) throws Throwable {
	ExcelUtility EU=new ExcelUtility();
	FileUtility FU=new FileUtility();
	JavaUtility JU=new JavaUtility();
	WebDriverUtility WU=new WebDriverUtility();
     String BROWSER=FU.getDataFromPropertiesFile("browser");
     String URL=FU.getDataFromPropertiesFile("url");
     String USERNAME=FU.getDataFromPropertiesFile("username");
     String PASSWORD=FU.getDataFromPropertiesFile("password");
 //read testScript data from Excel file
	String orgName = EU.getDataFromExcel("Contact",7,2)+JU.getRandonNum();
	String ContactLastName = EU.getDataFromExcel("Contact",7,3);
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
 
 driver.get(URL);
driver.findElement(By.name("user_name")).sendKeys(USERNAME);
driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
driver.findElement(By.xpath("//input[@type='submit']")).submit();
//Step2:navigate to Organization page
driver.findElement(By.linkText("Organizations")).click();
//Step3:Click on "Create Organization Button"
driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//Step4:Enter all the details & Create new Organization
driver.findElement(By.name("accountname")).sendKeys(orgName);
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//verify Header msg Expected result
String HeaderInfo = driver.findElement(By.className("dvHeaderText")).getText();
if(HeaderInfo.contains(orgName)) {
	System.out.println(orgName + "header is Verified==PASS");
}
else {
	System.out.println(orgName + "header is Verified==FAIL");
}

//Step5:navigate to Contact page
	driver.findElement(By.linkText("Contacts")).click();
	//Step6:Click on "Create Contact Button"
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	//Step7:Enter all the details & Create new Organization
	driver.findElement(By.name("lastname")).sendKeys(ContactLastName);
     // Step8:verify Header phone Number info Expected result
//	String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
//	if(actLastName.contains(ContactLastName)) {
//		System.out.println(ContactLastName + "LastName is verifies==PASS");
//	}
//	else {
//		System.out.println(ContactLastName + "LastName is verifies==FAIL");
//	}
//	
	driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
	//Switch to child window
	WU.switchToTabOnURL(driver,"module=Accounts");

	driver.findElement(By.name("search_text")).sendKeys(orgName);
	driver.findElement(By.name("search")).click();
	driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	//switch to parent window
	 WU.switchToTabOnURL(driver,"Contacts&action");
//	Set<String> set1 = driver.getWindowHandles();
//	Iterator<String> it1=set1.iterator();
//	while(it1.hasNext()) {
//		String wid = it1.next();
//		driver.switchTo().window(wid);
//		String actUrl = driver.getCurrentUrl();
//		if(actUrl.contains("Contacts&action")) {
//			break;
//		}
//	}
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//verify Header phoneNumber Info Expected Result
	//verify Header msg Expected result
	 HeaderInfo = driver.findElement(By.className("dvHeaderText")).getText();
	if(HeaderInfo.contains(ContactLastName)) {
		System.out.println(ContactLastName  + "is created==PASS");
	}
	else {
		System.out.println(ContactLastName  + "is created==FAIL");
	}
	//Verify Header orgName info Expected Result
	String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
	System.out.println(actOrgName);
	if(actOrgName.trim().equals(orgName)) {
		System.out.println(orgName + "Information is created==PASS");
	}
	else {
		System.out.println(orgName + "Information is created==FAIL");
	}
//Step6:Logout
Thread.sleep(2000);
WebElement Signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
Actions act=new Actions(driver);
act.moveToElement(Signout).perform();
driver.findElement(By.linkText("Sign Out")).click();
driver.quit();
}
}
