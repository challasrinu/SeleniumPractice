package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactTest_DP_3Data_Test {
@Test(dataProvider ="getdata")
public void createcontactTest(String firstname,String lastname,long phonenumber) {
	System.out.println("firstname :"+firstname +", lastname:" +lastname +", phonenumber:" +phonenumber);
}
@DataProvider
public Object[][] getdata() {
	Object[][] objarr=new Object[3][3];
	objarr[0][0]="srinivas";
	objarr[0][1]="challa";
	objarr[0][2]=995201234;
	objarr[1][0]="madhu";
	objarr[1][1]="yaram";
	objarr[1][2]=986602132;
	objarr[2][0]="usha";
	objarr[2][1]="golla";
	objarr[2][2]=856242354;
	return objarr;
}
}