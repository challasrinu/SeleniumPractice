package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
//Rule1 create a separte Java class same as webpage name
/**
 * @author Srinivas
 * 
 * Contains LoginPage elements and Business Library like Login 
 */
public class LoginPage extends WebDriverUtility {
//Rule2 Object creation	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver,this);
	}
@FindBy(name="user_name")
private WebElement usernameEdit;

@FindBy(name="user_password")
private WebElement passwordEdit;

@FindBy(id="submitButton")
private WebElement loginbtn;

//Rule 3: Object Initialization
//Rule 4:Object Encapsulation

public WebElement getUsernameEdit() {
	return usernameEdit;
}

public WebElement getPasswordEdit() {
	return passwordEdit;
}

public WebElement getLoginbtn() {
	return loginbtn;
}
//rule 5: provide action
/**
 * @author Srinivas
 * login to application based on username,password,url arguments
 * @param url
 * @param username
 * @param password
 */
public void loginToapp(String url,String username,String password) {
	waitForPageToLoad(driver);
	driver.get(url);
	usernameEdit.sendKeys("admin");
	passwordEdit.sendKeys("admin");
	loginbtn.click();
}

}



