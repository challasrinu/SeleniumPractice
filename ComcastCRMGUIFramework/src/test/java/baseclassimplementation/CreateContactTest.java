package baseclassimplementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.basetest.BaseClass2;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationSelectPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
/**
 * @author Srinivas
 */
public class CreateContactTest extends BaseClass2{

@Test(groups= {"smokeTest"})
	 //read testScript data from Excel file
	public void createContactTest() throws Throwable {
		String lastName = eLib.getDataFromExcel("contact", 1, 2)+jLib.getRandonNum();
	//Step2:navigate to Contact page
	HomePage hp=new HomePage(driver);
	hp.getContactLink().click();
	//Step3:Click on "Create Contact Button"
	ContactsPage cp=new ContactsPage(driver);
	cp.getCreateNewContact().click();
	//Step4:Enter all the details & Create new Organization
	CreatingNewContactPage ccp=new CreatingNewContactPage(driver);
	ccp.createContact(lastName);
	//verify Header phone Number info Expected result
	String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();

//	if(actLastName.contains(LastName)) {
//		System.out.println(LastName + "LastName is verifies==PASS");
//	}
//	else {
//		System.out.println(LastName + "LastName is verifies==FAIL");
//	}
	String actHeader =cp.getHeaderMsg().getText();
	boolean status= actHeader.contains(lastName);
	Assert.assertEquals(status, true);
	SoftAssert soft=new SoftAssert();
	soft.assertEquals(actLastName,lastName);
	soft.assertAll();
//	if(actHeader.contains(LastName)) {
//		System.out.println(LastName+"Header is verified==PASS");
//	}
//	else {
//		System.out.println(LastName+"Header is verified==Fail");	
//	}
}
@Test(groups = "regression")
public void createcontactwithSupportDateTest()throws Throwable {
	//read testScript data from Excel file
	String LastName = eLib.getDataFromExcel("Contact",4,2)+jLib.getRandonNum();
	//Step2:navigate to Contact page
	 HomePage hp=new HomePage(driver);
	 hp.getContactLink().click();
	 ContactsPage cp=new ContactsPage(driver);
	 cp.getCreateNewContact().click();
	//Step4:Enter all the details & Create new Organization
	 CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
	String startDate = jLib.getSystemdateYYYYDDMM();
   String endDate = jLib.getRequiredDateYYYYDDMM(30);
  cncp.createContactwithSupportDate(LastName, startDate, endDate);
	//verify Header phone Number info Expected result
	//String actstartdate = driver.findElement(By.id("mouseArea_Support Start Date")).getText();
	String actstartdate = cp.getActStartDate().getText();
	if(actstartdate.contains(startDate)) {
		System.out.println(startDate + "startdate is verifies==PASS");
	}
	else {
		System.out.println(startDate + "startdate is not verifies==FAIL");
	}
	//String actenddate = driver.findElement(By.id("mouseArea_Support End Date")).getText();
	String actenddate = cp.getActEndDate().getText();
	if(actenddate.contains(endDate)) {
		System.out.println(endDate + "endDate is verifies==PASS");
	}
	else {
		System.out.println(endDate + "endDate is not verifies==FAIL");
	}
	
}
@Test(groups = "regression")
public void createcontactWithOrgTest() throws Throwable {
	String orgName = eLib.getDataFromExcel("Contact", 7, 2) + jLib.getRandonNum();
	String ContactLastName =eLib.getDataFromExcel("Contact", 7, 3);
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
	cncp.createContactwithOrg(ContactLastName, orgName);
	
	wLib.switchToTabOnURL(driver, "module=Accounts");
	OrganizationSelectPage osp=new OrganizationSelectPage(driver);
	osp.SelectOrg(orgName);
	
	driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	// switch to parent window
	wLib.switchToTabOnURL(driver, "Contacts&action");
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

}
}
