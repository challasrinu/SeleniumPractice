package pomimplementation;

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
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationSelectPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateContactWithOrgTest {
@Test
public void createContactwithOrg() throws Throwable {
		ExcelUtility EU = new ExcelUtility();
		FileUtility FU = new FileUtility();
		JavaUtility JU = new JavaUtility();
		WebDriverUtility WU = new WebDriverUtility();
		String BROWSER = FU.getDataFromPropertiesFile("browser");
		String URL = FU.getDataFromPropertiesFile("url");
		String USERNAME = FU.getDataFromPropertiesFile("username");
		String PASSWORD = FU.getDataFromPropertiesFile("password");
		// read testScript data from Excel file
		String orgName = EU.getDataFromExcel("Contact", 7, 2) + JU.getRandonNum();
		String ContactLastName = EU.getDataFromExcel("Contact", 7, 3);
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
		WU.waitForPageToLoad(driver);
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp(URL, USERNAME, PASSWORD);
//Step2:navigate to Organization page
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
//Step3:Click on "Create Organization Button"
		OrganizationsPage Op = new OrganizationsPage(driver);
		Op.getCreateNewOrgBtn().click();
//Step4:Enter all the details & Create new Organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);
//verify Header msg Expected result
		String HeaderInfo = driver.findElement(By.className("dvHeaderText")).getText();
		if (HeaderInfo.contains(orgName)) {
			System.out.println(orgName + "header is Verified==PASS");
		} else {
			System.out.println(orgName + "header is Verified==FAIL");
		}

//Step5:navigate to Contact page
		hp.getContactLink().click();
		// Step6:Click on "Create Contact Button"
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateNewContact().click();
		// Step7:Enter all the details & Create new Organization
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		cncp.getLastnameEdt().sendKeys(ContactLastName);
		cncp.getOrgImgSelectBtn().click();
		// Switch to child window
		WU.switchToTabOnURL(driver, "module=Accounts");
		OrganizationSelectPage osp=new OrganizationSelectPage(driver);
		osp.SelectOrg(orgName);
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		// switch to parent window
		WU.switchToTabOnURL(driver, "Contacts&action");
		cncp.getSavebtn().click();
		// verify Header phoneNumber Info Expected Result
		// verify Header msg Expected result
		HeaderInfo = driver.findElement(By.className("dvHeaderText")).getText();
		if (HeaderInfo.contains(ContactLastName)) {
			System.out.println(ContactLastName + "is created==PASS");
		} else {
			System.out.println(ContactLastName + "is created==FAIL");
		}
		// Verify Header orgName info Expected Result
		String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		System.out.println(actOrgName);
		if (actOrgName.trim().equals(orgName)) {
			System.out.println(orgName + "Information is created==PASS");
		} else {
			System.out.println(orgName + "Information is created==FAIL");
		}
//Step6:Logout
		Thread.sleep(2000);
		WebElement Signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(Signout).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
}
