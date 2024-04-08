package com.day5_jdbc_coding;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class TESTScr {
	// INSERT
    public boolean testInsert(String id, String name){
    	System.out.println("testInsert 함수 진입 >>> : ");
    	
    	Connection conn=null;
    	PreparedStatement pstmt=null;
    	int nCnt=0;
    	Boolean bool=false;
    	TESTVO tvo=null;
    	
    	try{
    		// 커넥션 연결
    		conn=MysqlConnProperty.getConnection();
    		
    		// 쿼리문 받아오기
    		String sql=TESTQueryMap.testInsert();
    		pstmt=conn.prepareStatement(sql);
    		
    		System.out.println("INSERT :: sql >>> : \n"+sql);
    		
    		// setter
    		tvo=new TESTVO();
    		tvo.setId(id);
    		tvo.setName(name);
    		
    		// getter and PreparedStatement setString
    		pstmt.setString(1, tvo.getId());
    		pstmt.setString(2, tvo.getName());
    		
    		nCnt=pstmt.executeUpdate();
    		
    		// commit이 안 됐을 경우  commit
    		if(!conn.getAutoCommit()) conn.commit();
    		
    		System.out.println(nCnt+"건 등록되었음.");
    		if (nCnt>0) {bool=true;}
    		MysqlConnProperty.conClose(conn, pstmt);
    	}catch(Exception e){
    		System.out.println("testInsert 함수 내에서 에러 >>> : "+e.getMessage());
    	}finally{
    		MysqlConnProperty.conClose(conn, pstmt);
    	}
    	
    	return bool;
    }
    
    // SELECT ALL
    public ArrayList<TESTVO> testSelectAll(){
    	Connection conn=null;
    	PreparedStatement pstmt=null;
    	ResultSet rsRs=null;
    	ArrayList<TESTVO> arr=null;
    	TESTVO _tvo=null;
    	
    	try {
    		conn=MysqlConnProperty.getConnection();
    		String sql=TESTQueryMap.testSelectAll();
    		pstmt=conn.prepareStatement(sql);
    		System.out.println("전체 조회 >>> : \n"+sql);
    		rsRs=pstmt.executeQuery();
    		
    		if(rsRs!=null) {
    			arr=new ArrayList<TESTVO>();
    			
    			while(rsRs.next()){
    				_tvo=new TESTVO();
    				_tvo.setId(rsRs.getString(1)); // ID
    				_tvo.setName(rsRs.getString(2)); // NAME
    				_tvo.setInsertdate(rsRs.getString(3)); // INSERTDATE
    				_tvo.setUpdatedate(rsRs.getString(4)); // UPDATEDATE
    				_tvo.setDeleteyn(rsRs.getString(5)); // DELETEYN
    				
    				arr.add(_tvo);
    			} 
    		}else{
    			System.out.println("전체 조회 결과가 없습니다 >>> : "+rsRs);
    		}
    	}catch(Exception e){
    		System.out.println("전체조회중 에러가 >>> : "+e.getMessage());
    	}
    	
    	return arr;
    }
    
    // SELECT
    public ArrayList<TESTVO> testSelect(String id){
    	Connection conn=null;
    	PreparedStatement pstmt=null;
    	ResultSet rsRs=null;
    	ArrayList<TESTVO> arr=null;
    	TESTVO tvo=null;
    	TESTVO _tvo=null;
    	
    	try {
    		conn=MysqlConnProperty.getConnection();
    		String sql=TESTQueryMap.testSelect();
    		pstmt=conn.prepareStatement(sql);
    		System.out.println("조건 조회 >>> : \n"+sql);
    		
    		// setter
    		tvo=new TESTVO();
    		tvo.setId(id);
    		
    		pstmt.clearParameters();
    		// getter and PreparedStatement setString
    		pstmt.setString(1, tvo.getId());
    		
    		rsRs=pstmt.executeQuery();
    		
    		if(rsRs!=null) {
    			arr=new ArrayList<TESTVO>();
    			
    			while(rsRs.next()){
    				_tvo=new TESTVO();
    				_tvo.setId(rsRs.getString(1)); // ID
    				_tvo.setName(rsRs.getString(2)); // NAME
    				_tvo.setInsertdate(rsRs.getString(3)); // INSERTDATE
    				_tvo.setUpdatedate(rsRs.getString(4)); // UPDATEDATE
    				_tvo.setDeleteyn(rsRs.getString(5)); // DELETEYN
    				
    				arr.add(_tvo);
    			} 
    		}else{
    			System.out.println("조건 조회 결과가 없습니다 >>> : "+rsRs);
    		}
    	}catch(Exception e){
    		System.out.println("조건 조회중 에러가 >>> : "+e.getMessage());
    	}
    	
    	return arr;
    }
	public static void main(String[] args) {
		Scanner sc=null;
		sc=new Scanner(System.in);
		int ans=0;
		
		try{
			System.out.println("<<< TEST 테이블에서 데이터 조회 및 입력하기       	 \n");
			System.out.println("1 입력 :: 데이터를 추가합니다. (INSERT)  		 \n");
			System.out.println("2 입력 :: 데이터를  전체 조회합니다. (SELECT ALL) \n");
			System.out.println("3 입력 :: 데이터를  아이디로 조회합니다. (SELECT)   \n");
			System.out.println("0 입력 :: 취소하기   \n");
			
			ans=sc.nextInt();
			
			// INSERT
			if(ans==1){
				System.out.println(ans+"번을 입력하셨습니다.");
			
				String id=null;
				String name=null;
				Boolean bool=false;
				
				System.out.println("테스트ID를 입력하세요. >>> : \n");
				Scanner sc2=new Scanner(System.in);
				id=sc2.next();
				System.out.println("입력한 ID >>> : "+id);
				
				System.out.println("테스트 이름을 입력하세요 >>> :  \n");
				Scanner sc3=new Scanner(System.in);
				name=sc3.next();
				System.out.println("입력한 NAME >>> : "+name);
				
				TESTScr ts=new TESTScr();
				bool=ts.testInsert(id, name);
				if(bool){
					System.out.println("성공적으로 INSERT가 되었습니다.");
				}else{
					System.out.println("INSERT를 실패하였습니다  >>> : "+bool);
				}
			}
			
			// SELECT ALL
			if(ans==2){
				System.out.println(ans+"번을 입력하셨습니다.");
				
				ArrayList<TESTVO> arr=new ArrayList<TESTVO>();
				TESTScr ts=new TESTScr();
				
				arr= ts.testSelectAll();
				
				if(arr!=null&&arr.size()>0){
					System.out.print("ID : NAME : INSERTDATE : UPDATEDATE : DELETEYN \n");
					for (int i=0; i<arr.size(); i++){
						TESTVO _tvo=arr.get(i);
						_tvo.printTESTVO(_tvo);
					}
				}
			}
			
			// SELECT
			if(ans==3){
				System.out.println(ans+"번을 입력하셨습니다.");
				System.out.println("조회할 테스트ID를 입력하세요. >>> : \n");
				String id=null;
				Scanner sc2=new Scanner(System.in);
				id=sc2.next();
				System.out.println("입력한 id >>> : "+id);
				
				TESTScr ts=new TESTScr();
				ArrayList<TESTVO> arr=new ArrayList<TESTVO>();
				arr= ts.testSelect(id);
				
				if(arr!=null&&arr.size()>0){
					System.out.print("ID : NAME : INSERTDATE : UPDATEDATE : DELETEYN \n");
					for (int i=0; i<arr.size(); i++){
						TESTVO _tvo=arr.get(i);
						_tvo.printTESTVO(_tvo);
					}
				}
			}
			
			if(ans==0){
				System.out.println(ans+"번을 입력하셨습니다.");
				System.out.println(" 시스템을 종료합니다. ");
				sc.close();
				System.exit(0);
			}
		}catch(Exception e){
			System.out.println(" TEST 테이블에서 데이터 조회 및 입력하기 도중 실패 >>> : "+e.getMessage());
		}		
	} // end of main method
} // end of TESTScr class
