package com.comcast.crm.generic.webdriverutility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject {
public static ThreadLocal<ExtentTest> test= new ThreadLocal<ExtentTest>();
public static ThreadLocal<WebDriver> driver= new ThreadLocal<WebDriver>();

public static ExtentTest getTest() {
	return test.get();//this method gives the extent report object for the multiple object for multiple threads it will use in parallel execution
}
 
public static void setTest(ExtentTest actTest) {
	test.set(actTest);
}
public static WebDriver getdriver() {
	return driver.get();//this method gives the extent report object for the multiple object for multiple threads it will use in parallel execution
}
 
public static void setDriver(WebDriver actDriver) {
	driver.set(actDriver);
}
}
