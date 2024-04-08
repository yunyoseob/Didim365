package com.day5_jdbc_coding;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnectionTest {

	public static void main(String[] args) {
		Connection conn;
		
		try {
			// 1. 드라이버 로딩
			System.out.println("드라이버 로딩 시작 >>> :");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 완료 >>> : ");
			// 2. 연결하기
			System.out.println("연결하기 시작 >>> : ");
			String url="jdbc:mysql://158.247.206.97:31307/?user=imyoseob&useSSL=false";
			conn=DriverManager.getConnection(url, "imyoseob", "imyoseob");
			System.out.println("연결 성공");
			
		}catch(Exception e){
			System.out.println("DB연결오류 >>> : "+e.getMessage());
		}
	}

}
