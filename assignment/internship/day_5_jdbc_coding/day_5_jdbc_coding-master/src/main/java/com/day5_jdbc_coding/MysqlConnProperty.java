package com.day5_jdbc_coding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class MysqlConnProperty {
	// Mysql information
	public static final String JDBC_URL="jdbc:mysql://158.247.206.97:31307/?user=imyoseob&useSSL=false";
	public static final String JDBC_USER="imyoseob";
	public static final String JDBC_PASSWORD="imyoseob";
		
	// Connection 연결하는 함수 만들기
	public static Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
		}catch(Exception e){
			System.out.println("데이터 베이스 연결에 문제가 있습니다 >>> : "+e.getMessage());
		}
		return conn;
	}
		
    // Connection 연결 중단하는 함수 만들기
    // method overloading
    public static void conClose(Connection conn, PreparedStatement pstmt, ResultSet rsRs){
    	try {
    		if (rsRs != null) try { rsRs.close(); rsRs = null; } catch(Exception ex){}
    		if (pstmt != null) try { pstmt.close(); pstmt = null; } catch(Exception ex){}
    		if (conn != null) try { conn.close(); conn = null; } catch(Exception ex){}
    	}catch(Exception e2){}
	}
		
	public static void conClose(Connection conn, PreparedStatement pstmt){
		try{
			if (pstmt != null) try { pstmt.close(); pstmt = null; } catch(Exception ex){}
			if (conn != null) try { conn.close(); conn = null; } catch(Exception ex){}
		}catch (Exception e2){}		
	}
}