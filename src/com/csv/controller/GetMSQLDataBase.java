package com.csv.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetMSQLDataBase {
	
	private Connection conn =null;
	
	public GetMSQLDataBase() throws SQLException{
		try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  //驅動程式-第四類
            
        } catch (java.lang.ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
		
		this.conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=db01", "sa", "intumit");
	}
	
}
