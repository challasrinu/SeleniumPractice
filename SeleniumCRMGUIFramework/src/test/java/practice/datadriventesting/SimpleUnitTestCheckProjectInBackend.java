package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SimpleUnitTestCheckProjectInBackend {
@Test
public void projetchecktest() throws Throwable {
	boolean flag=false;
	String expectedcourse="Java1";
	//Step1:load/register the database driver
			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref);
			//Step2:Connect to database
			Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_sel","root","root");
			System.out.println("==Done==");
			//Step3:Create Sql Statement
			Statement state = Conn.createStatement();
			//step4://execute the query
			ResultSet resultset = state.executeQuery("select * from student");
			while(resultset.next()) {
				String Course = resultset.getString(4);
				if(expectedcourse.equals(Course)) {
					flag=true;
					System.out.println(expectedcourse +" is available==Pass");
				}
			}
				if(flag==false) {
					System.out.println(expectedcourse +" is not available==FAIL");
					Assert.fail();
				}
			
			//step5:close the database
			Conn.close();
}
}
