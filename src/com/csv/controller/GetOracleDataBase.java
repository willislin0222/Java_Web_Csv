package com.csv.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetOracleDataBase {
	
	private Connection conn =null;
	
	public GetOracleDataBase() throws SQLException{
		try {
            Class.forName("oracle.jdbc.driver.OracleDriver");  //驅動程式-第四類
            this.conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "DEMO", "DEMO");
            
        } catch (java.lang.ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
		
		
	}
	
	public Connection GetOracleConnecct(){
		return conn;
	}
	
}
