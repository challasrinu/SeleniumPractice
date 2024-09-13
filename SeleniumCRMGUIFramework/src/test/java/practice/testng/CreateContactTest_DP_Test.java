package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactTest_DP_Test {
@Test(dataProvider ="getdata")
public void createcontactTest(String firstname,String lastname) {
	System.out.println("firstname :"+firstname +", lastname:" +lastname);
}
@DataProvider
public Object[][] getdata() {
	Object[][] objarr=new Object[3][2];
	objarr[0][0]="srinivas";
	objarr[0][1]="challa";
	objarr[1][0]="madhu";
	objarr[1][1]="yaram";
	objarr[2][0]="usha";
	objarr[2][1]="golla";
	return objarr;
}
}