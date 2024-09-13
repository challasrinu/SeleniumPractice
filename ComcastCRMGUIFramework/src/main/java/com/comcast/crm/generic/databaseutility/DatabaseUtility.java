package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection con;
public void getDbconnection(String url,String username,String password) throws SQLException {
	try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
	    con = DriverManager.getConnection(url, username, password);
		
	} catch (Exception e) {
	}
}
public void getDbconnection() throws SQLException {
	try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
	    con = DriverManager.getConnection("jsbc:mysql://localhost:3306/adv_sel","root","root");
		
	} catch (Exception e) {
	}
}
	public void closeconnection() throws SQLException {
		try {
			con.close();
		} catch (Exception e) {
		}
	}
	public ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet result=null;
		try {
			Statement statement = con.createStatement();
			 result = statement.executeQuery(query);
			
		} catch (Exception e) {
		}
		return result;
	}
	public void executeNonSelectQuery(String query) {
		int result=0;
		try {
			Statement statement = con.createStatement();
			 result = statement.executeUpdate(query);
			
		} catch (Exception e) {
		}
	}
}

