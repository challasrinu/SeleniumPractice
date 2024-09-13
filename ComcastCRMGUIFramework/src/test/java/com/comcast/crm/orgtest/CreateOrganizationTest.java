package com.comcast.crm.orgtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationTest {
public static void main(String[] args) throws Throwable {
	//read common data from Properties file
	FileUtility fu=new FileUtility();
	ExcelUtility EU=new ExcelUtility();
	JavaUtility JU=new JavaUtility();
	WebDriverUtility wLib=new WebDriverUtility();
     String BROWSER=fu.getDataFromPropertiesFile("browser");
     String URL=fu.getDataFromPropertiesFile("url");
     String USERNAME=fu.getDataFromPropertiesFile("username");
     String PASSWORD=fu.getDataFromPropertiesFile("password");
 //read testScript data from Excel file
	String orgName = EU.getDataFromExcel("org",1,2)+JU.getRandonNum();
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
 wLib.waitForPageToLoad(driver);
LoginPage lp=new LoginPage(driver);
lp.loginToapp(URL,"admin","admin");

//Step2:navigate to Organization page
HomePage hp=new HomePage(driver);
hp.getOrgLink().click();

//Step3:Click on "Create Organization Button"
OrganizationsPage op=new OrganizationsPage(driver);
op.getCreateNewOrgBtn().click();

//Step4:Enter all the details & Create new Orga;
CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
cnop.createOrg(orgName);
//verify Header msg Expected result
OrganizationInfoPage oip=new OrganizationInfoPage(driver);
String actOrgName=oip.getHeaderMsg().getText();
if(actOrgName.contains(orgName)) {
	System.out.println(orgName +"name is verified == PASS");
}else {
	System.out.println(orgName +"name is not verified ==FAIL");
}
//Verify Header orgName info Expected Result

//Step5:Logout
hp.logout();
driver.quit();
}
}
