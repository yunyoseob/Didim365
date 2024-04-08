package com.day5_jdbc_coding;

public abstract class TESTQueryMap {
	// 전체 조회
    public static String testSelectAll(){
    	StringBuffer sb=new StringBuffer();
    	sb.append("SELECT ID, NAME, INSERTDATE, UPDATEDATE, DELETEYN     \n");
    	sb.append("FROM imyoseob.TEST \n");
    	sb.append("ORDER BY ID ASC \n");
    	
    	return sb.toString();
    }
    
    // ID 조건 조회
    public static String testSelect(){
    	StringBuffer sb=new StringBuffer();
    	sb.append("SELECT ID, NAME, INSERTDATE, UPDATEDATE, DELETEYN      \n");
    	sb.append("FROM imyoseob.TEST   \n");
    	sb.append("WHERE ID=?           \n");
    	sb.append("ORDER BY ID ASC      \n");
    	
    	return sb.toString();
    }
    
    // INSERT
    public static String testInsert(){
    	StringBuffer sb=new StringBuffer();
    	sb.append("INSERT INTO imyoseob.TEST(ID, NAME, INSERTDATE, UPDATEDATE, DELETEYN)     \n");
    	sb.append("VALUES (?,          											\n"); // place holder 1
    	sb.append("  	   ?,          											\n"); // place holder 2
    	sb.append("        sysdate(),  												\n");
    	sb.append("        sysdate(),  												\n");
    	sb.append("        'Y'        ) 											\n");
    		
    	return sb.toString();
    }
}
