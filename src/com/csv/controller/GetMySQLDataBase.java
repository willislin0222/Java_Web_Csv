package com.csv.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetMySQLDataBase {
	
	private Connection conn =null;
	
	public GetMySQLDataBase() throws SQLException{
		try {
            Class.forName("com.mysql.jdbc.Driver");  //驅動程式-第四類
            
        } catch (java.lang.ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
		
		this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db01", "root", "1234");
	}
	
}
