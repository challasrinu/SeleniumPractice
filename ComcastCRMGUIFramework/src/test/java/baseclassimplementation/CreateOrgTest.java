package baseclassimplementation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.basetest.BaseClass2;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
@Listeners(com.comcast.crm.listnerutility.ListnerImpClass.class)
public class CreateOrgTest extends BaseClass2{
@Test(groups = "smoke")
public void createOrganizationTest() throws Throwable {
	//ListnerImpClass.test.log(Status.INFO,"read data from Excel");
	UtilityClassObject.getTest().log(Status.INFO,"read data from Excel");
	
	String orgName = eLib.getDataFromExcel("org",1,2)+jLib.getRandonNum();
	wLib.waitForPageToLoad(driver);
	
	//Step2:navigate to Organization page
	//ListnerImpClass.test.log(Status.INFO,"Navigate to Org Page");
	UtilityClassObject.getTest().log(Status.INFO,"Navigate to Org Page");
	HomePage hp=new HomePage(driver);
	hp.getOrgLink().click();
	
	//Step3:Click on "Create Organization Button"
	//ListnerImpClass.test.log(Status.INFO,"navigate to CreateOrg Page");
	UtilityClassObject.getTest().log(Status.INFO,"navigate to CreateOrg Page");
	OrganizationsPage op=new OrganizationsPage(driver);
	op.getCreateNewOrgBtn().click();
	//Step4:Enter all the details & Create new Organization;
	//ListnerImpClass.test.log(Status.INFO,"Create a new Org");
	UtilityClassObject.getTest().log(Status.INFO,"Create a new Org");
	CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
	cnop.createOrg(orgName);
	//ListnerImpClass.test.log(Status.INFO,orgName+"===>Create a new org");
	UtilityClassObject.getTest().log(Status.INFO,orgName+"===>Create a new org");
	//verify Header msg Expected result
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String actOrgName=oip.getHeaderMsg().getText();
	Assert.assertEquals(true,actOrgName.contains(orgName));
//	if(actOrgName.contains(orgName)) {
//		System.out.println(orgName +"name is verified == PASS");
//	}else {
//		System.out.println(orgName +"name is not verified ==FAIL");
//	}
}
@Test(groups = "regression")
public void createOrgWithIndustries() throws Throwable {

	String orgName = eLib.getDataFromExcel("org",4,2)+jLib.getRandonNum();
	String industryname = eLib.getDataFromExcel("org",4,3);
	String Type = eLib.getDataFromExcel("org",4,4);
	wLib.waitForPageToLoad(driver);
	//Step2:navigate to Organization page
	HomePage hp=new HomePage(driver);
	hp.getOrgLink().click();
	//Step3:Click on "Create Organization Button"
	OrganizationsPage op=new OrganizationsPage(driver);
	op.getCreateNewOrgBtn().click();
	//Step4:Enter all the details & Create new Organization
	CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
	cnop.createOrg(orgName, industryname);
	cnop.CreateOrg(orgName, Type);
	//Verify the industries and type info
	String actIndustries = driver.findElement(By.id("dtlview_Industry")).getText();
	if(actIndustries.equals(industryname)) {
		System.out.println(actIndustries  + "information is verified==PASS");
	}
	else {
		System.out.println(actIndustries  + "information is not verified==FAIL");
	}
	 String actType = driver.findElement(By.id("dtlview_Type")).getText();
	if(actType.equals(Type)) {
		System.out.println(actType + "information is verified==PASS");
	}
	else {
		System.out.println(actType+ "information is not verified==FAIL");
	}
}
@Test(groups = "regression")
public void createorgWithPhoneNumber() throws Throwable {
	String orgName = eLib.getDataFromExcel("org",7,2)+jLib.getRandonNum();
	String phoneNumber = eLib.getDataFromExcel("org",7,3);
	wLib.waitForPageToLoad(driver);
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
}
}
