package basic;

public abstract class AbstractClass_example2 {
	public static final String JDBC_DRIVER="oracle.jdbc.driver.OracleDriver";
	public static final String JDBC_URL="jdbc:oracle:thin:@localhost:1521:xe";
	public static final String JDBC_USER="scott";
	public static final String JDBC_PASSWORD="tiger";
	
	public static String getConnection(){
		String conn="connect";
		
		try{
			if(conn.equals("connect")){
				System.out.println("Connect DataBase");
			}
		}catch(Exception e){
			System.out.println("Can't Connect DataBase >>> : "+e.getMessage());
		}
		return conn;
	}
}
