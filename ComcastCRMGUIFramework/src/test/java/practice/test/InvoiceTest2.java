package practice.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.comcast.crm.basetest.BaseClass2;

public class InvoiceTest2 extends BaseClass2{
@Test(retryAnalyzer =com.comcast.crm.listnerutility.RetryListnerImp.class)
public void createInvoiceTest() {
	System.out.println("execute createInvoiceTest");
	//String acttitle = driver.getTitle();
	Assert.assertEquals("","TIger");
	
}

}
