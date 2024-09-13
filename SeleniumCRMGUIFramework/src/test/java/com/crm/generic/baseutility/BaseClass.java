package com.crm.generic.baseutility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	@BeforeSuite
	public void configBS() {
		System.out.println("===connect to DB and report config");
	}
	@AfterSuite
	public void configAS() {
		System.out.println("Close DB,Report backup");
	}
	@BeforeClass
	public void configBC() {
		System.out.println("==Launch the browser==");
	}
	@AfterClass
	public void configAC() {
		System.out.println("===Close the Browser===");
	}
	@BeforeMethod
	public void configBM() {
    System.out.println("===Login to App===");
	   }
	 @AfterMethod
	   public void configAM() {
		   System.out.println("===Logout the Browser===");
	   }
}
