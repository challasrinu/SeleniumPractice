package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteNonSelectQuery {
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
			int result = state.executeUpdate("insert into student values('510','venkata','9866021327','manualtest');");
			System.out.println(result);
		
			//step5:close the database
			Conn.close();
}
}
