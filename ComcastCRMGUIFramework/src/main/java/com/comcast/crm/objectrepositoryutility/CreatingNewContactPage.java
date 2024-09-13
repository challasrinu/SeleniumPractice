package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	WebDriver driver;
	public CreatingNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "lastname")
	private WebElement lastnameEdt;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	@FindBy(name = "support_start_date")
	private WebElement supportstartdate;
	@FindBy(name = "support_end_date")
	private WebElement supportEndDate;
    @FindBy(xpath="//img[@alt='Select']")
    private WebElement orgImgSelectBtn;
	public WebElement getOrgImgSelectBtn() {
		return orgImgSelectBtn;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getSupportstartdate() {
		return supportstartdate;
	}

	public WebElement getSupportEndDate() {
		return supportEndDate;
	}

	public void createContact(String lastname) {
		getLastnameEdt().sendKeys(lastname);
		getSavebtn().click();
	}

	public void createContactwithSupportDate(String lastname, String startDate, String endDate) {
		getLastnameEdt().sendKeys(lastname);
		getSupportstartdate().sendKeys(startDate);
		getSupportEndDate().clear();
		getSupportEndDate().sendKeys(endDate);
		getSavebtn().click();
	}
	public void createContactwithOrg(String lastname,String orgName) {
		getLastnameEdt().sendKeys(lastname);
		getOrgImgSelectBtn().click();
	}
	
}