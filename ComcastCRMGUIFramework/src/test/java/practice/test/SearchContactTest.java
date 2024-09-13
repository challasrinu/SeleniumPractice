package practice.test;
/**
 * test class for Contact module
 * @author Srinivas
 * contains Login Page elements & business library like login()

 */

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass2;
import com.comcast.crm.objectrepositoryutility.LoginPage;



public class SearchContactTest extends BaseClass2{
	/**
	 * @author Srinivas
	 *  Scenario :login()==> navigateContact==>createcontact()==verify
	 */
 @Test
 public void searchcontactTest() {
	 /*step 1: login to application*/
	 LoginPage lp=new LoginPage(driver);
	 lp.loginToapp("url","username","pass");
 }
}
