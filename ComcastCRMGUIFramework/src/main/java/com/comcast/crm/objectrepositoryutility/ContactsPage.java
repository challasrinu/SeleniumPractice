package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
    WebDriver driver;
    public ContactsPage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver,this);
    }
    @FindBy(className = "dvHeaderText")
    private WebElement HeaderMsg;
   
	public WebElement getHeaderMsg() {
		return HeaderMsg;
	}
	public WebElement getActEndDate() {
		return actEndDate;
	}
	@FindBy(id="mouseArea_Support Start Date")
	private WebElement actStartDate;
	
	@FindBy(id="mouseArea_Support End Date")
	private WebElement actEndDate;
	
	public WebElement getActStartDate() {
		return actStartDate;
	}
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createNewContact;

	@FindBy(linkText = "Sign Out")
	private WebElement signoutbtn;

	public WebElement getSignoutbtn() {
		return signoutbtn;
	}

	public WebElement getCreateNewContact() {
		return createNewContact;
	}
}
