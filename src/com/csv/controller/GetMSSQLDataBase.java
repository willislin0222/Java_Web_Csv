package com.csv.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetMSSQLDataBase {
	
	private Connection conn =null;
	
	public GetMSSQLDataBase() throws SQLException{
		try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  //驅動程式-第四類
            this.conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=db01", "sa", "intumit");
            
        } catch (java.lang.ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
		
		
	}
	
	public Connection GetMSSQLConnecct(){
		return conn;
	}
	
}
