package practice.testng;

import org.testng.annotations.Test;

public class ContactTest{
	@Test
public void createContactTest() {
	System.out.println("execute createContact with-->HDFC");
} 
@Test(dependsOnMethods = "createContactTest")
public void modifyContactTest() {
	System.out.println("create contact HDFC==>ICICI");
}
@Test(dependsOnMethods ="modifyContactTest" )
public void deleteContactTest() {
	System.out.println("execute deleteContactTest ICICI");
}
}
