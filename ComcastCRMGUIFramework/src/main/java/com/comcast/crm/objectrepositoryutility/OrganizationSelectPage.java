package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationSelectPage {
	WebDriver driver;
	public OrganizationSelectPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="search_text")
	private WebElement SearchText;
	@FindBy(name="search")
	private WebElement searchBtn;
	public WebElement getSearchText() {
		return SearchText;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public void SelectOrg(String orgName) {
		getSearchText().sendKeys(orgName);
		getSearchBtn().click();

	}
}
