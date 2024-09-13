package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
public HomePage(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
@FindBy(linkText="Organizations")
private WebElement OrgLink;	


@FindBy(linkText="Contacts")
private WebElement ContactLink;

@FindBy(name="Campaigns")
private WebElement campaignslnk;

@FindBy(linkText="More")
private WebElement moreLink;

@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement adminImg;

@FindBy(linkText="Sign Out")
private WebElement signoutbtn;
public WebElement getOrgLink() {
	return OrgLink;
}


public WebElement getContactLink() {
	return ContactLink;
}	

public WebElement getCampaignslnk() {
	return campaignslnk;
}


public WebElement getMoreLink() {
	return moreLink;
}


public void navigateToCampaginPage() {
	Actions act=new Actions(driver);
	act.moveToElement(moreLink).perform();
	campaignslnk.click();
}
public void logout() {
	Actions act=new Actions(driver);
	act.moveToElement(adminImg).perform();
	signoutbtn.click();
}
}
