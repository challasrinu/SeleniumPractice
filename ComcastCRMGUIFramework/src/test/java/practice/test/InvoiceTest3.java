package practice.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.comcast.crm.basetest.BaseClass2;
@Listeners(com.comcast.crm.listnerutility.ListnerImpClass.class)
public class InvoiceTest3 extends BaseClass2{
@Test
public void createInvoiceTest() {
	System.out.println("execute createInvoiceTest");
	String acttitle = driver.getTitle();
	Assert.assertEquals(acttitle,"Login");
	System.out.println("step-1");
	System.out.println("step-2");
	System.out.println("step-3");
	System.out.println("step-4");
	
}
@Test
public void creatInvoicewithContactTest() {
	System.out.println("execute createInvoicewithContactTest");
	System.out.println("step-1");
	System.out.println("step-2");
	System.out.println("step-3");
	System.out.println("step-4");
}
}
