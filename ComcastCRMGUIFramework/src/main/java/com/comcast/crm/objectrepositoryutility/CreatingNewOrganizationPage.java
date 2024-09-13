package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
		WebDriver driver;
		public CreatingNewOrganizationPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements( driver,this);
			
		}
	@FindBy(name="accountname")
	private WebElement orgNameEdit;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	@FindBy(name="industry")
	private WebElement industryDD;
	@FindBy(name="accounttype")
	private WebElement accounttypeDD;
	@FindBy(name="phone")
	private WebElement phonenum;

	public WebElement getPhonenum() {
		return phonenum;
	}

	public WebElement getOrgNameEdit() {
		return orgNameEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
public void  createOrg(String orgName) {
	orgNameEdit.sendKeys(orgName);//from excel
	saveBtn.click();
}
public void  createOrg(String orgName,String industry) {

	orgNameEdit.sendKeys(orgName);//from excel
	Select sel=new Select(industryDD);
	sel.selectByVisibleText(industry);
	
}
public void CreateOrg(String orgName,String accounttype) {
	orgNameEdit.sendKeys(orgName);
	Select sel=new Select(accounttypeDD);
	sel.selectByVisibleText(accounttype);
	saveBtn.click();
}
	}

