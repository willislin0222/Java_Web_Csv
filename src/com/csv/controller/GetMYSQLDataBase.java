package com.csv.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetMYSQLDataBase {
	
	private Connection conn =null;
	
	public GetMYSQLDataBase() throws SQLException{
		try {
            Class.forName("com.mysql.jdbc.Driver");  //驅動程式-第四類
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db01", "root", "1234");
            
        } catch (java.lang.ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
		
		
	}
	
	public Connection GetMYSQLConnecct(){
		return conn;
	}
}
