package practice.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.comcast.crm.basetest.BaseClass2;

public class InvoiceSuiteLevelTest extends BaseClass2{
@Test
public void createInvoiceTest() {
	System.out.println("execute createInvoiceTest");
	String acttitle = driver.getTitle();
	Assert.assertEquals(acttitle,"TIger");
	System.out.println("step-1");
	System.out.println("step-2");
	System.out.println("step-3");
	System.out.println("step-4");
}
@Test
public void createInvoicewithContactTest() {
	System.out.println("execute createInvoiceTest");
	System.out.println("step-1");
	System.out.println("step-2");
	System.out.println("step-3");
	System.out.println("step-4");
}
}
