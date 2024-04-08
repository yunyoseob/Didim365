package basic;

public class Abstract_example2 {

	public static void main(String[] args) {
		String jdbc_driver=null;
		String jdbc_password=null;
		String jdbc_url=null;
		String jdbc_user=null;
		String connect=null;
		
		jdbc_driver=AbstractClass_example2.JDBC_DRIVER;
		jdbc_password=AbstractClass_example2.JDBC_PASSWORD;
		jdbc_url=AbstractClass_example2.JDBC_URL;
		jdbc_user=AbstractClass_example2.JDBC_USER;
		
		System.out.println("jdbc_driver >>> : "+jdbc_driver);
		System.out.println("jdbc_password >>> : "+jdbc_password);
		System.out.println("jdbc_url >>> : "+jdbc_url);
		System.out.println("jdbc_user >>> : "+jdbc_user);
		
		connect=AbstractClass_example2.getConnection();
		System.out.println("connect >>> : "+connect);
	}
}
