package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleTest {
public static void main(String[] args) throws Throwable {
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
		System.out.println(resultset.getString(2) + "\t"+resultset.getString(3));
	}
	//step5:close the database
	Conn.close();
	
}
}
