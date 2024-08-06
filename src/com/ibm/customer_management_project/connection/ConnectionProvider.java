package com.ibm.customer_management_project.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	
	public static Connection geTheConnection()
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/customer-management-project";
			String user="root";
			String pass="root";
			
			return DriverManager.getConnection(url,user,pass);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

}
