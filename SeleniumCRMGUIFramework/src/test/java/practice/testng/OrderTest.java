package practice.testng;

import org.testng.annotations.Test;

public class OrderTest {

@Test(invocationCount = 10)
public void createOrdertest() {
	System.out.println("Execute createOrder==>123");
}
@Test(enabled = false)
public void billingOrderTest() {
	System.out.println("Execute billingAnOrderTest===>123");
}
}
