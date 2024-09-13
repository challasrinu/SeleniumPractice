 package com.comcast.crm.basetest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

import lombok.experimental.UtilityClass;

public class BaseClass2 {
	//Create Object Utility
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public DatabaseUtility dbLib=new DatabaseUtility();
	public FileUtility fLib=new FileUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	 public WebDriver driver=null;
	 public static WebDriver sdriver=null;
	@BeforeSuite()
	public void configBS() throws SQLException {
		System.out.println("===connect to DB and report config");
		dbLib.getDbconnection();
		
	}
	@AfterSuite()
	public void configAS() throws SQLException {
		dbLib.closeconnection();
		System.out.println("Close DB,Report backup");
	}
	
	@BeforeClass(groups = {"smoke","regression"})
	public void configBC() throws Throwable {
		System.out.println("==Launch the browser==");
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		 if (BROWSER.equalsIgnoreCase("chrome")) {
			  driver=new ChromeDriver();
		 }
		 else if(BROWSER.equalsIgnoreCase("firefox")) {
			  driver=new FirefoxDriver();
		 }
		 else if(BROWSER.equalsIgnoreCase("edge")) {
			  driver=new EdgeDriver();
		 }
		 else {
			  driver=new ChromeDriver();
	}
		 sdriver=driver;
		 UtilityClassObject.setDriver(driver);
	}
	@AfterClass(groups = {"smoke","regression"} )
	public void configAC() {
		System.out.println("===Close the Browser===");
		driver.quit();
	}
	@BeforeMethod()
	public void configBM() throws Throwable {
		 System.out.println("===Login to App===");
		String URL = fLib.getDataFromPropertiesFile("url");
		String Username = fLib.getDataFromPropertiesFile("username");
		String Password = fLib.getDataFromPropertiesFile("password");
 		LoginPage lp=new LoginPage(driver);
		lp.loginToapp(URL,Username,Password);
	   }
	 @AfterMethod()
	   public void configAM() {
 		   System.out.println("===Logout the Browser===");
		   HomePage hp=new HomePage(driver);
		   hp.logout();
	   }
}
